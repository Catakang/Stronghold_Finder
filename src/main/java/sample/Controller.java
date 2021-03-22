package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.net.URL;

public class Controller{
    @FXML
    TextField x1;
    @FXML
    TextField x2;
    @FXML
    TextField y1;
    @FXML
    TextField y2;
    @FXML
    TextField angle1;
    @FXML
    TextField angle2;
    @FXML
    TextField sxy;
    @FXML
    Button calculator;
    @FXML
    ImageView eye1, eye2, left1, left2, right1, right2, endportal;
    String path = "audio.mp3";
    final URL audio1 = getClass().getResource(path);
    Media audio = new Media(audio1.toString());
    MediaPlayer play1 = new MediaPlayer(audio);

    public Controller() {
    }

    public void calculate(ActionEvent e){
        play1.play();
          try {
            Double.isNaN(Double.parseDouble(x1.getText()));
            Double.isNaN(Double.parseDouble(y1.getText()));
            Double.isNaN(Double.parseDouble(x2.getText()));
            Double.isNaN(Double.parseDouble(y2.getText()));
            Double.isNaN(Double.parseDouble(angle1.getText()));
            Double.isNaN(Double.parseDouble(angle2.getText()));
        } catch (NumberFormatException a) {
            calculator.setDisable(false);
            sxy.setText("Invalid");
            play1.setMute(true);
        }
        double xInput = (Double.parseDouble(x1.getText()));
        double yInput = (Double.parseDouble(y1.getText()));
        double x2Input = (Double.parseDouble(x2.getText()));
        double y2Input = (Double.parseDouble(y2.getText()));
        double a1 = (Double.parseDouble(angle1.getText()));
        double a2 = (Double.parseDouble(angle2.getText()));
        double sy = ((yInput * Math.tan(-(a1 * (3.1416 / 180)))) - (y2Input * Math.tan(-(a2 * (3.1416 / 180)))) + x2Input - xInput) / ((Math.tan(-(a1 * (3.1416 / 180)))) - (Math.tan(-(a2 * (3.1416 / 180)))));
        double sx = ((sy - yInput) * Math.tan(-(a1 * (3.1416 / 180)))) + xInput;
        if (play1.getStatus() != MediaPlayer.Status.READY) {
            play1.seek(Duration.seconds(0.0));
        }
        play1.setStartTime(Duration.ZERO);
        Duration duration = play1.getTotalDuration();
        play1.setStopTime(duration);
        play1.setAutoPlay(true);
        eye1.setVisible(true);
        right1.setVisible(true);
        right2.setVisible(true);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(eye1);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(84);
        translate.setByY(-180);
        translate.play();
        translate.setOnFinished(a -> {
            eye2.setVisible(true);
            left1.setVisible(true);
            left2.setVisible(true);
            TranslateTransition translate1 = new TranslateTransition();
            translate1.setNode(eye2);
            translate1.setDuration(Duration.millis(1000));
            translate1.setByX(-110);
            translate1.setByY(-180);
            translate1.play();
            translate1.setOnFinished(b -> {
                endportal.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(endportal);
                fade.setDuration(Duration.millis(1));
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();
            });
        });
        Runnable reset = new Runnable() {
            @Override
            public void run() {
                eye1.setVisible(false);
                right1.setVisible(false);
                right2.setVisible(false);
                eye2.setVisible(false);
                left1.setVisible(false);
                left2.setVisible(false);
                TranslateTransition translate9 = new TranslateTransition();
                translate9.setNode(eye1);
                translate9.setDuration(Duration.millis(1));
                translate9.setByX(-84);
                translate9.setByY(180);
                translate9.play();
                TranslateTransition translate19 = new TranslateTransition();
                translate19.setNode(eye2);
                translate19.setDuration(Duration.millis(1));
                translate19.setByX(110);
                translate19.setByY(180);
                translate19.play();
                FadeTransition fade9 = new FadeTransition();
                fade9.setNode(endportal);
                fade9.setDuration(Duration.millis(1));
                fade9.setInterpolator(Interpolator.LINEAR);
                fade9.setFromValue(1);
                fade9.setToValue(0);
                fade9.play();
                play1.stop();
            }
        };
        play1.setOnEndOfMedia(reset);
        play1.setMute(false);
        sxy.setText(Math.round(sx * 100.0) / 100.0 + "," + Math.round(sy * 100.0) / 100.0);
        }
}


