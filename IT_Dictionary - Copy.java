import java.util.Random;
import java.util.Scanner;

/*this are all the data. And because we are creating a dictionary jargons for it it need to be a sequnece (a-z)
so i used binary sarch - Sigmund Sayabo

  */ 

public class IT_Dictionary {

// i put the array container here sa public class para ma call siya sa any method and use static. - Sigmund.
    static Scanner input = new Scanner(System.in); 
    static Random random = new Random();
    static String[] data = new String[16];
    static String cleanInput ;// ge declare dri kay dli ma access sa displayResult na method - Kenneth Bantayan
    public static void main(String[] args) {

    // and mao ni ang data tanan.
        
        data[0] = "API: Application Programming Interface; a set of rules for building software.";
        data[1] = "Bandwidth: The maximum amount of data that can be transmitted over a network.";
        data[2] = "Cloud Computing: Storing and accessing data and programs over the internet.";
        data[3] = "Debugging: The process of identifying and removing errors from computer hardware or software.";
        data[4] = "Encryption: The process of converting information or data into a code to prevent unauthorized access.";
        data[5] = "Firewall: A security system that monitors and controls incoming and outgoing network traffic.";
        data[6] = "GUI: Graphical User Interface; a visual way of interacting with a computer using items such as windows and icons.";
        data[7] = "HTTP: Hypertext Transfer Protocol; the foundation of data exchange on the World Wide Web.";
        data[8] = "IP Address: A unique string of characters that identifies each computer using the Internet Protocol.";
        data[9] = "JSON: JavaScript Object Notation; a lightweight data-interchange format.";
        data[10] = "Kernel: The core part of an operating system that manages operations of the computer and hardware.";
        data[11] = "Latency: The delay before a transfer of data begins following an instruction for its transfer.";
        data[12] = "Metadata: A set of data that describes and gives information about other data.";
        data[13] = "Node: A basic unit of a data structure, such as a linked list or tree data structure.";
        data[14] = "Open Source: Software for which the original source code is made freely available and may be redistributed and modified.";
        data[15] = "Open Source: Software for which the original source code is made freely available and may be redistributed and modified.";

    

    //Famoso
    run();
    }
    
    static void run() {
        int choice;

        do {
            printLine();
            System.out.println("IT DICTIONARY");
            printLine();
            System.out.println("1. Search exact term");
            System.out.println("2. Show random term");
            System.out.println("3. Feature name");
            System.out.println("4. Feature name");
            System.out.println("5. Feature name");
            System.out.println("6. Feature name");
            System.out.println("7. Feature name");
            System.out.println("8. Feature name");
            System.out.println("9. Feature name");
            System.out.println("10.Feature name");
            System.out.println("0. Exit");
            printLine();

            choice = readInt("Enter your choice: ");
            System.out.println();
            // add diri ang name sa method 
            switch (choice) {
                case 1:
                    searchExactTerm();
                    break;
                case 2:
                    showRandomTerm();
                    break;
                case 3:
                    //Feature();
                    break;
                case 4:
                    //Feature();
                    break;
                case 5:
                    //Feature();
                    break;
                case 6:
                    //Feature();
                    break;
                case 7:
                    //Feature();
                    break;
                case 8:
                    //Feature();
                    break;
                case 9:
                    //Feature();
                    break;
                case 10:
                    //Feature();
                    break;
                case 0:
                    System.out.println("Exiting dictionary. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 0) {
                System.out.println();
                pause();
            }

        } while (choice != 0);
    }
    static void searchExactTerm() {
        String term = readLine("Enter the exact term: ").trim();
        int count = 0;

        printLine();
        System.out.println("RESULT FOR: " + term);
        printLine();

        for (int i = 0; i < data.length; i++) {
            String entryTerm = getTerm(data[i]);
            String definition = getDefinition(data[i]);

            if (entryTerm.equalsIgnoreCase(term)) {
                count++;
                System.out.println(count + ". " + entryTerm + " - " + definition);
            }
        }

        if (count == 0) {
            System.out.println("No exact match found.");
        } else {
            System.out.println();
            System.out.println("Total definitions found: " + count);
        }
    }
    
    static void showRandomTerm() {
        int index = random.nextInt(data.length);
        String chosenTerm = getTerm(data[index]);

        printLine();
        System.out.println("RANDOM TERM");
        printLine();

        showDefinitionsForTerm(chosenTerm);
    }
    static String readLine(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
    static String getTerm(String entry) {
        int colonIndex = entry.indexOf(':');
        if (colonIndex == -1) {
            return entry.trim();
        }
        return entry.substring(0, colonIndex).trim();
    }
    static String getDefinition(String entry) {
        int colonIndex = entry.indexOf(':');
        if (colonIndex == -1) {
            return "";
        }
        return entry.substring(colonIndex + 1).trim();
    }
    static void showDefinitionsForTerm(String term) {
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            String entryTerm = getTerm(data[i]);
            String definition = getDefinition(data[i]);

            if (entryTerm.equalsIgnoreCase(term)) {
                count++;
                System.out.println(count + ". " + entryTerm + " - " + definition);
            }
        }

        if (count > 0) {
            System.out.println();
            System.out.println("Total definitions found: " + count);
        }
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
    static void printLine() {
        System.out.println("==================================================");
    }


   //   Scanner input = new Scanner(System.in); need e gawas kay local lng sya need ma access sa gawas - Kenneth Bantayan
     // gi dungagan nakog loop para di mag balik2 og run ang program after every search. - Benedict Guino-o.      
       

//Sigmund Sayabo
        // methods sa logic BinarySearching 
    
    public static int BinarySearch(String[] list, String target) {

    // so ang formula is if word is not equal sa middle then maybe naa sa lower group or higher group.
        
        int low = 0;
        int high = data.length - 1; // last index

        
        while (low <= high) {
       
            // mao ni ang middle = formula
            int mid = (low + high) / 2;

            // spli (:) and added trim();
            String currentWord = list[mid].split(":")[0].trim();
    
        // .compare is gi compare niya ang curentWord then comparison iyang variable.        
            int comparison = target.compareToIgnoreCase(currentWord);

    // so if and word is si middle then return mid if target is greater than low if target < compareson then high.
            if (comparison == 0) {
                return mid;
            } else if (comparison > 0) {
                low = mid + 1;
            } else if (comparison < 0) {
                high = mid - 1;
            }

        }

        return -1;

    }

 //gihimo an nako ug method ang pagdisplay sa result para limyo ang main - Rulona
 //ang argument kay ang resultIndex gikan sa binary search ug response sa user
 public static boolean displayResult(int resultIndex, String response) {
    if (response.equals("1")) {
        System.out.println("Exiting...");
        return false;
    } else if (resultIndex != -1) {
        System.out.println("Result: " + data[resultIndex]);
    }/* else {
         System.out.println("Word not found")} enchance para magamit ang suggestWords --Romnick Felix*/
    else {// ge add na method to call the suggestWords method
    System.out.println("Word not found");

    System.out.print("Do you want suggestions? (yes/no): ");
    String choice = input.nextLine();

    if (choice.equalsIgnoreCase("yes")) {
        suggestWords(cleanInput); //  METHOD CALL
    }
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

            int substitution = dp[i - 1][j - 1] + cost;
            int insertion = dp[i][j - 1] + 1;
            int deletion = dp[i - 1][j] + 1;

            dp[i][j] = Math.min(substitution, Math.min(insertion, deletion));
        }
    }

    return dp[a.length()][b.length()];
 }
 // method for suggest word if ever ma misspelled using levenshteinDistance alghorihm - Joseph Mark  divino
 public static void suggestWords(String input) {

    System.out.println("Suggestions:");

    int maxDistance = 3;
    boolean hasSuggestion = false;

    for (int i = 0; i < data.length; i++) {

        String word = data[i].split(":")[0].trim();

        int distance = levenshteinDistance(input.toLowerCase(), word.toLowerCase());
/*
distance (kalayo sa pagka pares) sa term nga gisulod sa user ug sa term sa dictionary (data[i]) kay mas gamay o equal sa maxDistance. Ang pasabot sa“distance” kay nagpasabot kung unsa kapareho ang duha ka string. Gamay nga distance = halos pareho ang mga words. divino*/
        if (distance <= maxDistance) {
            System.out.println("- " + data[i]); 
            hasSuggestion = true;
        }
    }

    if (!hasSuggestion) {
        System.out.println("No similar IT terms found.");
    }
 }

}
