package com.trocapuc.trocapuc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trocapuc.trocapuc.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Buscar todos os itens por usuário
    List<Item> findByOwnerId(Long ownerId);
    
    // Buscar itens cujo proprietário não é o usuário especificado
    List<Item> findByOwnerIdNot(Long userId);

    // Método para contar itens por categoria
    Long countByCategory(String category);
}
