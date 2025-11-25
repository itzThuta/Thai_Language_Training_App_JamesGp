# Thai Language Training App

A lightweight **Java-based flashcard application** designed to help learners practice Thai vocabulary.  
The app uses digital flashcards that allow users to flip between **Thai words** and their **English meanings**, providing a simple and effective way to build vocabulary.  
This project is ideal for beginners exploring the Thai language or anyone who wants a minimal, easy-to-run learning tool.

---

## ✨ Features
- 🔄 **Flip Thai ↔ English flashcards**
- 🧠 **Learn vocabulary one card at a time**
- 🎨 **Clean, minimalist user interface**
- ☕ **Java-based** — fully cross-platform
- 🌐 **Web interface powered by Spark Java**
- 📁 Easy-to-understand project structure

---

## 📁 Project Structure
```
root/
│── webservices/
│   │── src/main/java/org/global/academy/
│       ├── Flashcard.java
│       ├── Server.java
│   ├── resources/public/
│       ├── index.html
│       ├── login.html
│       ├── welcome.html
│   ├── target/
│── mvnw
│── mvnw.cmd
│── pom.xml
│── run.txt
│── README.md
```

All backend-related code and runnable components for the web interface are located inside the **webservices** folder.

---

## 🚀 Getting Started

Follow these steps to run the project locally.

### 1. Navigate into the `webservices` folder
Open your terminal or command prompt:

```sh
cd webservices
```

---

### 2. Build the project using Maven Wrapper

#### Windows
```sh
.\mvnw clean package
```

#### macOS / Linux
```sh
bash mvnw clean package
```

This will generate the JAR file in the `target` folder.

---

### 3. Run the application

```sh
java -jar target/spark-hello-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

### 4. Open the application in your browser

Once the server is running, open:

👉 **http://localhost:8080/login.html**

This allows you to interact with the flashcard system through a clean web interface.

---

## 🛠 Requirements
- Java **8 or higher**
- Maven Wrapper (already included)
- Any modern web browser

---

## 📸 Screenshots (Optional)
Add your screenshots here:

```
![Flashcard Screenshot](screenshots/flashcard.png)
```

---

## 📦 Technologies Used
- **Java**
- **Spark Java** (backend)
- **HTML / CSS / JavaScript** (frontend)
- **Maven Wrapper**

---

## 📚 Future Improvements
- Add multiple vocabulary decks  
- Add spaced repetition system (SRS)
- Add user progress tracking
- Add audio pronunciation
- Build a GUI version (JavaFX or Swing)

---

## 📄 License
This project is open-source and free to modify for learning or development purposes.
