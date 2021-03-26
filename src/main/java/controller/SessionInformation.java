package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */

//content couling, common coupling
    /**
     * Content couling, Common coupling
    * các thuộc tính đều ở dạng public, tuy nhiên không cung cấp
    * các phương thức get và set để thay đổi chúng nên các module
    * sử dụng đều phải truy cập trực tiếp vào thuộc tính để thay đổi
     * Gây ra cả content và common ở một số module
     * ptduc
    * */
/**
 * ap dung singleton
 * cartInstance luu tru gio hang hien tai nen chi can khoi tao 1 lan
 * */

public class SessionInformation {


    public static User mainUser;
    private static Cart cartInstance = null;
    public static LocalDateTime expiredTime;

    public static Cart getCartInstance() {
        if (cartInstance==null) cartInstance = new Cart();
        return cartInstance;
    }
}
