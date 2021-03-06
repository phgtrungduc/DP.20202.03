package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Logger;

import controller.BaseController;
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
	private BaseController baseController;

	/**
	 * Duplication of code : giải quyết bằng template method
	 * Template Method
	 * Hau het cac sub class deu su dung hai ham setupData va setupFunctionality
	 * nhung voi cac subclass khac nhau lai su dung chung 1 cach khac nhau
	 * */
	protected abstract void setupData  (Object dto) throws Exception;
	protected abstract  void setupFunctionality () throws Exception;
	protected BaseScreenHandler(Stage stage, String screenPath,Object dto) throws IOException {
		super(screenPath);
		this.stage = stage;
		try {
			setupData(dto);
			setupFunctionality();
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

	public void setBaseController(BaseController baseController){
		this.baseController = baseController;
	}

	public BaseController getBaseController(){
		return this.baseController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

}
