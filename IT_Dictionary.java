import java.util.Random;
import java.util.Scanner;

public class IT_Dictionary {
    // nag 
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static String cleanInput; // gi declare kay di ma access sa displayResult method - Kenneth D. Bantayan
    // Scanner input = new scanner (System.in); - need himoong static para ma access sa uban method - Kenneth D. Bantayan
    // SEARCH HISTORY FEATURE
//gamitan ug array para ma store ang recent searches sa user (max 10 entries) - Biando, Marc Terence B.
    static String[] searchHistory = new String[10];
// counter para ma track pila na ka searches ang na store - Biando, Marc Terence B.
    static int historyCount = 0;
    
//kani para sa word of the day feature by mendez pee jay
    static String wordOfTheDay = "";

    public static void main(String[] args) {
        // Generate Word of the Day once at the start
        if (Data.data.length > 0) {
           
	//gi-generate  ang word of the day once sa first run, random index gikan sa data array //mendez pee jay
 int wordOfTheDayIndex = random.nextInt(Data.data.length);
            wordOfTheDay = Data.data[wordOfTheDayIndex];
        }
        
        run();
    }
// added while loop para di mag balik2 og run ang user sa program - Guino-o, Benedict E. (before ang menu gi add)
// Menu and Choice Picker - Famoso, Gilmer C.
// Modified by: ???
    static void run() {
        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("            ---IT DICTIONARY---");
            System.out.println("==================================================");
            


	//kani para sa word of the day feature by mendez pee jay
	//gi display ang word of the day before sa banner area sa taas, before ang menus
System.out.println("[ * WORD OF THE DAY * ]");
            System.out.println("  " + wordOfTheDay);
            System.out.println("==================================================");

            System.out.println("1. Search exact term");
            System.out.println("2. Show random term");
            System.out.println("3. Show all Terms");
            System.out.println("4. Search History");
			 System.out.println("5. take Quiz");
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

    // Cris Laurence Longino - para mo hinlo ang console every loop sa menu
    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int BinarySearch(String[] list, String target) {
         //Sigmund Sayabo
       /*
       ang binary searching is pag search sa word alphabitically and na use ni siya sa 
       sa search history na method. 
       */
        
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == null) { low++; continue; }
            
            // so if not in the middle maybe nasa lower or higher.
            
            String currentWord = list[mid].split(":")[0].trim();
            int comparison = target.compareToIgnoreCase(currentWord);

            if (comparison == 0) return mid;
            else if (comparison > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
    //i accept ang result na index sa binary search ug response sa user
    //if ang response kay "0", mu return ug boolean na false sa
    //searchExactTerm() na method then mu return to na method - Rulona, Maddie L.
    public static boolean displayResult(int resultIndex, String response) {
        if (response.equals("0")) {
            System.out.println("Exiting...");
            return false;
        } else if (resultIndex != -1) {
            System.out.println("Result: " + Data.data[resultIndex]);
        } else {//Enhanced by Felix
            System.out.println("Word not found");
            suggestWords(cleanInput);
        }
        return true;
    }

    static void searchExactTerm() {
        while (true) {
            System.out.print("Search an IT term (Enter 0 to return): ");
            String response = input.nextLine();
            cleanInput = response.trim();
            //Filtering the user input Albarico (Enhanced)
            if (cleanInput.isEmpty()) {
                System.out.println("ERROR: Please enter a word. Input Cannot be blank.");
                continue;
            }

            int resultIndex = BinarySearch(Data.data, cleanInput);
            if (!displayResult(resultIndex, cleanInput)) {
                return;
            }
            addToHistory(cleanInput);
        }
    }
//Showing of listing the terms -Albarico, Jason D.
    static void showAllTerms() {
        System.out.println("\n [ALL TERMS]");
        for (int i = 0; i < Data.data.length; i++) {
            if (Data.data[i] != null) {
                String termOnly = Data.data[i].split(":")[0].trim();
                System.out.println("| " + termOnly + " |");
            }
        }
        System.out.println("------------");
        pause();
    }

// Will pick a single random term, and its definition per run - Famoso, Gilmer C.
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
// para ma store ang recent searches sa user - Biando, Marc Terence B.
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
// para ma display ang recent searches gikan latest padulong oldest - Biando, Marc Terence B.

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

//Just a method that asks the press enter to continue - Famoso, Gilmer C.
    static void pause() {
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

//Will check if it's truly an integer and if it’s a valid value - Famoso, Gilmer C.
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
    // Jeskyle A. Ranises - algorithm para makuha ang distance
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
    // Joseph Divino - method for suggest word if ma mispelled using lavenshtein algorithm
    public static void suggestWords(String inputStr) {
        System.out.println("Suggestions:");
        int maxDistance = 3;
        boolean hasStartsWith = false;

        // First Pass: Prefix matching
        for (int i = 0; i < Data.data.length; i++) {
            if (Data.data[i] == null) continue;
            
            String word = Data.data[i].split(":")[0].trim();
            
// word.toLowerCase() i convert into lowercase ang i input sa user - Monsales
// .startsWith(inputStr.toLowerCase() an use ani niya is i check kung ang gi input sa user nag match sa mga data (exmple: if si user nag enter ug pr, i display niya tanan wordsna nag start sa pr) - Monsales
//System.out.println("- " + word); meaning i print niya ang dash (-) plus ang word - Monsales
//   hasStartsWith = true; meaning if nag match na ang gi input sa user meaning found na ang word - Monsales

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
}


    static void takeQuiz() { // SERVIDOR,ANDRE  nani tanan  
        System.out.println("\n--- IT DICTIONARY QUIZ ---");

        String[][] questions = {   //quiz og answer
            {"What does CPU stand for?", "Central Processing Unit", "Computer Processing Unit", "Control Processing Unit", "Central Program Unit", "Central Processing Unit"},
            {"What is RAM?", "Random Access Memory", "Readily Available Memory", "Rapid Application Module", "Random Active Module", "Random Access Memory"},
            {"What does DNS do?", "Translates domain names to IP addresses", "Manages database servers", "Encrypts network traffic", "Connects devices to Wi-Fi", "Translates domain names to IP addresses"},
            {"What is HTTPS?", "Secure protocol for websites", "High Transfer Protocol System", "Hyper Text Technical Script", "Hardware Transfer Protocol Secure", "Secure protocol for websites"},
            {"What is a firewall?", "Protects network from unauthorized access", "Connects two networks", "Stores data temporarily", "A type of CPU", "Protects network from unauthorized access"}
        };

        // part nga i Shuffle ang question order
        int[] questionOrder = new int[questions.length];
        for (int i = 0; i < questionOrder.length; i++) questionOrder[i] = i;

        for (int i = questionOrder.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = questionOrder[i];
            questionOrder[i] = questionOrder[j];
            questionOrder[j] = temp;
        }

        int score = 0;

        for (int i = 0; i < 5; i++) {
            int idx = questionOrder[i];
            System.out.println("\nQ" + (i + 1) + ": " + questions[idx][0]);

            // Store answers in array
            String[] answers = {questions[idx][1], questions[idx][2], questions[idx][3], questions[idx][4]};
            String correctAnswer = questions[idx][5];

            // mao nani nga ipang shuffles ang mga answer
            for (int k = answers.length - 1; k > 0; k--) {
                int j = random.nextInt(k + 1);
                String tempAns = answers[k];
                answers[k] = answers[j];
                answers[j] = tempAns;
            }

            // mga naka Display nga mga  answers
            for (int k = 0; k < answers.length; k++) {
                System.out.println((k + 1) + ". " + answers[k]);
            }

            // kuhaon ang answer sa users 
            System.out.print("Your answer (1-4): ");
            String userInput = input.nextLine();
            int chosenIndex;
            try {
                chosenIndex = Integer.parseInt(userInput) - 1;
            } catch (Exception e) {
                System.out.println("Invalid input! Counting as wrong.");
                chosenIndex = -1;
            }

            // Check answer na 
            if (chosenIndex >= 0 && answers[chosenIndex].equals(correctAnswer)) { //if tama then tama
                System.out.println("Correct!");
                score++;
            } else { //if wrong ang answer matik mag hatag sya sa tama nga answer
                System.out.println("Wrong! Correct answer: " + correctAnswer);
            }
        }

        System.out.println("\nYour total score: " + score + "/5");// pilay score ihatag
        pause();
    }
}

