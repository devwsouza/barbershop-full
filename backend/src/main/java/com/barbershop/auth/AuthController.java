package com.barbershop.auth;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
 @PostMapping("/login")
 public Map<String,String> login(@RequestBody Map<String,String> req){
  return Map.of("token","jwt-demo-token","tenant","demo-tenant");
 }
}
