package com.trocapuc.trocapuc.controller;

import com.trocapuc.trocapuc.dto.ItemDTO;
import com.trocapuc.trocapuc.model.Item;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.service.ItemService;
import com.trocapuc.trocapuc.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MarketController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @GetMapping("/market/personal")
    public String showPersonalItems(Model model) {
        List<Item> items = itemService.getItemsByCurrentUser();
        model.addAttribute("items", items);
        model.addAttribute("itemDTO", new ItemDTO());
        return "personalitem";
    }
    @GetMapping("/")
    public String showPersonalItems2(Model model) {
        List<Item> items = itemService.getItemsByCurrentUser();
        model.addAttribute("items", items);
        model.addAttribute("itemDTO", new ItemDTO());
        return "personalitem";
    }

    @PostMapping("/market/personal")
    public String createItem(@Valid @ModelAttribute("itemDTO") ItemDTO itemDTO, BindingResult bindingResult, @RequestParam("image") MultipartFile imageFile,
            Model model) {
        // if (bindingResult.hasErrors()) {
        //     model.addAttribute("errorMessage", "Erro ao criar item. Verifique os dados e tente novamente.");
        //     return "personalitem";
        // }
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                itemDTO.setImage(imageFile.getBytes());
            } else {
                itemDTO.setImage(null); // Garanta que o campo seja nulo, se não houver arquivo
            }
        User currentUser = userService.getCurrentUser(); // Método que retorna o usuário autenticado
        itemService.createItem(itemDTO, currentUser);
        model.addAttribute("successMessage", "Item criado com sucesso!");
        return "redirect:/market/personal";
    }catch (Exception e) {
        System.out.println(e);
        model.addAttribute("errorMessage", "Erro ao processar a imagem. Tente novamente.");
        e.printStackTrace();
        return "personalitem";
    }
}

    @GetMapping("/market/{itemId}/delete")
    public String deleteItem(@PathVariable Long itemId, Model model) {
        try {
            itemService.deleteItemById(itemId);
            model.addAttribute("successMessage", "Item excluído com sucesso!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao excluir item: " + e.getMessage());
        }
        return "redirect:/market/personal";
    }

    @GetMapping("/market/all")
    public String showAllItems(Model model) {
        User currentUser = userService.getCurrentUser(); // Método que retorna o usuário autenticado
        List<Item> allItems = itemService.getItemsExcludingUser(currentUser.getId());
        model.addAttribute("items", allItems);
        return "allitem";
    }

    @GetMapping("/image/{id}")
@ResponseBody
public byte[] getImage(@PathVariable Long id) {
    Item item = itemService.findById(id);
    if (item.getImage() == null) {
        throw new RuntimeException("Imagem não encontrada para o item com ID: " + id);
    }
    return item.getImage(); // Retorna os bytes da imagem
}

@PostMapping("/market/personal/edit")
public String editItem(@Valid @ModelAttribute("itemDTO") ItemDTO itemDTO, BindingResult bindingResult,
        Model model) {
    if (bindingResult.hasErrors()) {
        model.addAttribute("errorMessage", "Erro ao atualizar item. Verifique os dados e tente novamente.");
        return "personalitem"; // Retorna à página atual com erros
    }
    try {
        User currentUser = userService.getCurrentUser(); // Método para obter o usuário autenticado
        itemService.updateItem(itemDTO, currentUser); // Atualiza o item
        model.addAttribute("successMessage", "Item atualizado com sucesso!");
    } catch (Exception e) {
        model.addAttribute("errorMessage", "Erro ao atualizar item: " + e.getMessage());
    }
    return "redirect:/market/personal";
}
}
