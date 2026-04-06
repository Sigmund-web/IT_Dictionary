# 📘 IT Dictionary - Java Project

A collaborative, console-based IT Encyclopedia and Quiz system. This project features high-performance searching, fuzzy string matching for typos, and an interactive learning mode.

---

## 🚀 Features

* **Word of the Day:** Automatically picks a random term on startup.
* **Exact Term Search:** Uses **Binary Search** for instant definitions.
* **Smart Suggestions:** * **Prefix Matching:** Finds words starting with your input.
    * **Fuzzy Search:** Uses **Levenshtein Distance** to suggest the correct word if you make a typo.
* **Search History:** Remembers your last 10 searches.
* **Random Term:** Displays a random IT term and definition for quick learning.
* **Interactive Quiz:** A 5-question IT quiz with randomized questions and shuffled multiple-choice answers.

---

## 🛠️ How to Run

1.  **Requirement:** Ensure you have `Data.java` in the same folder as `IT_Dictionary.java`.
2.  **Compile:**
    ```bash
    javac IT_Dictionary.java Data.java
    ```
3.  **Run:**
    ```bash
    java IT_Dictionary
    ```

---

## 📂 Project Structure

| File | Description |
| :--- | :--- |
| `IT_Dictionary.java` | Main application logic, UI, and algorithms. |
| `Data.java` | The database file containing the `String[] data` array. |

---

## 👥 Contributors

This project was built through the collaboration of:

* **Logic & Scanners:** Kenneth D. Bantayan
* **Search History:** Marc Terence B. Biando
* **Word of the Day:** Pee Jay Mendez
* **Menu & Loop:** Benedict E. Guino-o, Gilmer C. Famoso
* **Console UI:** Cris Laurence Longino
* **Binary Search:** Sigmund Sayabo
* **Search Handling:** Maddie L. Rulona, Jason D. Albarico
* **Levenshtein Algorithm:** Jeskyle A. Ranises
* **Suggestion Engine:** Joseph Divino, Monsales, Felix
* **Quiz System:** Andre Servidor

---

## 📝 Usage Tips
* **Search:** Type the word exactly, or just the first few letters.
* **Typos:** If you misspell a word, the system will ask "Did you mean...?"
* **Exit:** Enter `0` at any main prompt to return or close the app.
