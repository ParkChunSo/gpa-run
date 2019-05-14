package com.chun.gr.java.util;

import com.chun.gr.java.model.enums.ImageNm;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ImageUtils {
    public static String IMAGE_PATH = "../../res/img/";

    public static Background setBackgroundImage(ImageNm imageNm){
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
}
