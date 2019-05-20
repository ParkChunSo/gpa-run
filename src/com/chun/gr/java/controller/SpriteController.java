package com.chun.gr.java.controller;

import com.chun.gr.java.model.constants.GameConstant;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteController extends Transition {
    private int count;
    private int columns;
    private int offsetX;
    private int offsetY;
    private int width;
    private int height;
    private int lastIndex;
    private ImageView characterImageView;

    public SpriteController(ImageView characterImageView) {
        this.characterImageView = characterImageView;
        this.count = 6;
        this.columns = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = GameConstant.CHARACTER_RUN_IMAGE_WIDTH;
        this.height = GameConstant.CHARACTER_RUN_IMAGE_HEIGHT;

        super.setCycleDuration(Duration.INDEFINITE);
        super.setInterpolator(Interpolator.LINEAR);
    }

//    public Animation getRunAnimation(){
//        characterImageView.setViewport(new Rectangle2D(0,0
//                , GameConstant.CHARACTER_RUN_IMAGE_WIDTH, GameConstant.CHARACTER_RUN_IMAGE_HEIGHT));
//
//    }

    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int) Math.floor(frac * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % columns) * width + offsetX;
            final int y = (index / columns) * height + offsetY;
            characterImageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }
}
