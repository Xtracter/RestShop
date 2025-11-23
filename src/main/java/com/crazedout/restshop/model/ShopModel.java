package com.crazedout.restshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

/**
 * Model for table restshop.
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "restshop")
public class ShopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private boolean completed = false;

    private Instant createdAt = Instant.now();

    public ShopModel() {}

    /**
     * Creates a RESTModel object.
     * @param title Title of the RestShop object.
     * @param description Description of rest Shop
     */
    public ShopModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the table id of this RestShop object
     * @return id
     */
    public Long getId() { return id; }

    /**
     * Sets the id for this RestShop object.
     * @param id table id.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets the title of this RestShop object.
     * @return title.
     */
    public String getTitle() { return title; }

    /**
     * Seta the title for this restShop object.
     * @param title Title string.
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Gets the description of this RestShop object.
     * @return description Description String.
     */
    public String getDescription() { return description; }

    /**
     * Sets the description of this RestShop object.
     * @param description Description String.
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the completed state of this RestShop object.
     * @return boolean completed.
     */
    public boolean isCompleted() { return completed; }

    /**
     * Sets the completed state of this RestShop object.
     * @param completed boolean completed.
     */
    public void setCompleted(boolean completed) { this.completed = completed; }

    /**
     * Gets the created Instant of this RestShop object.
     * @return Instant moment in time.
     */
    public Instant getCreatedAt() { return createdAt; }

    /**
     * Sets the created Instant of this RestShop object.
     * @param createdAt Instant in time.
     */
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
