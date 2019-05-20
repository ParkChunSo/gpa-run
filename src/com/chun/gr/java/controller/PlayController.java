package com.chun.gr.java.controller;

import com.chun.gr.java.model.constants.GameConstant;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PlayController {
    public void playBackgroundThread(DoubleProperty BG1Property, DoubleProperty BG2Property, DoubleProperty BGF1Property, DoubleProperty BGF2Property) {
        Timeline backgroundAnimationThread1 = new Timeline(
                new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_SPEED), new KeyValue(BG1Property, -800))
                , new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_SPEED), new KeyValue(BG2Property, -800))
        );
        backgroundAnimationThread1.setCycleCount(Timeline.INDEFINITE);
        backgroundAnimationThread1.play();

        Timeline backgroundAnimationThread2 = new Timeline(
                new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_FRONT_SPEED), new KeyValue(BGF1Property, -800))
                , new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_FRONT_SPEED), new KeyValue(BGF2Property, -800))

        );
        backgroundAnimationThread2.setCycleCount(Timeline.INDEFINITE);
        backgroundAnimationThread2.play();
    }

    public Animation getCharacterAnimation(ImageView characterImageView){
        characterImageView.setViewport(new Rectangle2D(0,0, GameConstant.CHARACTER_RUN_IMAGE_WIDTH, GameConstant.CHARACTER_RUN_IMAGE_HEIGHT));

    }
}
