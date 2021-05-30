package entity.invoice;

public class CreateInvoiceState implements InvoiceState{
    Invoice invoice;
    @Override
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void cancelOrder() {
        invoice.changeState(new CancelInvoiceState());
    }

    @Override
    public void confirmOrder() {
        invoice.changeState(new ConfirmInvoiceState());
    }

}
