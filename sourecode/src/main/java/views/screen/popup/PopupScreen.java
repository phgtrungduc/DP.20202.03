package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;


public class PopupScreen extends BaseScreenHandler {

    @FXML
    ImageView icon;

    @FXML
    Label message;
    public static final double TIME = 0.8;
    public PopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH,null);
    }

    private static PopupScreen createPopupScreen(String message, String imagePath, Boolean undecorated) throws IOException{
        PopupScreen popup = new PopupScreen(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(imagePath);
        return popup;
    }

    public static void showSuccessPopup(String message) throws IOException{
        createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png", true)
                .show(true);
    }

    public static void showErrorPopup(String message) throws IOException{
        createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "tickerror.png", false)
                .show(false);
    }

    public static PopupScreen createLoadingPopup(String message) throws IOException{
        return createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void show(Boolean autoClose) {
        super.show();
        if (autoClose) close(TIME);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    public void setupData(Object dto) throws Exception {
    }

    public void setupFunctionality() throws Exception {
    }
}
