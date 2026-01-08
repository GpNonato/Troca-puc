package com.trocapuc.trocapuc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_owner_id", nullable = false)
    private User itemOwner;

    @ManyToOne
    @JoinColumn(name = "item_interested_id", nullable = false)
    private User itemInterested;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private String description;

    @Column
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProposalStatus status;

    @SuppressWarnings("unused")
    private String oTelefone;

    @SuppressWarnings("unused")
    private String iTelefone;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }

        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null.");
        }
    }

    // Getters e Setters
    public User getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(User itemOwner) {
        this.itemOwner = itemOwner;
    }

    public User getItemInterested() {
        return itemInterested;
    }

    public void setItemInterested(User itemInterested) {
        this.itemInterested = itemInterested;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProposalStatus getStatus() {
        return status;
    }

    public void setStatus(ProposalStatus status) {
        this.status = status;
    }

    public Long getId() {  return id; }

    public void setId(Long id) { this.id = id; }

    public String getoTelefone() { return itemOwner.getTelefone(); }

    public void setoTelefone(String oTelefone) { this.oTelefone = oTelefone; }

    public String getiTelefone() { return itemInterested.getTelefone(); }

    public void setiTelefone(String iTelefone) { this.iTelefone = iTelefone; }
}

