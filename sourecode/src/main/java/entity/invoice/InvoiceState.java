package entity.invoice;

public interface InvoiceState {
    void setInvoice(Invoice invoice);
    void cancelOrder();
    void confirmOrder();
}
