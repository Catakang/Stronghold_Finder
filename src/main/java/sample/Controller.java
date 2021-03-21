package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    MediaView ani;
    @FXML
    Button buttom;
    String pathh;
    URL media1;
    Media media;
    private MediaPlayer play2;

    public void calculate(){
        buttom.setText("BEUH");
        play2.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pathh = "die.mp4";
        media1 = getClass().getResource(pathh);
        File file = new File(pathh);
        media = new Media(file.toString());
        play2 = new MediaPlayer(media);
        ani.setMediaPlayer(play2);
    }
}
