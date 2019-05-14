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
                        new Image(ImageUtils.class.getResource(sb.toString()).toString())
                        , BackgroundRepeat.NO_REPEAT
                        , BackgroundRepeat.NO_REPEAT
                        , BackgroundPosition.CENTER
                        , new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true)
                )
        );
    }

    public static Parent getParent(FxmlNm fxmlNm) throws IOException {
        StringBuilder sb = new StringBuilder(FXML_PATH);
        sb.append(fxmlNm.name());
        sb.append(".fxml");
        return FXMLLoader.load(Objects.requireNonNull(ResourceUtil.class.getResource(sb.toString())));
    }
}
