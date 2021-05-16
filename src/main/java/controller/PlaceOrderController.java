package controller;

import common.exception.InvalidDeliveryInfoException;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.shipping.DeliveryInfo;
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
        SessionInformation.getCartInstance().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    public Order createOrder() throws SQLException {
        return new Order(SessionInformation.getCartInstance());
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
    /**
     * Stamp coupling
     * Truyền vào param info dạng Hash Map nhưng thực tế
     * chỉ sử dụng các trường: name, phone, province, address, instructions
     *ptduc
     * */
    public DeliveryInfo processDeliveryInfo(HashMap info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                String.valueOf(info.get("name")),
                String.valueOf(info.get("phone")),
                String.valueOf(info.get("province")),
                String.valueOf(info.get("address")),
                String.valueOf(info.get("instructions")));
        System.out.println(deliveryInfo.getProvince());
        return deliveryInfo;
    }
    
    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
    /**
     * Stamp coupling
     * Truyền vào param dạng hash map nhưng thực tế
     * chỉ sử dụng đến các trường: phone, name, address
     * */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
        if (validatePhoneNumber(info.get("phone"))
        || validateNameAndAddress(info.get("name"))
        || validateNameAndAddress(info.get("address"))) return;
        else throw new InvalidDeliveryInfoException();
    }
    
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) return false;
        if (!phoneNumber.startsWith("0")) return false;
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
