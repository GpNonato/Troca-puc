package com.trocapuc.trocapuc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trocapuc.trocapuc.dto.UserDTO;
import com.trocapuc.trocapuc.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        System.out.println("Método showProfile chamado!");
        try {
            UserDTO userDTO = userService.getCurrentUserProfile();
            model.addAttribute("userDTO", userDTO);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", "Erro ao carregar o perfil: " + e.getMessage());
            return "error"; // Redirecione para uma página de erro personalizada
        }
        return "profile";
    }

    
    @PostMapping("/profile")
    public String updateProfile(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult,
                                Model model,
                                HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }
    
        // Atualizar perfil
        boolean requiresRelogin = userService.updateUserProfile(userDTO);
    
        if (requiresRelogin) {
            // Invalidar sessão
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
    
            // Adicionar mensagem de aviso
            model.addAttribute("infoMessage", "Alteração realizada com sucesso. Por favor, faça login novamente.");
            return "redirect:/login";
        }
    
        model.addAttribute("successMessage", "Perfil atualizado com sucesso!");
        return "profile";
    }
    
    
}


