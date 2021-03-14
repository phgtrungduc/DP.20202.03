package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
//Content Coupling
//Variable o dang public khong co get set kho kiem soat duoc viec truy cap
public class SessionInformation {

    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;

}
