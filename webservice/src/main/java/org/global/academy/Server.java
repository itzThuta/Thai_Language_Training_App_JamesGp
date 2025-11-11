package org.global.academy;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Server {
    private static final Gson gson = new Gson();

    // In-memory deck (10 sample cards)
    private static final List<Flashcard> FLASHCARDS = List.of(
            new Flashcard("ก - กอ ไก่", "ko kai – chicken"),
            new Flashcard("ข - ขอ ไข่", "kho khai – egg"),
            new Flashcard("ฃ - ฃอ ขวด", "kho khuat – bottle"),
            new Flashcard("ค - คอ ควาย", "kho khwai – buffalo"),
            new Flashcard("ง - งอ งู", "ngo ngu – snake"),
            new Flashcard("จ - จอ จาน", "cho chan – plate"),
            new Flashcard("ฉ - ฉอ ฉิ่ง", "cho ching – cymbals"),
            new Flashcard("ช - ชอ ช้าง", "cho chang – elephant"),
            new Flashcard("ซ - ซอ โซ่", "so so – chain"),
            new Flashcard("ฌ - ฌอ เฌอ", "cho choe – tree"));

    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/public"); // serve /public from resources

        // CORS
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });
        options("/*", (req, res) -> {
            String h = req.headers("Access-Control-Request-Headers");
            if (h != null)
                res.header("Access-Control-Allow-Headers", h);
            String m = req.headers("Access-Control-Request-Method");
            if (m != null)
                res.header("Access-Control-Allow-Methods", m);
            return "OK";
        });

        // Sample: GET /random -> {random: n}
        get("/random", (req, res) -> {
            int n = new Random().nextInt(100) + 1;
            res.type("application/json");
            return gson.toJson(Map.of("random", n));
        });

        // LOGIN
        post("/login", (req, res) -> {
            System.out.println("Received /login request with body: " + req.body());
            LoginRequest lr = gson.fromJson(req.body(), LoginRequest.class);
            if ("alice".equals(lr.username) && "secret".equals(lr.password)) {
                res.type("application/json");
                return gson.toJson(new LoginResponse("a-fake-token", lr.username));
            } else {
                res.status(401);
                res.type("application/json");
                return gson.toJson(new ErrorResponse("Invalid credentials"));
            }
        });

        // ✅ NEW: get ALL flashcards
        get("/api/flashcards", (req, res) -> {
            res.type("application/json");
            return gson.toJson(FLASHCARDS);
        });

        // ✅ NEW: get ONE random flashcard
        get("/api/flashcards/random", (req, res) -> {
            res.type("application/json");
            int i = ThreadLocalRandom.current().nextInt(FLASHCARDS.size());
            return gson.toJson(FLASHCARDS.get(i));
        });

        // Health check
        get("/health", (req, res) -> "OK");
    }

    static class LoginRequest {
        String username;
        String password;
    }

    static class LoginResponse {
        String token;
        String username;

        LoginResponse(String t, String u) {
            token = t;
            username = u;
        }
    }

    static class ErrorResponse {
        String error;

        ErrorResponse(String e) {
            error = e;
        }
    }
}
