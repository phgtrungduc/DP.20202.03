package entity.invoice;


public class ConfirmInvoiceState implements InvoiceState {
    Invoice invoice;
    @Override
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void cancelOrder() {
        return;
    }

    @Override
    public void confirmOrder() {
        return;
    }

}
