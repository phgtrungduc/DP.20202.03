package entity.invoice;

import entity.order.Order;


public class Invoice {

    private Order order;
    private int amount;
    private InvoiceState state;
    public Invoice(){

    }

    public Invoice(Order order,InvoiceState initState){
        this.order = order;
        this.amount = order.getTotal();
        this.state = initState;
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        
    }
    public void cancelOrder(){
        state.cancelOrder();
    };
    public void confirmOrder(){
        state.confirmOrder();
    };
    public void changeState(InvoiceState state){
        this.state = state;
    }
}
