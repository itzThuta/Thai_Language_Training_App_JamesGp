package org.global.james;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin 
public class LoginController {

    static class LoginRequest { public String username; public String password; }
    static class LoginResponse { public String token; public LoginResponse(String t){token=t;} }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        if ("alice".equals(req.username) && "secret".equals(req.password))
            return ResponseEntity.ok(new LoginResponse("abc123token"));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("{\"error\": \"Invalid username or password\"}");
    }

    // (Optional) add this if you want /login to show a friendly message for GET
    @GetMapping("/login")
    public String loginInfo() {
        return "Please POST JSON {username, password} to this endpoint.";
    }
}
