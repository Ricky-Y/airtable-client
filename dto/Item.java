package com.freespacenow.airtable.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("FB Condition")
    private String fbCondition;
    @JsonProperty("EBayCondition")
    private String eBayCondition;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("Photo")
    private List<Photo> photo;
    @JsonProperty("Order")
    private List<String> order;

    @JsonCreator
    public Item() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFbCondition() {
        return fbCondition;
    }

    public void setFbCondition(String fbCondition) {
        this.fbCondition = fbCondition;
    }

    public String geteBayCondition() {
        return eBayCondition;
    }

    public void seteBayCondition(String eBayCondition) {
        this.eBayCondition = eBayCondition;
    }
}
