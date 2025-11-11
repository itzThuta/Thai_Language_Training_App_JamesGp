package LabTuto08;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudent {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("student.json")) {
            StudentJ s = gson.fromJson(reader, StudentJ.class);
            System.out.println("Name: " + s.name);
            System.out.println("ID: " + s.id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
