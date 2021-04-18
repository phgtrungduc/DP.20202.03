package entity.cart;

import entity.media.Media;

import java.sql.SQLException;

public class CartItem {
    
    private Media media;
    private int quantity;
    private int price;

    public CartItem(){

    }

    public CartItem(Media media, Cart cart, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Clean code: Them phuong thuc tinh total
    public int getTotal(){
        return this.getPrice() * this.getQuantity();
    }
    // Clean code: Them phuong thuc xac dinh AvailableQuantity
    public boolean availableQuantity() throws SQLException{
        return this.getMedia().getQuantity() > this.getQuantity();
    }
    @Override
    public String toString() {
        return "{" 
            + " media='" + media + "'" 
            + ", quantity='" + quantity + "'" 
            + "}";
    }

}

    
