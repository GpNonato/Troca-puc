package com.trocapuc.trocapuc.service;

import com.trocapuc.trocapuc.dto.ItemDTO;
import com.trocapuc.trocapuc.model.Item;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserService userService;

    public List<Item> getItemsByCurrentUser() {
        User currentUser = userService.getCurrentUser(); // Método para obter o usuário autenticado
        return itemRepository.findByOwnerId(currentUser.getId());
    }
    

    public void createItem(ItemDTO itemDTO, User currentUser) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setCategory(itemDTO.getCategory());
        item.setType(itemDTO.getType());
        if ("sell".equalsIgnoreCase(itemDTO.getCategory())) {
            item.setPrice(itemDTO.getPrice());
        }
        item.setOwner(currentUser); // Vincula o item ao usuário atual
        if (itemDTO.getImage() != null && itemDTO.getImage().length > 0) {
            item.setImage(itemDTO.getImage());
        }
        itemRepository.save(item);
    }

    public void deleteItemById(Long itemId) {
        User currentUser = userService.getCurrentUser();
        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new IllegalArgumentException("O item não foi encontrado."));
        if (!item.getOwner().equals(currentUser)) {
            throw new SecurityException("Você não tem permissão para excluir este item.");
        }
        itemRepository.deleteById(itemId);
    }

    public List<Item> searchItems(String query) {
    return itemRepository.findAll().stream()
        .filter(item -> item.getName().toLowerCase().contains(query.toLowerCase()) ||
                        item.getDescription().toLowerCase().contains(query.toLowerCase()))
        .collect(Collectors.toList());
}

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com ID: " + id));
    }    

    public List<Item> getItemsExcludingUser(Long userId) {
        return itemRepository.findByOwnerIdNot(userId); // Supondo que o repository tenha essa query
    }


    public void updateItem(ItemDTO itemDTO, User currentUser) {
        Item item = itemRepository.findById(itemDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
    
        // Verifica se o item pertence ao usuário atual
        if (!item.getOwner().getId().equals(currentUser.getId())) {
            throw new SecurityException("Você não tem permissão para editar este item.");
        }
    
        // Atualiza os campos do item
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setCategory(itemDTO.getCategory());
        item.setType(itemDTO.getType());
        item.setPrice(itemDTO.getPrice());
    
        itemRepository.save(item); // Salva as alterações no banco de dados
    }
}
