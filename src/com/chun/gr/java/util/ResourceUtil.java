package com.chun.gr.java.util;

import com.chun.gr.java.model.enums.FxmlNm;
import com.chun.gr.java.model.enums.ImageNm;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Objects;

public class ResourceUtil {
    public static String IMAGE_PATH = "../../res/img/";
    public static String FXML_PATH = "../../res/fxml/";

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

}
