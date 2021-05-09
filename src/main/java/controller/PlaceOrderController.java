package controller;

import common.exception.InvalidDeliveryInfoException;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderItem;
import entity.shipping.DeliveryInfo;
import entity.shipping.ShippingConfigs;
import org.example.DistanceCalculator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */

/**
 * Logical Cohesion
 * Các hàm validate chỉ liên quan với nhau về mặt logic nhưng
 * không liên quan đến nhau về mặt chức năng
 *
 * Coincidental Cohesion
 * Cac phuong thuc validate khong lien quan den nghiep vu
 * cua lop, nen tach ra thanh mot lop rieng de xu ly
 * ptduc
 * */
/**
 * SOLID: Vi pham SRP vi trong lop chua cac phuong thua validate
 * khi co them yeu cau validate, can thay doi truc tiep code cua class
 * */

/**
 * Duplication of code
 * Hàm validateName và validateAddress giống nhau về chức năng và code nhưng lại tách thành 2 hàm
 * Solution : Kết hợp lại thành 1 hàm duy nhất: validateNameAndAddress
 */
public class PlaceOrderController extends BaseController {

    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the availability of product when user click PlaceOrder button
     * @throws SQLException
     */
    public void placeOrder() throws SQLException {
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    public Order createOrder() throws SQLException {
        return new Order(SessionInformation.cartInstance);
    }

    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    public DeliveryInfo processDeliveryInfo(HashMap info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                String.valueOf(info.get("name")),
                String.valueOf(info.get("phone")),
                String.valueOf(info.get("province")),
                String.valueOf(info.get("address")),
                String.valueOf(info.get("instructions")),
                new DistanceCalculator());
        System.out.println(deliveryInfo.getProvince());
        return deliveryInfo;
    }
    
    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
        if (validatePhoneNumber(info.get("phone"))
        || validateNameAndAddress(info.get("name"))
        || validateNameAndAddress(info.get("address"))) return;
        else throw new InvalidDeliveryInfoException();
    }

    //thay cac bien so, string bang mot hang mang thong tin y nghia
    private static final int PHONE_LENGTH  = 10;
    private static final String PATTERN_STRING =  "^[a-zA-Z\\s]*$";
    private static final String START_NUMBER_PHONE = "0";
    
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != PHONE_LENGTH) return false;
        if (!phoneNumber.startsWith(START_NUMBER_PHONE)) return false;
        try {
            Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public boolean validateNameAndAddress(String srcString) {
        if (Objects.isNull(srcString)) return false;
        String patternString = "^[a-zA-Z\\s]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(srcString);
        return matcher.matches();
    }
    
//    public boolean validateAddress(String address) {
//        if (Objects.isNull(address)) return false;
//        String patternString = "^[a-zA-Z\\s]*$";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(address);
//        return matcher.matches();
//    }
}
