package Practice_Area;
import java.util.Random;
import java.util.Scanner;

/*this are all the data. And because we are creating a dictionary jargons for IT it should be alphabetical (a-z)
so i used binary sarch - Sigmund Sayabo.

 */
public class IT_Dictionary {

    static Scanner input = new Scanner(System.in);
    //   Scanner input = new Scanner(System.in); need e gawas kay local lng sya need ma access sa gawas - Kenneth Bantayan  

    static Random random = new Random();

    static String cleanInput;
    // ge declare dri kay dli ma access sa displayResult na method - Kenneth Bantayan
    // SEARCH HISTORY FEATURE - Biando, Marc Terence
// array para mag store sa last 10 ka search sa user (recent searches)
    static String[] searchHistory = new String[10];
// counter para ma track pila na ka search ang na store
    static int historyCount = 0;
    //kani para sa word of the day feature by mendez pee jay..
    static String wordOfTheDay = "";
    public static void main(String[] args) {

        //kani para sa word of the day feature by mendez pee jay..
        // gi generate ang word of the day once sa first run, random index gikan sa data array
       
        int wordOfTheDayIndex = random.nextInt(Data.data.length);
        wordOfTheDay = Data.data[wordOfTheDayIndex ];
        
        //Gilmer Famoso
        run();
    }

    static void run() {
        int choice;

        do {
            System.out.println("==================================================");
            System.out.println("              ---IT DICTIONARY---");
            System.out.println("==================================================");

            //kani para sa word of the day feature by mendez pee jay..
            // gi display ang word of the day sa banner area sa taas, before ang menus
            System.out.println("[ * WORD OF THE DAY * ]");
            System.out.println("  " + wordOfTheDay );
            System.out.println("==================================================");
 
            System.out.println("1. Search exact term");
            System.out.println("2. Show random term");
            System.out.println("3. Show all Terms");//Albarico, Jason D.
            System.out.println("4. Search History");
            System.out.println("0. Exit");
            System.out.println("==================================================");

            choice = readInt("Enter your choice: ");
            System.out.println();

            // add diri ang name sa method 
            switch (choice) {
                case 1:
                    searchExactTerm();
                      // para ma clear ang console after mo exit sa method - Cris laurence Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 2:
                    showRandomTerm();
                      // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 3:
                    showAllTerms(); //Menu for List of Terms- Albarico, Jason D.
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 4:
                    showSearchHistory();//method call para ipakita ang search history - Biando, Marc Terence B.
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 5:
                    //Feature();
                   // para ma clear - Longino  
                System.out.print("\033[H\033[2J");   
                    break;
                case 6:
                    //Feature();
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 7:
                    //Feature();
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 8:
                    //Feature();
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 9:
                    //Feature();
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 10:
                    //Feature();
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
                    break;
                case 0:
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J"); 
                    System.out.println("Exiting dictionary. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    // para ma clear - Longino  
                System.out.print("\033[H\033[2J");  
            }

            // Remove kay para dli mag balik2 ang Enter to continue - Cris laurence Longino 
    /*   if (choice != 0) {  
            System.out.println();  
            pause();  
        }  */

        } while (choice != 0);
    }

    //------------------------------------------------------------------------------------------------------
    static void searchExactTerm() {

        while (true) {
            // gi dungagan nakog loop para di mag balik2 og run ang program after every search. - Benedict Guino-o.   

            // enter user input
            System.out.print("Search an IT term (or enter 1 to exit): ");
            String response = input.nextLine();

            //Enhanced Filtering for User Input - Albarico, Jason D.
            cleanInput = response.trim();// delete spaces. 
            
            if (cleanInput.isEmpty()) {
                System.out.println("ERROR: Please enter a word. Input Cannot be blank.");//Invalid Input
                continue;
            }//close if
            if (!cleanInput.equals("1")) {
             addToHistory(cleanInput);
            } // dili i-apil ang "1" kay exit command man ni - Biando, Marc Terence

            int resultIndex = BinarySearch(Data.data, cleanInput);

            if (!displayResult(resultIndex, response)) {
                break;
            }
        } pause();
    }

    //------------------------------------------------------------------------------------------------------------  
    //Method for Table of Contents-Albarico, Jason D.
    static void showAllTerms() {
        System.out.println("\n [ALL TERMS]");

        for (int i = 0; i < Data.data.length; i++) {

            if (Data.data[i] != null) {
                //kuhaon ra ang word before ang COLON: | Mo gana ra ang split kug dili null and data[i]
                String TermOnly = Data.data[i].split(":")[0].trim();
                System.out.println("=| " + TermOnly + " |=");
            }//close if
        }//close f-loop
        System.out.println("------------");
        pause();
    }//close showAllTerms Method

    //------------------------------------------------------------------------------------------------------------  
    // Gilmer Famoso
        static void showRandomTerm() {

        Random rand = new Random();
        int index = rand.nextInt(Data.data.length);
        System.out.println(Data.data[index]);
        int index = rand.nextInt(Data.data.length);
        if (Data.data[index] != null) { // NULL REMOVER -Benedict Guino-o
            System.out.println(Data.data[index]);
        } else {
            System.out.println("No term available at this index."); }
            pause();

    }

    //------------------------------------------------------------------------------------------------------------  
    static void addToHistory(String term) {
        if (term == null || term.trim().isEmpty()) {
            return;
        }
        /* kung puno na ang array (10 items), i-shift ang tanan pa left
     para matanggal ang pinaka una (oldest search)
     then ibutang ang new search sa last
         */
        if (historyCount == searchHistory.length) {
            for (int i = 0; i < searchHistory.length - 1; i++) {
                searchHistory[i] = searchHistory[i + 1];
            }
            searchHistory[searchHistory.length - 1] = term;
        } else {
            //kung dili pa puno, ibutang lang sa next available index 
            searchHistory[historyCount++] = term;
        }
    }

    // method for search history sa user - Biando, Marc Terence B.
    static void showSearchHistory() {
        System.out.println("\n[RECENT SEARCHES]");

//check niya kung wala pay search na nahimo
        if (historyCount == 0) {
            System.out.println("No searches yet.");
            return;
        }
        //i-print gikan sa pinaka latest pa backward para ang pinaka recent nga search ang mauna makita
        for (int i = historyCount - 1; i >= 0; i--) {
            System.out.println("- " + searchHistory[i]);
        }

        System.out.println("----------------------");
        pause();
        
    }

    //------------------------------------------------------------------------------------------------------------
    //Gilmer Famoso
    //Connected sa run() Method
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

//------------------------------------------------------------------------------------------------------------------------------
    public static int BinarySearch(String[] list, String target) {

        /*Sigmund Sayabo
   methods sa logic BinarySearching */
        // so ang formula is if word is not equal sa middle then maybe naa sa lower group or higher group.
        int low = 0;
        int high = Data.data.length - 1;  // last index

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

    public static boolean displayResult(int resultIndex, String response) {

        /*gihimo an nako ug method ang pag display sa result para limyo ang main - Rulona
 ang argument kay ang resultIndex gikan sa binary search ug response sa user */

 /* not equal sa -1 means wala sa array list and word na gi pangita sa user.
          pag 1 ang gi enter sa user mu return ang displayResult method ug boolean na false
          i-check diri sa if condition kung false ang na return, 
         pag false, mu break ang loop - Rulona
         
         */
        if (response.equals("1")) {
            System.out.println("Exiting...");
            return false;
        } else if (resultIndex != -1) {
            System.out.println("Result: " + Data.data[resultIndex]);
        } /* else {
         System.out.println("Word not found")} enchance para magamit ang suggestWords --Romnick Felix*/ 
        else {// ge add na method to call the suggestWords method
            System.out.println("Word not found");
            suggestWords(cleanInput); //  METHOD CALL

       /*     System.out.print("Do you want suggestions? (yes/no): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                suggestWords(cleanInput); //  METHOD CALL
            }*/
        }
        return true;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // method sa levenshtein distance - Jeskyle Ranises
    public static int levenshteinDistance(String a, String b) {
        // himog 2D array table para ma store ang distance sa substrings
        // rows a+1, coloumns b+1
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }
// compare each character: loop through string a (row i) and string b (column j)
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
// i check kung parehas ang letter, kung same then 0 pero kung lahi then 1 
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
// (replace) change one letter to another
                int substitution = dp[i - 1][j - 1] + cost;
                // (insert) add a new letter
                int insertion = dp[i][j - 1] + 1;
                // mag remove og letter
                int deletion = dp[i - 1][j] + 1;

                dp[i][j] = Math.min(substitution, Math.min(insertion, deletion));
            }
        }

        return dp[a.length()][b.length()];
    }

    //---------------------------------------------------------------------------------------------------------------------------
    public static void suggestWords(String input) {
    // method for suggest word if ever ma misspelled using levenshteinDistance alghorihm - Joseph Mark  divino

    System.out.println("Suggestions:");

    int maxDistance = 3;
    boolean hasSuggestion = false;
    boolean hasStartsWith = false; // ADDED: to detect if naa bay startsWith results

    Scanner sc = new Scanner(System.in); //  ADDED: for yes/no interaction

    // 🔹 FIRST LOOP: show startsWith suggestions (single letter / partial match)
    for (int i = 0; i < Data.data.length; i++) {
    for (int i = 0; i < Data.data.length; i++) {
        if (data[i] == null) continue; // NULL REMOVER - Divino

        String word = Data.data[i].split(":")[0].trim();
        //if nag matched ang gi enter sa user mag show ang mga terms na naa sa dictionary bisag one letter lang -kelvin monsales
        //word.toLowerCase() i ignore niya bisag naka uppercase ang gi enter sa user or lowercase and i convert niya into lowercase ang gi enter sa user. - kelvin monsales
        //startsWith(input.toLowerCase()) meaning i check niya if ang gi enter niya na word the same sa gisearch nimi (sample: nag enter kag pro and ang first three letter na naa sa dictionary is available si programming, protocol,produce, i show ni niya tanan kay match man ang first three letter;) - kelvin monsales
        //System.out.println("- " + word); if true siya meanig i show niya tanan terms na match sa gi input nimo - kelvin mosales

        if (word.toLowerCase().startsWith(input.toLowerCase())) {
            System.out.println("- " + word);
            hasSuggestion = true;
            hasStartsWith = true; //  ADDED: mark nga naa tay prefix matches
        }
    }

    //  ADDED: if naa na startsWith results, dili na mu proceed sa levenshtein (no question)
    if (hasStartsWith) {
        return;
    }

    // 🔹 SECOND LOOP: levenshtein suggestion (for misspelled words)
    for (int i = 0; i < Data.data.length; i++) {

        String word = Data.data[i].split(":")[0].trim();
    for (int i = 0; i < Data.data.length; i++) {
        if (Data.data[i] == null) continue; // NULL REMOVER - Divino
        String word = Data.data[i].split(":")[0].trim();

        int distance = levenshteinDistance(input.toLowerCase(), word.toLowerCase());
        /*
distance (kalayo sa pagka pares) sa term nga gisulod sa user ug sa term sa dictionary (data[i]) kay mas gamay o equal sa maxDistance.
Ang pasabot sa“distance” kay nagpasabot kung unsa kapareho ang duha ka string. Gamay nga distance = halos pareho ang mga words. divino*/

        if (distance <= maxDistance) {
            // 🔄 CHANGED: instead of auto printing, ask user first
            System.out.print("Did you mean \"" + word + "\"? (yes/no): ");
            String answer = sc.nextLine().trim().toLowerCase();

            if (answer.equalsIgnoreCase("yes")) {
                System.out.println(Data.data[i]); // show full meaning
                hasSuggestion = true;
                break; //  ADDED: stop after correct word is confirmed
            }

            //  OLD CODE (kept as comment for reference)
            // System.out.println("- " + data[i]);
            // hasSuggestion = true;
        }
    }

    if (!hasSuggestion) {
        System.out.println("No similar IT terms found.");
    }
}
}
