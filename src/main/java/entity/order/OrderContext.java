package entity.order;

public class OrderContext {
    private State state;
    public void cancel() {

    }

    public void accepted() {

    }

    public void setState(State state) {
        this.state = state;
    }
}
