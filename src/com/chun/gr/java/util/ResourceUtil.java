package com.chun.gr.java.util;

import com.chun.gr.java.model.enums.BgmNm;
import com.chun.gr.java.model.enums.FxmlNm;
import com.chun.gr.java.model.enums.ImageNm;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.util.Objects;

public class ResourceUtil {
    private static String IMAGE_PATH = "../../res/img/";
    private static String FXML_PATH = "../../res/fxml/";
    private static String BGM_PATH = "../../res/bgm/";

    public static Background getBackgroundImage(ImageNm imageNm){
        StringBuilder sb = new StringBuilder(IMAGE_PATH);
        sb.append(imageNm.name());
        sb.append(".png");
        return new Background(
                new BackgroundImage(
                        new Image(ResourceUtil.class.getResource(sb.toString()).toString())
                        , BackgroundRepeat.NO_REPEAT
                        , BackgroundRepeat.NO_REPEAT
                        , BackgroundPosition.CENTER
                        , new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true)
                )
        );
    }

    public static Image getImage(ImageNm imageNm){
        StringBuilder sb = new StringBuilder(IMAGE_PATH);
        sb.append(imageNm.name());
        sb.append(".png");
        return new Image(ResourceUtil.class.getResource(sb.toString()).toString());
    }

    public static void changePage(StackPane root,StackPane prePane, FxmlNm fxmlNm){
        StringBuilder sb = new StringBuilder(FXML_PATH);
        sb.append(fxmlNm.name());
        sb.append(".fxml");

        try {
            root.getChildren().clear();
            root.getChildren().remove(prePane);
            root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(ResourceUtil.class.getResource(sb.toString()))));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static MediaPlayer getBackgroundMusic(BgmNm bgm){
        StringBuilder sb = new StringBuilder(BGM_PATH);
        sb.append(bgm); sb.append(".mp3");
        return new MediaPlayer(new Media(ResourceUtil.class.getResource(sb.toString()).toString()));
    }

}
