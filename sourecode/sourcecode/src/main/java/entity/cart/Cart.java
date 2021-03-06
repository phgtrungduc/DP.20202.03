package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;


/**
 * Fuctional Cohesion
 * Cac phuong thuc deu su dung chung data la lstCartItem
 * va deu lien quan den chuc nang lien quan den cart
 * */
/**
 * Ap dung singleton
 * Luu tru gio hang hien tai nen chi can khoi tao 1 lan
 * */
/**
 * Large class
 */
public class Cart {
    private static Cart cart;
    private Cart(){
        lstCartItem = new ArrayList<>();
    };
    public static Cart getCartInstance(){
        if (cart==null) cart = new Cart();
        return cart;
    }
    private List<CartItem> lstCartItem;

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
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    public int calSubtotal(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getPrice()*cm.getQuantity();
        }
        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }

    /**
     * Stamp coulping
     * Chỉ sử dụng mỗi Id
     * */
    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
