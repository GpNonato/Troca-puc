package com.trocapuc.trocapuc.dto;

import com.trocapuc.trocapuc.model.User;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ItemDTO {

    private long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotBlank(message = "A categoria é obrigatória")
    private String category;

    @NotBlank(message = "O tipo é obrigatório")
    private String type;

    @Min(value = 0, message = "O preço deve ser maior ou igual a 0")
    private Double price; // Opcional para categoria 'donation'

    private User owner; 

    private byte[] image;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

}
