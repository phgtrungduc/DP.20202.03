package entity.shipping;

public class AltDistanceBehavior implements DistanceBehavior{
//    constructor
    @Override
    public int calculateShippingFee(String address, String province) {
        return 0;
    }
}
