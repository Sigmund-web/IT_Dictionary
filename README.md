📘 IT Dictionary
A feature-rich, collaborative Java console application that serves as a digital glossary for IT terminology. This project incorporates search algorithms, fuzzy matching (Levenshtein Distance), and an interactive quiz system.

🚀 Features
Word of the Day: Automatically selects a random IT term from the database upon startup to encourage daily learning.

Exact Term Search: Uses a Binary Search Algorithm for high-performance lookup of specific definitions.

Smart Suggestions: * Prefix Matching: Finds words starting with the user's input.

Fuzzy Search: Uses the Levenshtein Distance algorithm to suggest corrections for misspelled words.

Search History: Keeps track of your last 10 searches in a rolling history list.

Random Term Generator: Perfect for quick learning sessions or "flashcard" style browsing.

IT Quiz: An interactive 5-question quiz with randomized question orders and shuffled multiple-choice answers to test your knowledge.

🛠️ Technical Details
Key Algorithms Used
Binary Search: Implemented in BinarySearch() to efficiently navigate the sorted dictionary data.

Levenshtein Distance: A dynamic programming approach used in levenshteinDistance() to calculate the "edit distance" between strings for typo correction.

Fisher-Yates Shuffle (Modified): Used in the Quiz module to ensure questions and answer choices are randomized every time.

Project Structure
IT_Dictionary.java: The main logic containing the menu system, search engines, and quiz functionality.

💻 How to Run
Ensure you have the Java Development Kit (JDK) installed.

Include the Data.java file (containing the dictionary entries) in the same directory as IT_Dictionary.java.

Compile the program:

Bash
javac IT_Dictionary.java Data.java
Run the application:

Bash
java IT_Dictionary

Data.java: (External dependency) Contains the data array housing the IT terms and definitions in the format Term : Definition.
