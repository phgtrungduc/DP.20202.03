package controller;

import common.exception.InvalidDeliveryInfoException;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderItem;
import entity.shipping.DeliveryInfo;
import entity.shipping.DistanceCalculatorFactory;
import entity.shipping.DistanceAPIFactory;
import entity.shipping.DistanceFactory;
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
        return new DeliveryInfo(
                String.valueOf(info.get("name")),
                String.valueOf(info.get("phone")),
                String.valueOf(info.get("province")),
                String.valueOf(info.get("address")),
                String.valueOf(info.get("instructions")),
                new DistanceCalculatorFactory());
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
        || validateName(info.get("name"))
        || validateAddress(info.get("address"))) {
        }
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
    
    public boolean validateName(String name) {
        if (Objects.isNull(name)) return false;
        Pattern pattern = Pattern.compile(PATTERN_STRING);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    
    public boolean validateAddress(String address) {
        if (Objects.isNull(address)) return false;
        Pattern pattern = Pattern.compile(PATTERN_STRING);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
}
