package com.trocapuc.trocapuc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trocapuc.trocapuc.model.Item;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.UserRepository;
import com.trocapuc.trocapuc.service.ItemService;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemService itemService;

    @GetMapping("/search")
    public String searchItems(@RequestParam(value = "query", required = false, defaultValue = "") String query,
            Model model , Principal principal) {
        List<Item> filteredItems = query.isEmpty() ? itemService.findAll() : itemService.searchItems(query);
        User currentUser = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("items", filteredItems);
        model.addAttribute("currentUserId", currentUser.getId()); // Passa o ID do usuário logado para o Thymeleaf
        return "search";
    }

}
