package views.screen.invoice;

import controller.InvoiceController;
import controller.ViewCartController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.cart.CartScreenHandler;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class ListInvoiceHandler extends BaseScreenHandler {
    private static Logger LOGGER = Utils.getLogger(CartScreenHandler.class.getName());

    @FXML
    private ImageView aimsImage;

    @FXML
    private Label pageTitle;

    @FXML
    VBox vboxCart;

    @FXML
    private Label shippingFees;

    @FXML
    private Label labelAmount;

    @FXML
    private Label labelSubtotal;

    @FXML
    private Label labelVAT;

    @FXML
    private Button btnPlaceOrder;

    protected ListInvoiceHandler(Stage stage, String screenPath, Object dto) throws IOException {
        super(stage, screenPath, dto);
    }

    @Override
    public void setupData(Object dto) throws Exception {
    }

    @Override
    public void setupFunctionality() throws Exception {
        File file = new File(ViewsConfig.IMAGE_PATH + "/Logo.png");
        Image im = new Image(file.toURI().toString());
        aimsImage.setImage(im);

        // on mouse clicked, we back to home
        aimsImage.setOnMouseClicked(e -> {
            homeScreenHandler.show();
        });

        // on mouse clicked, we start processing place order use case
        btnPlaceOrder.setOnMouseClicked(e -> {
            LOGGER.info("Place Order button clicked");
        });
    }
    public InvoiceController getBController(){
        return (InvoiceController) super.getBController();
    }

}
