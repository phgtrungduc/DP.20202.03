package views.screen.home;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import common.function.CommonFunctionCurrency;
import common.function.CommonFunctionDate;
import common.interfaces.Observable;
import common.interfaces.Observer;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.FXMLScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupDetailMedia;
//Doi ten tu MediaHandler thanh HomeMediaHandler de ro nghia class dung trong package home

public class HomeMediaHandler extends FXMLScreenHandler implements Observable {

    @FXML
    protected ImageView mediaImage;

    @FXML
    protected Label mediaTitle;

    @FXML
    protected Label mediaPrice;

    @FXML
    protected Label mediaAvail;

    @FXML
    protected Spinner<Integer> spinnerChangeNumber;

    @FXML
    protected Button addToCartBtn;

    @FXML
    protected Button viewDetailBtn;

    private static Logger LOGGER = Utils.getLogger(HomeMediaHandler.class.getName());
    private Media media;
    private List<Observer> observerList;

    public HomeMediaHandler(String screenPath, Media media) throws SQLException, IOException{
        super(screenPath);
        this.media = media;
        this.observerList = new ArrayList<>();
        addToCartBtn.setOnMouseClicked(event -> {
            notifyObservers();
        });
        viewDetailBtn.setOnMouseClicked((event -> {
            try {
                PopupDetailMedia popup = new PopupDetailMedia(new Stage(),ViewsConfig.POPUP_DETAIL_MEDIA,this.media);
                popup.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }));
        setMediaInfo();

    }

    Media getMedia(){
        return media;
    }
    int getRequestQuantity() {
        return spinnerChangeNumber.getValue();
    }

    private void setMediaInfo() throws SQLException {
        // set the cover image of media
        File file = new File(media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(160);
        mediaImage.setFitWidth(152);
        mediaImage.setImage(image);
        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(CommonFunctionCurrency.getCurrencyFormat(media.getPrice()));
        mediaAvail.setText(Integer.toString(media.getQuantity()));
        spinnerChangeNumber.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1)
        );

        setImage(mediaImage, media.getImageURL());
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }
}
