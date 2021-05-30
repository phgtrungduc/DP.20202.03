package views.screen.popup;

import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.File;
import java.io.IOException;

public class PopupDetailMedia extends BaseScreenHandler {
    private Media media;
    @FXML
    protected ImageView mediaImage;

    @FXML
    protected Label mediaTitle;

    @FXML
    protected Label mediaPrice;

    @FXML
    protected Label mediaAvail;
    @FXML
    protected Label mediaCategory;
    @FXML
    protected Label mediaType;

    public PopupDetailMedia(Stage stage, String screenPath, Object dto) throws IOException {
        super(stage, screenPath, dto);
    }


    @Override
    public void setupData(Object dto) throws Exception {
        this.media = (Media)dto;
        File file = new File(media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(350);
        mediaImage.setFitWidth(250);
        mediaImage.setImage(image);
        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(ViewsConfig.getCurrencyFormat(media.getPrice()));
        mediaAvail.setText(Integer.toString(media.getQuantity()));
        mediaCategory.setText(media.getCategory());
        mediaType.setText(media.getType());
    }
    @Override
    public void setupFunctionality() throws Exception {

    }

    public void show(){
        super.show();
    }
}
