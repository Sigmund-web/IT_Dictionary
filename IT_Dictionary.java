import java.util.Scanner;

/*this are all the data. And because we are creating a dictionary jargons for it it need to be a sequnece (a-z)
so i used binary sarch - Sigmund Sayabo

  */ 

public class IT_Dictionary {

// i put the array container here sa public class para ma call siya sa any method and use static. - Sigmund.
   static Scanner input = new Scanner(System.in); 
    static String[] data = new String[15];
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


     
     //   Scanner input = new Scanner(System.in); need e gawas kay local lng sya need ma access sa gawas - Kenneth Bantayan
     // gi dungagan nakog loop para di mag balik2 og run ang program after every search. - Benedict Guino-o.
        while (true) {

        // enter user input
        System.out.print("Search an IT term [ENTER 0 to view terms] | [ENTER 1 to exit]: ");
        String response = input.nextLine();

         //Enhanced Filtering for User Input - Albarico, Jason D.
         cleanInput = response.trim();// delete spaces. 
         if(cleanInput.isEmpty()){
          System.out.println("ERROR: Please enter a word. Input Cannot be blank.");//Invalid Input
        continue;
         }//close if
        //Menu for Listing of TERMS-Albarico, Jason D.
         if(response.equals("0")){
             showAllTerms();
             continue;
         }//close if

 
        
        int resultIndex = BinarySearch(data, cleanInput);

        // not equal sa -1 means wala sa array list and word na gi pangita sa user.

         //pag 1 ang gi enter sa user mu return ang displayResult method ug boolean na false
         // i-check diri sa if condition kung false ang na return, 
         //pag false, mu break ang loop - Rulona
       if (!displayResult(resultIndex, response)){
        break;
       }

    }}//end MAIN METHOD
//Sigmund Sayabo
// methods sa logic BinarySearching 

 //Method for Listing of TERMS -Albarico, Jason D.
    public static void showAllTerms(){
        System.out.println("\n [ALL TERMS]");
        
        for(int i=0; i<data.length; i++){
            //kuhaon ra ang word before ang COLON:  (Terms)
            String TermOnly= data[i].split(":")[0].trim();
            System.out.println("=|"+TermOnly+"|=");  
        }//end f-loop
     System.out.println("------------");
    }//close showAllTerms Method
 
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
