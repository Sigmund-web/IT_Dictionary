import java.util.Random;
import java.util.Scanner;

/*this are all the data. And because we are creating a dictionary jargons for IT it should be alphabetical (a-z)
so i used binary sarch - Sigmund Sayabo.

 */
public class IT_Dictionary {

    static String[] data = new String[145];
// I put the array container here sa public class para ma call siya sa any method and use static. - Sigmund Sayabo.

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

    public static void main(String[] args) {

        //  mao ni ang hard coded na data tanan.
        // nag add kog 20 ka terms + gi arrange nanako alphabetically - Raven Ivan Cabingatan.
        // Gilmer Famoso - 110 more terms added and arranged alphabetically. :)
        data[0] = "Administrator: Responsible for supporting the configuration and operation of computer systems, servers, and network equipment, among other IT services. Also referred to as a system administrator or sysadmin.";
        data[1] = "Agile software development: An incremental and iterative approach to software development that emphasizes continual planning and delivery. Scrum, Lean, and kanban are considered agile software methodologies or systems.";
        data[2] = "AI: Artificial intelligence; The simulation of human intelligence processes done by machines and computer systems.";
        data[3] = "Algorithm: A step-by-step procedure used to solve a problem or perform a task.";
        data[4] = "Antivirus: Software that is used for scanning and removing viruses from a computer or network. Its purpose is to protect servers and computers and to quarantine and remove any viruses found.";
        data[5] = "API: Application Programming Interface; a set of rules for building software.";
        data[6] = "Applets: A small application that performs a specific task and is run within another application. An example is a Java program that runs within a web browser.";
        data[7] = "Application software: A program or a set of programs — such as word processors, games, spreadsheets, enterprise software, etc. — designed for use by people or end-users.";
        data[8] = "Authentication: A process used to verify the identity of a person or device. Typically associated with usernames and passwords that grant access to an application, system, or website.";
        data[9] = "Backup: A copy of data stored separately to restore it in case of loss or damage.";
        data[10] = "Bandwidth: The maximum amount of data that can be transmitted over a network.";
        data[11] = "Big data: Extremely large datasets that are complex and cannot be processed using traditional data analysis methods.";
        data[12] = "Blockchain: The ledger technology at the core of bitcoin and other virtual currencies that represents chronological transactions and relationships. Blockchain makes the history of a digital asset unchangeable, decentralized, and transparent. Blockchain is also referred to as Distributed Ledger Technology (DLT).";
        data[13] = "Business continuity plan: A planning process that helps companies prevent business disruption and speeds up recovery in the event of a natural disaster, pandemic, threat, or instance of sabotage.";
        data[14] = "BYOD: Stands for Bring Your Own Device and is the practice of allowing company employees to use their personal devices like laptops, smartphones, and tablets for work purposes.";
        data[15] = "Cache: A temporary storage area that stores frequently accessed data for faster retrieval.";
        data[16] = "Client: A device that accesses data stored on a central server. There can be many computers or devices (clients) accessing data on one server that’s physically located elsewhere.";
        data[17] = "Closed source: Refers to software that is proprietary, or in other words, is owned by an organization.";
        data[18] = "Cloud: Cloud Computing: Storing and accessing data and programs over the internet.";
        data[19] = "Cloud computing: The practice of using remote servers hosted on the internet to store, manage, and deliver services and applications. Cloud-based can refer to different types of productivity tools, games, and other personal or business software and services that are held remotely from the end-user.";
        data[20] = "Command line interface: A text-based interface for entering commands that instruct a computer program to do specific tasks.";
        data[21] = "Compiler: A program that converts source code into machine code.";
        data[22] = "Configuration management: The process for configuring and maintaining consistent records for system integrity and updates — across hardware, software, and other system components.";
        data[23] = "Continuous delivery: The ability to deploy code changes (such as new features, configuration changes, and bug fixes) at any time. This approach uses small build cycles to package software for deployment in a production-like environment so it can be rapidly deployed. ";
        data[24] = "Continuous deployment: A process by which changes to software code are automatically deployed to the final production environment. Automatic run tests ensure the code functions properly before it is deployed.";
        data[25] = "Continuous integration: A software development practice that requires engineers to continuously integrate or merge code into a shared repository. Automated build and test processes help teams quickly identify code issues. ";
        data[26] = "Cybersecurity: Encompasses the use of technologies, practices, and policies to stop unauthorized access and damage to data, networks, devices, and programs.";
        data[27] = "Data center: A grouping of off-site network servers that companies use to store, process, and transfer large amounts of data.";
        data[28] = "Data mining: A process that analyzes large amounts of raw data within a database to look for patterns and specific information.";
        data[29] = "Database: Database: An organized collection of structured information or data.";
        data[30] = "Debugging: The process of identifying and removing errors from computer hardware or software.";
        data[31] = "DevOps: A set of software development practices that combines development (Dev) and IT operations (Ops) for the continuous delivery of reliable software. ";
        data[32] = "DevSecOps: An extension of DevOps that integrates security (Sec) into the DevOps process.";
        data[33] = "DHCP: Dynamic Host Configuration Protocol; A network protocol that automatically assigns an IP address to each device that is connected to a network.";
        data[34] = "Digital transformation: The use of digital technologies to create new customer experiences and business processes or to optimize existing ones. ";
        data[35] = "Disaster recovery: The process of identifying how business operations will be resumed following an unexpected or disastrous event.";
        data[36] = "DLP: Data loss prevention; A set of tools and processes used to monitor and block the unauthorized flow of information.";
        data[37] = "DNS: Domain name system; A naming system that translates domain names into Internet Protocol (IP) addresses. This allows users to access a website on the internet by searching for its unique domain name.";
        data[38] = "Domain: A unique name that identifies a website on the internet.";
        data[39] = "Encryption: The process that converts sensitive data into an unrecognizable form to protect it from unauthorized access.";
        data[40] = "Enterprise Transformation: Describes the change that is taking place in large companies to deliver better customer experiences. Enterprise transformation involves innovations in technologies, processes, and people.";
        data[41] = "Ethernet: A standard means of using a wire to connect devices like computers on a network to routers and switches.";
        data[42] = "Everything as code: A concept that refers to treating systems and their components — including operating systems, network configurations, and infrastructure — as code.";
        data[43] = "Firewall: Hardware or software that acts as a barrier to the internet to protect a network from untrusted, outside connections while allowing trusted connections through.";
        data[44] = "Firmware: A set of instructions or programs on a device that dictates how it should communicate with other computer hardware.";
        data[45] = "Framework: A pre-built set of tools and libraries used to develop software applications.";
        data[46] = "FTP: File Transfer Protocol; A protocol designed for transferring files over the internet. Files stored on an FTP server can be accessed using an FTP client, which is operated through a web browser, FTP software program, or a command line interface.";
        data[47] = "Gateway: Hardware such as a router or server that enables traffic to flow to and from different networks.";
        data[48] = "Group authentication: A security protocol used to verify which users belong to a group and to grant or deny access to information based on that group.";
        data[49] = "GUI: Graphical user interface; An interface that carries out computer commands using icons, menus, and buttons.";
        data[50] = "HaaS: Hardware as a service; Managed services and hardware that are leased from a service provider for a monthly fee. ";
        data[51] = "Hardware: Tools, machinery, and other durable equipment such as keyboards, monitors, or central processing units.";
        data[52] = "Hashing: The process of converting data into a fixed-size value for security or indexing.";
        data[53] = "Help desk: Refers to a team or function within a company that provides technical support — for tools, products, or services — to internal or external customers.";
        data[54] = "Host: A type of computer or server that is accessible over a network with a unique identifier called a hostname. Other computers, often called clients, access the host.";
        data[55] = "HTML: Hypertext Markup Language; A website language used to create webpages. The term hypertext refers to the hyperlinks within a webpage and the term markup language refers to tags that define the webpage layout and elements.";
        data[56] = "HTTP: Hypertext Transfer Protocol; An application protocol used to enable communication between a user's browser and a web server.";
        data[57] = "HTTPS: Hypertext Transfer Protocol Secure; An extension of HTTP that uses encryption protocol to ensure secure communication between a user's browser and a web server.";
        data[58] = "Hypervisor: Software used to manage one or more virtual machines (VMs). It allows each VM to access computer hardware.";
        data[59] = "IaaS: Infrastructure as a service; A form of cloud technology that delivers essential computing resources like networks and storage to consumers and companies on-demand on a pay-as-you-go basis.";
        data[60] = "IaC: Infrastructure as code; A method for configuring infrastructure that allows operations teams to manage and provision it automatically using code.";
        data[61] = "IDE: Integrated Development Environment; software used for writing and testing code.";
        data[62] = "Idea management: The process of capturing, sorting, and prioritizing ideas from customers, partners, and internal teams. Effective idea management is vital for understanding what customers want and driving innovation. ";
        data[63] = "Integration: Point-to-point interactions between two software applications that synchronize data and workflows.";
        data[64] = "Integration testing: A type of software testing where individual units are combined and tested to ensure they work as intended together.";
        data[65] = "IP Address: A unique string of characters that identifies each computer using the Internet Protocol.";
        data[66] = "Ipsec: Internet Protocol security; A network protocol suite used to validate and encrypt packets of data and provide secure internet communication between computers.";
        data[67] = "IT assessment: The process of analyzing the state of a company’s IT environment, including processes, policies, infrastructure, resources, and capabilities — to identify strengths, risks, and areas for improvement.";
        data[68] = "IT plan: A plan that defines how IT teams and their key initiatives will serve company-wide goals. An IT plan can cover IT strategy, IT governance, IT leadership, and more.";
        data[69] = "IT roadmap: A visual representation of how an IT team is going to meet a set of business objectives and the technical work required to get there. Roadmaps are used to communicate technology initiatives and the progress against the plan. ";
        data[70] = "IT strategy: Identifies how IT will be used to support the needs of the business and determines the direction of all IT activities, roles, and resources.";
        data[71] = "ITIL: IT Infrastructure Library; ITIL is a framework of best practices for achieving IT-business alignment. ITIL V3 (ITIL 2011) organizes ITIL processes around these five service lifecycle stages: Service Strategy, Service Design, Service Transition, Service Operation, and Continual Service Improvement.";
        data[72] = "ITSM: IT service management; ITSM is a set of policies and processes for planning, delivering, and supporting IT services.";
        data[73] = "Javascript: Client-side scripting language commonly used in web development.";
        data[74] = "JSON: JavaScript Object Notation; a lightweight data-interchange format.";
        data[75] = "Kanban: An agile development methodology that helps teams work more efficiently by visualizing work, limiting work-in-progress, and maximizing flow.";
        data[76] = "Kanban board: Visual card-based representation of work and workflow. Cards represent work and columns represent each stage of the process. As work progresses, cards move from left to right across the board. Kanban boards can be digital or physical.";
        data[77] = "Kernel: The core part of an operating system that manages operations of the computer and hardware.";
        data[78] = "LAN: Local area network; Refers to a network of connected devices within a specific location, such as a home or business location.";
        data[79] = "Latency: Sometimes referred to as network or disk latency, this refers to a delay in transmitting or processing data.";
        data[80] = "Loop: A programming structure that repeats a block of code multiple times.";
        data[81] = "Machine language: Consists of binary digits (ones and zeros) or other programming languages that are compiled before the code is run on a computer.";
        data[82] = "Machine learning: A type of artificial intelligence (AI) that learns and evolves over time by identifying patterns based on input.";
        data[83] = "Mainframe: A powerful computer developed for high-volume, processor-intensive computing used by large businesses and institutions.";
        data[84] = "Malware: Software that is designed to cause damage to a computer, steal information, or execute other destructive functions.";
        data[85] = "Metadata: A set of data that describes and gives information about other data.";
        data[86] = "Microservices: A method of developing applications as a collection of services that are modular, loosely coupled, and highly scalable.";
        data[87] = "NaaS: Network as a service; A form of cloud technology that delivers networking resources such as Wide Area Networks (WANs) and Virtual Private Networks (VPNs) to companies from one centralized point. Services are offered on-demand on a pay-as-you-go basis.";
        data[88] = "Network monitoring: An IT process that monitors network technology, including routers, firewalls, and servers for defects and performance issues to ensure everything is optimized.";
        data[89] = "Network security: A set of rules and configurations that is designed to protect the integrity and accessibility of data and various types of technologies, devices, and processes on networks.";
        data[90] = "Network topology: Refers to the way various systems on a computer network are structured, connected, and arranged. Common network topologies include star, ring, line, bus, and tree configurations.";
        data[91] = "Node: A basic unit of a data structure, such as a linked list or tree data structure.";
        data[92] = "Open source: A program's code that is available for free to the public and accessible by anyone. Open source software can be created and modified by an individual, group, or company without concerns over copyright or intellectual property.";
        data[93] = "Operating System: Software that manages computer hardware and software resources.";
        data[94] = "OS : Operating system; Primary system software that a computer or device needs to start and run. The OS communicates with the hardware and other computer programs.";
        data[95] = "OSI: Open Systems Interconnection; A model created by the International Organization for Standardization (ISO) that standardizes communication between computer systems and divides communications into layers including physical, data, network, transport, session, presentation, and application layers.";
        data[96] = "PaaS: Platform as a service; A form of cloud technology whereby a service provider delivers an on-demand, pay-as-you-go platform to its clients. This helps the client develop, run, and manage business applications without having to purchase expensive infrastructure.";
        data[97] = "Patch: A set of changes that are developed and applied to a computer program to update it or fix an identified problem. Patches might apply to security vulnerabilities or software issues like bugs.";
        data[98] = "Phishing: Unsafe or fraudulent emails that appear to come from legitimate websites but are intended to scam or mislead the recipient.";
        data[99] = "Private cloud: Consists of internal or external computing resources that can only be accessed by a single organization. Private clouds are customized to meet specific IT requirements, such as increased security.";
        data[100] = "Program: An executable script or software that consists of compiled code that runs on a computer operating system.";
        data[101] = "Protocol: A standardized set of rules that enable devices to communicate with each other through transmitted data.";
        data[102] = "Provisioning: The process of preparing new systems for users, generally virtualized or on-demand.";
        data[103] = "QoS: Quality of service; Refers to any technology that manages data traffic to reduce latency and loss on the network. May prioritize important traffic to be delivered ahead of other traffic to improve network performance.";
        data[104] = "Query: Code that is written to retrieve information from a database.";
        data[105] = "Regression testing: A type of software testing used during software development to confirm that code changes are running as intended.";
        data[106] = "Remote backup: An online data backup service run by a remote, cloud-based server.";
        data[107] = "Router: A device that forwards data packets between computer networks.";
        data[108] = "RPA: Robotic process automation; A program that simulates the actions of a human. RPA interprets, triggers responses, and communicates with other systems to perform a variety of repetitive tasks.";
        data[109] = "SaaS: Software as a service; A software delivery method whereby a service provider can offer customers the use of web-based software on a pay-as-you-go model over the internet.";
        data[110] = "Scrum: A popular agile development methodology that emphasizes iteration and adaptation. Cross-functional teams work together to achieve a shared goal within a set period of time (usually two to four weeks).";
        data[111] = "SDK: Software development kit; A set of software tools and programs used by developers to create applications for specific platforms.";
        data[112] = "SDLC: Systems development life cycle; A structured approach for developing software that incorporates planning, designing, building, testing, and implementing software.";
        data[113] = "Server: Computer hardware or software that provides data, services, and functionality to other devices or clients. Common servers include database servers, mail servers, and web servers.";
        data[114] = "SLA: Service level agreement; A service-related agreement or contract that outlines a set of deliverables and parameters that a service provider and their client(s) have agreed upon.";
        data[115] = "Spyware: Refers to software that spies on computers to capture sensitive and valuable information like passwords, financial information, and usernames.";
        data[116] = "SSO: Single sign-on; A method of securely authenticating and signing on to multiple applications or websites using just one set of credentials.";
        data[117] = "Syntax: The set of rules that defines the structure of code in a programming language.";
        data[118] = "TCP: Transmission Control Protocol; A fundamental protocol, categorized as a transport layer, that allows systems to communicate over the internet. It creates and maintains connections between hosts.";
        data[119] = "TCP/IP: Transmission Control Protocol/Internet Protocol; Refers to two protocols developed by the U.S. military to allow computers to communicate over long-distance networks. TCP verifies delivery of the packets while IP moves data packets between nodes. TCP/IP is now foundational to the internet.";
        data[120] = "TDD: Test-driven development; Instead of writing code first and then testing it, as in traditional development, TDD starts with a series of tests — followed by coding (and code revisions) until the code passes the tests.";
        data[121] = "Technology stack: The combination of programming languages, tools, services, and software that run an application or underpin a development project.";
        data[122] = "Thick client: A computer that performs the majority of its own processing in client/server applications.";
        data[123] = "Thin client: A computer that does not store data on its own hard drive but instead accesses data from a central server.";
        data[124] = "Thread: The smallest unit of processing that can be executed by a CPU.";
        data[125] = "UDP: User Datagram Protocol;  A communications protocol that is used to speed up data transmissions for time-sensitive communications like domain name system (DNS) or video and audio playback. UDP is an alternative to Transmission Control Protocol (TCP).";
        data[126] = "UI: User interface; Describes how a user controls a particular software program. Users tend to judge a UI by how easy it is to use (usability) and how quickly they can accomplish a given task.";
        data[127] = "Unit testing: A software testing method meant to identify bugs early in the development process. Applications are separated into small parts, or units, that are tested individually and independently. Unit testing is an important element of test-driven development.";
        data[128] = "Uptime: A common metric used to describe system reliability. Uptime is defined in terms of days available out of 365 (e.g. 355) or as a percentage out of 100 (e.g. 95.5%).";
        data[129] = "Usability: Describes whether a user interface (UI) is easy to use. Usability is a key feature of user experience (UX).";
        data[130] = "User acceptance testing: Software tests done in the final phase of testing where the end user tests and verifies that the software meets requirements before it is deployed to production.";
        data[131] = "UX: User experience; Describes the total experience that a user has when accessing and using hardware, software, or a service. Typically refers to how intuitive or enjoyable the experience is. ";
        data[132] = "Virtual Machine: A software-based simulation of a physical computer.";
        data[133] = "Virtualization: The process of creating a virtual or software-based representation of a resource — such as a virtual server, application, operating system, storage, or network. Virtualization allows for efficient distribution of resources and cost-savings for IT.";
        data[134] = "Virus: Malicious programs or scripts designed to negatively impact computers or servers by creating files, relocating, and/or deleting files so that computers no longer function properly.";
        data[135] = "VoIP: Voice over Internet Protocol; Technology that delivers voice communications and multimedia over Internet Protocol (IP) networks so you can make calls over the internet rather than using a traditional phone line.";
        data[136] = "VPN: Virtual private network; A secure, encrypted connection over the internet from a device to a network. VPNs are used for enhancing security and privacy.";
        data[137] = "WAN: Wide area network; A number of smaller local area networks (LANs) that are interconnected. WANs are significantly larger and typically span longer distances via telephone lines, fiber optic cables, or satellite links.";
        data[138] = "WLAN: Wireless local area network; Refers to a local area network (LAN) that allows devices to communicate without the use of any cables.";
        data[139] = "XHTML: Extensible Hypertext Markup Language; A common markup language used in the past for creating webpages. It has been since replaced by HTML5.";
        data[140] = "XML: Extensible Markup Language; A meta-language that defines documents of a standard format so they can be read by a compatible application and can be used with HTML pages.";
        data[141] = "YAML: YAML Ain’t Markup Language; A human-readable data-serialization language commonly used for configuration files and applications where data is stored or transmitted. It targets the same communications applications as XML but uses minimal syntax.";
        data[142] = "Zero-day exploit: Refers to a malicious software vulnerability that is not yet known to the people who will need to address any resulting vulnerabilities, giving them zero days to prepare.";
        data[143] = "Zip: A commonly used type of software that creates a compressed version of a file to reduce the space it takes up during storage and transmission.";
        data[144] = "Zone file: Provides information about one or more domain names, including a list of DNS records. Zone files define the IP address of a domain name and contain DNS and mail server information.";

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
            System.out.println("3. Show all Terms");//Albarico, Jason D.
            System.out.println("4. Search History");
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
                    showAllTerms(); //Menu for List of Terms- Albarico, Jason D.
                    break;
                case 4:
                    showSearchHistory();//method call para ipakita ang search history - Biando, Marc Terence B.
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

            //Enhanced Filtering for User Input - Albarico, Jason D.
            cleanInput = response.trim();// delete spaces. 
            addToHistory(cleanInput);//tawagon ang method para i-save ang user input sa history - Biando, Marc Terence B.
            if (cleanInput.isEmpty()) {
                System.out.println("ERROR: Please enter a word. Input Cannot be blank.");//Invalid Input
                continue;
            }//close if

            int resultIndex = BinarySearch(data, cleanInput);

            if (!displayResult(resultIndex, response)) {
                break;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------  
    //Method for Table of Contents-Albarico, Jason D.
    static void showAllTerms() {
        System.out.println("\n [ALL TERMS]");

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null) {
                //kuhaon ra ang word before ang COLON: | Mo gana ra ang split kug dili null and data[i]
                String TermOnly = data[i].split(":")[0].trim();
                System.out.println("=| " + TermOnly + " |=");
            }//close if
        }//close f-loop
        System.out.println("------------");
    }//close showAllTerms Method

    //------------------------------------------------------------------------------------------------------------  
    // Gilmer Famoso
        static void showRandomTerm() {

        Random rand = new Random();
        int index = rand.nextInt(data.length);
        System.out.println(data[index]);

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

 /* not equal sa -1 means wala sa array list and word na gi pangita sa user.
          pag 1 ang gi enter sa user mu return ang displayResult method ug boolean na false
          i-check diri sa if condition kung false ang na return, 
         pag false, mu break ang loop - Rulona
         
         */
        if (response.equals("1")) {
            System.out.println("Exiting...");
            return false;
        } else if (resultIndex != -1) {
            System.out.println("Result: " + data[resultIndex]);
        } /* else {
         System.out.println("Word not found")} enchance para magamit ang suggestWords --Romnick Felix*/ else {// ge add na method to call the suggestWords method
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

        for (int i = 0; i < data.length; i++) {

            String word = data[i].split(":")[0].trim();
            //if nag matched ang gi enter sa user mag show ang mga terms na naa sa dictionary bisag one letter lang -kelvin monsales
//word.toLowerCase() i ignore niya bisag naka uppercase ang gi enter sa user or lowercase and i convert niya into lowercase ang gi enter sa user. - kelvin monsales
//startsWith(input.toLowerCase()) meaning i check niya if ang gi enter niya na word the same sa gisearch nimi (sample: nag enter kag pro and ang first three letter na naa sa dictionary is available si programming, protocol,produce, i show ni niya tanan kay match man ang first three letter;) - kelvin monsales
            //System.out.println("- " + word); if true siya meanig i show niya tanan terms na match sa gi input nimo - kelvin mosales
            if (word.toLowerCase().startsWith(input.toLowerCase())) {
                System.out.println("- " + word);
                hasSuggestion = true;
            }

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
