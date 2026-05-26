package com.barbershop.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {
    "https://barbershop-app-lake.vercel.app"
})
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User login(@RequestBody User request) {

        // 🔍 buscar usuário no banco
        return userRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElse(null); // ✅ NÃO lança erro (evita 500)
    }
}