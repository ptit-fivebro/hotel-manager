package com.springframework.hotel.dto;

import com.springframework.hotel.models.FoodItem;

public class MenuOrderFoodDto {

    private Long id;
    private String name;
    private Integer quantity;
    private String price;
    private String total;

    public MenuOrderFoodDto(FoodItem item, Integer quantity) {
        super();
        this.id = item.getId();
        this.name = item.getName();
        this.quantity = quantity;
        this.price = item.getPrice();
        this.total = String.valueOf(this.quantity * Integer.parseInt(this.price));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MenuOrderFoodDto [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price
                + ", total=" + total + "]";
    }


}
