package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import controller.AuthenticationController;
import controller.BaseController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.home.HomeScreenHandler;
import views.screen.popup.PopupScreen;

public abstract class BaseScreenHandler extends FXMLScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(BaseScreenHandler.class.getName());
	private Scene scene;
	private BaseScreenHandler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;

	public abstract void setupData(Object dto) throws Exception;
	public abstract void setupFunctionality() throws Exception;

	protected BaseScreenHandler(Stage stage, String screenPath, Object dto) throws IOException {
		super(screenPath);
		this.stage = stage;
		try {
			this.setupData(dto);
			this.setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.showErrorPopup("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.showErrorPopup(ex.getMessage());
		}
	}

	public void setPreviousScreen(BaseScreenHandler prev) {
		this.prev = prev;
	}

	public BaseScreenHandler getPreviousScreen() {
		return this.prev;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

}
