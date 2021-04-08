package views.screen.home;

import controller.AuthenticationController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;


public class LoginScreenHandler extends BaseScreenHandler{

    public static Logger LOGGER = Utils.getLogger(LoginScreenHandler.class.getName());

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    public LoginScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        try {
            this.setUp(null);
        } catch (IOException ex) {
            LOGGER.info(ex.getMessage());
            PopupScreen.showErrorPopup("Error when loading resources.");
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            PopupScreen.showErrorPopup(ex.getMessage());
        }
    }

    public AuthenticationController getBController() {
        return (AuthenticationController) super.getBController();
    }

    public void setupData(Object dto) throws Exception {
    }

    public void setupFunctionality() throws Exception {
    }

    @FXML
    void login(MouseEvent event) throws IOException, InterruptedException, SQLException {
        try {
            getBController().login(email.getText(), password.getText());
            PopupScreen.showSuccessPopup("Login Successfully!");
            backToHomeScreen(event);
        } catch (Exception ex) {
            PopupScreen.showErrorPopup(ex.getMessage());
        }
    }

    @FXML
    void backToHomeScreen(MouseEvent event) throws IOException, InterruptedException, SQLException {
        this.homeScreenHandler.show();
    }
}
