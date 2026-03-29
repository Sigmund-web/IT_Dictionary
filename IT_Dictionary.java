package Dictionary;

import java.util.*;
 
public class IT_Dictionary {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static String cleanInput;

    // SEARCH HISTORY FEATURE
    static String[] searchHistory = new String[10];
    static int historyCount = 0;
    static String wordOfTheDay = "";

    public static void main(String[] args) {
        // Generate Word of the Day once at the start
        if (Data.data.length > 0) {
            int wordOfTheDayIndex = random.nextInt(Data.data.length);
            wordOfTheDay = Data.data[wordOfTheDayIndex];
        }
        
        run();
    }

    static void run() {
        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("            ---IT DICTIONARY---");
            System.out.println("==================================================");
            System.out.println("[ * WORD OF THE DAY * ]");
            System.out.println("  " + wordOfTheDay);
            System.out.println("==================================================");

            System.out.println("1. Search exact term");
            System.out.println("2. Show random term");
            System.out.println("3. Show all Terms");
            System.out.println("4. Search History");
            System.out.println("5. Take Quiz");
            System.out.println("0. Exit");
            System.out.println("==================================================");

            choice = readInt("Enter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    searchExactTerm();
                    clearConsole();
                    break;
                case 2:
                    showRandomTerm();
                    clearConsole();
                    break;
                case 3:
                    showAllTerms();
                    clearConsole();
                    break;
                case 4:
                    showSearchHistory();
                    clearConsole();
                    break;
                case 5:
                    takeQuiz();
                    clearConsole();
                    break;
                case 0:
                    clearConsole();
                    System.out.println("Exiting dictionary. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    clearConsole();
            }
        } while (choice != 0);
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void searchExactTerm() {
        while (true) {
            System.out.print("Search an IT term (or enter 1 to exit): ");
            String response = input.nextLine();
            cleanInput = response.trim();

            if (cleanInput.isEmpty()) {
                System.out.println("ERROR: Please enter a word. Input cannot be blank.");
                continue;
            }
            if (cleanInput.equals("1")) {
                break;
            }

            addToHistory(cleanInput);
            int resultIndex = BinarySearch(Data.data, cleanInput);

            if (!displayResult(resultIndex, response)) {
                break;
            }
        }
        pause();
    }

    static void showAllTerms() {
        System.out.println("\n [ALL TERMS]");
        for (int i = 0; i < Data.data.length; i++) {
            if (Data.data[i] != null) {
                String termOnly = Data.data[i].split(":")[0].trim();
                System.out.println("=| " + termOnly + " |=");
            }
        }
        System.out.println("------------");
        pause();
    }

    static void showRandomTerm() {
        if (Data.data.length > 0) {
            int index = random.nextInt(Data.data.length);
            if (Data.data[index] != null) {
                System.out.println(Data.data[index]);
            } else {
                System.out.println("No term available at this index.");
            }
        }
        pause();
    }

    static void addToHistory(String term) {
        if (term == null || term.trim().isEmpty()) return;

        if (historyCount == searchHistory.length) {
            for (int i = 0; i < searchHistory.length - 1; i++) {
                searchHistory[i] = searchHistory[i + 1];
            }
            searchHistory[searchHistory.length - 1] = term;
        } else {
            searchHistory[historyCount++] = term;
        }
    }

    static void showSearchHistory() {
        System.out.println("\n[RECENT SEARCHES]");
        if (historyCount == 0) {
            System.out.println("No searches yet.");
        } else {
            for (int i = historyCount - 1; i >= 0; i--) {
                System.out.println("- " + searchHistory[i]);
            }
        }
        System.out.println("----------------------");
        pause();
    }

    static void pause() {
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String str = input.nextLine();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static int BinarySearch(String[] list, String target) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == null) { low++; continue; }
            
            String currentWord = list[mid].split(":")[0].trim();
            int comparison = target.compareToIgnoreCase(currentWord);

            if (comparison == 0) return mid;
            else if (comparison > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static boolean displayResult(int resultIndex, String response) {
        if (response.equals("1")) {
            System.out.println("Exiting...");
            return false;
        } else if (resultIndex != -1) {
            System.out.println("Result: " + Data.data[resultIndex]);
        } else {
            System.out.println("Word not found");
            suggestWords(cleanInput);
        }
        return true;
    }

    public static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost, 
                           Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void suggestWords(String inputStr) {
        System.out.println("Suggestions:");
        int maxDistance = 3;
        boolean hasStartsWith = false;

        // First Pass: Prefix matching
        for (int i = 0; i < Data.data.length; i++) {
            if (Data.data[i] == null) continue;
            String word = Data.data[i].split(":")[0].trim();
            if (word.toLowerCase().startsWith(inputStr.toLowerCase())) {
                System.out.println("- " + word);
                hasStartsWith = true;
            }
        }

        if (hasStartsWith) return;

        // Second Pass: Levenshtein Distance
        for (int i = 0; i < Data.data.length; i++) {
            if (Data.data[i] == null) continue;
            String word = Data.data[i].split(":")[0].trim();
            int distance = levenshteinDistance(inputStr.toLowerCase(), word.toLowerCase());

            if (distance <= maxDistance) {
                System.out.print("Did you mean \"" + word + "\"? (yes/no): ");
                String answer = input.nextLine().trim().toLowerCase();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println(Data.data[i]);
                    return; 
                }
            }
        }
    }

    // ------------------ QUIZ FEATURE ------------------
    static void takeQuiz() {
        System.out.println("\n--- IT DICTIONARY QUIZ ---");

        String[][] questions = {
            {"What does CPU stand for?", "Central Processing Unit", "Computer Processing Unit", "Control Processing Unit", "Central Program Unit", "1"},
            {"What is RAM?", "Random Access Memory", "Readily Available Memory", "Rapid Application Module", "Random Active Module", "1"},
            {"What does DNS do?", "Translates domain names to IP addresses", "Manages database servers", "Encrypts network traffic", "Connects devices to Wi-Fi", "1"},
            {"What is HTTPS?", "Secure protocol for websites", "High Transfer Protocol System", "Hyper Text Technical Script", "Hardware Transfer Protocol Secure", "1"},
            {"What is a firewall?", "Protects network from unauthorized access", "Connects two networks", "Stores data temporarily", "A type of CPU", "1"}
        };

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) indexes.add(i);
        Collections.shuffle(indexes); // optional: shuffle question order

        int score = 0;
        for (int i = 0; i < 5; i++) { // ASK ALL 5 QUESTIONS
            int idx = indexes.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + questions[idx][0]);
            System.out.println("1. " + questions[idx][1]);
            System.out.println("2. " + questions[idx][2]);
            System.out.println("3. " + questions[idx][3]);
            System.out.println("4. " + questions[idx][4]);

            int correctOption = Integer.parseInt(questions[idx][5]); // convert correct answer to int

            int userAnswer = 0;
            while (true) {
                System.out.print("Your answer (1-4): ");
                String ans = input.nextLine();
                try {
                    userAnswer = Integer.parseInt(ans);
                    if (userAnswer >= 1 && userAnswer <= 4) break;
                    else System.out.println("Enter a number between 1 and 4.");
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter a number 1-4.");
                }
            }

            if (userAnswer == correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + questions[idx][correctOption]);
            }
        }

        System.out.println("\nYour total score: " + score + "/5");
        pause();
    }
}
