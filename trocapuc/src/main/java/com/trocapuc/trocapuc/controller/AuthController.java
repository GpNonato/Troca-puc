package com.trocapuc.trocapuc.controller;

import com.trocapuc.trocapuc.dto.UserDTO;
import com.trocapuc.trocapuc.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        // Adiciona um objeto ao modelo para o formulário de login
        model.addAttribute("loginForm", new UserDTO());
        
        if (error != null) {
            model.addAttribute("loginError", "Usuário ou senha inválidos.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Logout realizado com sucesso.");
        }
        
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Adiciona um DTO vazio ao modelo
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                           BindingResult bindingResult,
                           @RequestParam String confirmPassword,
                           Model model) {
        // Validação de campos
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Verifica se as senhas coincidem
        if (!userDTO.getPassword().equals(confirmPassword)) {
            model.addAttribute("passwordError", "As senhas não coincidem");
            return "register";
        }

        // Verifica se o CPF já existe
        if (userService.existsByCpf(userDTO.getCpf())) {
            model.addAttribute("cpfError", "CPF já cadastrado");
            return "register";
        }

        // Verifica se o telefone já existe
        if (userService.existsByTelefone(userDTO.getTelefone())) {
            model.addAttribute("telefoneError", "Telefone já cadastrado");
            return "register";
        }

        // Registra o usuário
        userService.registerNewUser(userDTO);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "login";
    }
}
