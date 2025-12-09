package org.global.academy;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Server {
    private static final Gson gson = new Gson();

    // In-memory deck (7 sample cards)
    private static final List<Flashcard> FLASHCARDS = List.of(
            new Flashcard("ก - กอ ไก่", "ko kai – chicken"),
            new Flashcard("ข - ขอ ไข่", "kho khai – egg"),
            new Flashcard("ฃ - ฃอ ขวด", "kho khuat – bottle"),
            new Flashcard("ค - คอ ควาย", "kho khwai – buffalo"),
            new Flashcard("ฅ - ฅอ คน", "kho khon – person"),
            new Flashcard("ฆ - ฆอ ระฆัง", "kho ra-khang – bell"),
            new Flashcard("ง - งอ งู", "ngo ngu – snake"));

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

        // Get ALL flashcards
        get("/api/flashcards", (req, res) -> {
            res.type("application/json");
            return gson.toJson(FLASHCARDS);
        });

        // Get ONE random flashcard (excluding learned ones)
        post("/showrandcard", (req, res) -> {
            res.type("application/json");
            
            // Get learned card keys from request body
            LearnedRequest learnedReq = gson.fromJson(req.body(), LearnedRequest.class);
            List<String> learnedKeys = learnedReq.learnedKeys != null ? learnedReq.learnedKeys : List.of();
            
            // Filter out learned cards
            List<Flashcard> availableCards = FLASHCARDS.stream()
                .filter(card -> !learnedKeys.contains(card.getFront() + "|" + card.getBack()))
                .collect(Collectors.toList());
            
            if (availableCards.isEmpty()) {
                res.status(404);
                return gson.toJson(new ErrorResponse("All cards have been learned!"));
            }
            
            int i = ThreadLocalRandom.current().nextInt(availableCards.size());
            return gson.toJson(availableCards.get(i));
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
    
    static class LearnedRequest {
        List<String> learnedKeys;
    }
}
