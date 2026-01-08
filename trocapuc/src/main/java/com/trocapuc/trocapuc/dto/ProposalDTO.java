package com.trocapuc.trocapuc.dto;

import com.trocapuc.trocapuc.model.ProposalStatus;

public class ProposalDTO {

    private Long id;
    private Long itemId;
    private String itemName;
    private String description;
    private Double price;
    private ProposalStatus status;
    private String oTelefone;
    private String iTelefone;

    // Getters e Setters

    public String getOTelefone() { return oTelefone; }

    public void setOTelefone(String oTelefone) { this.oTelefone = oTelefone; }

    public String getITelefone() { return iTelefone; }

    public void setITelefone(String iTelefone) { this.iTelefone = iTelefone; }
    
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getItemId() { return itemId; }

    public void setItemId(Long itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public ProposalStatus getStatus() { return status; }

    public void setStatus(ProposalStatus status) { this.status = status; }

    
}