package entity.shipping.v2;

import entity.order.Order;

public class DeliveryInfo_v2 {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;




    /**
     * SOLID: Vi phạm open/close vi khi thay doi phuong thuc thanh toan
     * can thay doi truc tiep class nay
     * Vi pham DIP: module muc cao phu thuoc module muc thap
     * */
    protected DistanceCalculatorFactory distanceCalculatorFactory;
    public DeliveryInfo_v2(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculatorFactory distanceCalculatorFactory) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculatorFactory = distanceCalculatorFactory;
    }

    /**
     * Stamp coupling
     * Truyền vào order nhưng không sử dụng
     * (có thể lỗi lập trình chưa sửa )
     * ptduc
     * */
    /**
     * SOLID: Vi phạm OCP
     * Sử dùng trực tiếp cách tính phí của module distanceCalculator
     * Thay doi cach tinh phi se phai thay doi code cua class
     * SOLID : Vi pham SRP
     * Nghiep vu cua lop chi chua cac thong tin giao hang
     * Phan tinh phi giao hang nen tach ra thanh class rieng
     * */
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculatorFactory.createDistanceCalculator().calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
