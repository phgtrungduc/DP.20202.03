package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

public class Cart {

    
    private List<CartItem> lstCartItem;

    public Cart() {
        lstCartItem = new ArrayList<>();
    }

    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }

    public int getTotalMedia(){
        int total = 0;
        // Clean code: Sua ten bien

        for (CartItem cartItem: lstCartItem) {
            total += cartItem.getQuantity();
        }
        return total;
    }

    public int calSubtotal(){
        // Clean code: Tao phuong thuc tinh total
        int total = 0;
        for (CartItem cartItem : lstCartItem) {
            total += cartItem.getTotal();
        }
        return total;
    }
    // Clean code: tao phuong thuc availableQuantity
    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (CartItem cartItem : lstCartItem) {
            allAvailable = cartItem.availableQuantity();
            /* int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
            */

        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }

    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
