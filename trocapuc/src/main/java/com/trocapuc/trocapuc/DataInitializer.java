package com.trocapuc.trocapuc;

import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByCpf("12345678901").isEmpty()) {
            User defaultUser = new User();
            defaultUser.setUsername("admin");
            defaultUser.setEmail("admin@example.com");
            defaultUser.setCpf("12345678901");
            defaultUser.setTelefone("1234567890");
            defaultUser.setPassword(passwordEncoder.encode("password123"));
            userRepository.save(defaultUser);
            System.out.println("Usuário padrão criado: admin / password123");
        } else {
            System.out.println("Usuário padrão já existe.");
        }
    }
}
