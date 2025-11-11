package LabTuto08;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Alice", 101);
        // Serialize (save)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(s1);
        }
        // Deserialize (load)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s2 = (Student) in.readObject();
            System.out.println("Loaded: " + s2.name + ", " + s2.id);
        }
    }
}
