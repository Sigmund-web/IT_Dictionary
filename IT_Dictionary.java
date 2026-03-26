import java.util.Random;
import java.util.Scanner;

/*this are all the data. And because we are creating a dictionary jargons for IT it should be alphabetical (a-z)
so i used binary sarch - Sigmund Sayabo.

  */ 

public class IT_Dictionary {

 static String[] data = new String[36];
// I put the array container here sa public class para ma call siya sa any method and use static. - Sigmund Sayabo.
   
    static Scanner input = new Scanner(System.in); 
 //   Scanner input = new Scanner(System.in); need e gawas kay local lng sya need ma access sa gawas - Kenneth Bantayan  

 static Random random = new Random();
    
    
 static String cleanInput ; 
 // ge declare dri kay dli ma access sa displayResult na method - Kenneth Bantayan
 
 public static void main(String[] args) {

    //  mao ni ang hard coded na data tanan.
    // nag add kog 20 ka terms + gi arrange nanako alphabetically - Raven Ivan Cabingatan.
        
       data[0] = "Algorithm: A step-by-step procedure used to solve a problem or perform a task.";
data[1] = "API: Application Programming Interface; a set of rules for building software.";
data[2] = "Backup: A copy of data stored separately to restore it in case of loss or damage.";
data[3] = "Bandwidth: The maximum amount of data that can be transmitted over a network.";
data[4] = "Cache: A temporary storage area that stores frequently accessed data for faster retrieval.";
data[5] = "Cloud Computing: Storing and accessing data and programs over the internet.";
data[6] = "Compiler: A program that converts source code into machine code.";
data[7] = "Database: An organized collection of structured information or data.";
data[8] = "Debugging: The process of identifying and removing errors from computer hardware or software.";
data[9] = "Domain: A unique name that identifies a website on the internet.";
data[10] = "Encryption: The process of converting information or data into a code to prevent unauthorized access.";
data[11] = "Ethernet: A technology used for connecting computers in a local area network (LAN).";
data[12] = "Firewall: A security system that monitors and controls incoming and outgoing network traffic.";
data[13] = "Framework: A pre-built set of tools and libraries used to develop software applications.";
data[14] = "Gateway: A network device that connects different networks and allows them to communicate.";
data[15] = "GUI: Graphical User Interface; a visual way of interacting with a computer using items such as windows and icons.";
data[16] = "Hashing: The process of converting data into a fixed-size value for security or indexing.";
data[17] = "HTTP: Hypertext Transfer Protocol; the foundation of data exchange on the World Wide Web.";
data[18] = "IDE: Integrated Development Environment; software used for writing and testing code.";
data[19] = "IP Address: A unique string of characters that identifies each computer using the Internet Protocol.";
data[20] = "JSON: JavaScript Object Notation; a lightweight data-interchange format.";
data[21] = "Kernel: The core part of an operating system that manages operations of the computer and hardware.";
data[22] = "Latency: The delay before a transfer of data begins following an instruction for its transfer.";
data[23] = "Loop: A programming structure that repeats a block of code multiple times.";
data[24] = "Malware: Malicious software designed to damage or disrupt systems.";
data[25] = "Metadata: A set of data that describes and gives information about other data.";
data[26] = "Node: A basic unit of a data structure, such as a linked list or tree data structure.";
data[27] = "Open Source: Software for which the original source code is made freely available and may be redistributed and modified.";
data[28] = "Operating System: Software that manages computer hardware and software resources.";
data[29] = "Protocol: A set of rules that govern data communication between devices.";
data[30] = "Query: A request for data or information from a database.";
data[31] = "Router: A device that forwards data packets between computer networks.";
data[32] = "Syntax: The set of rules that defines the structure of code in a programming language.";
data[33] = "Thread: The smallest unit of processing that can be executed by a CPU.";
data[34] = "Virtual Machine: A software-based simulation of a physical computer.";
        

    

    //Gilmer Famoso
    run();
    }
    
    static void run() {
        int choice;

        do {
            System.out.println("==================================================");
            System.out.println("IT DICTIONARY");
            System.out.println("==================================================");
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
            System.out.println("==================================================");

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
   
 //------------------------------------------------------------------------------------------------------
 
 static void searchExactTerm() {
     
  while (true) {
 // gi dungagan nakog loop para di mag balik2 og run ang program after every search. - Benedict Guino-o.   
      
   // enter user input
        System.out.print("Search an IT term (or enter 1 to exit): ");
        String response = input.nextLine();

        // delete spaces. 
      cleanInput = response.trim();

        
        int resultIndex = BinarySearch(data, cleanInput);

        /* not equal sa -1 means wala sa array list and word na gi pangita sa user.
          pag 1 ang gi enter sa user mu return ang displayResult method ug boolean na false
          i-check diri sa if condition kung false ang na return, 
         pag false, mu break ang loop - Rulona
         
         */
      
   if (!displayResult(resultIndex, response)){
        break;
       }
    }
    }
    
 //------------------------------------------------------------------------------------------------------------  

 static void showRandomTerm() {
       
        Random rand = new Random();
        int index = rand.nextInt(data.length);
        System.out.println(data[index]);
  
    }

 //------------------------------------------------------------------------------------------------------------  
   
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
        int high = data.length - 1;  // last index

        
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

  //-----------------------------------------------------------------------------------------------------------------
   // method sa levenshtein distance - Jeskyle Ranises
 public static int levenshteinDistance(String a, String b) {
    // himog 2D array table para ma store ang distance sa substrings
    // rows a+1, coloumns b+1
    int[][] dp = new int[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
    for (int j = 0; j <= b.length(); j++) dp[0][j] = j;
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

    for (int i = 0; i < data.length; i++) {

        String word = data[i].split(":")[0].trim();

        int distance = levenshteinDistance(input.toLowerCase(), word.toLowerCase());
/*
distance (kalayo sa pagka pares) sa term nga gisulod sa user ug sa term sa dictionary (data[i]) kay mas gamay o equal sa maxDistance.
Ang pasabot sa“distance” kay nagpasabot kung unsa kapareho ang duha ka string. Gamay nga distance = halos pareho ang mga words. divino*/
       
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
