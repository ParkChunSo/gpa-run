package com.chun.gr.java.controller;

import com.chun.gr.java.model.constants.GameConstant;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
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
        this.width = GameConstant.CHARACTER_IMAGE_SPRITE_WIDTH;
        this.height = GameConstant.CHARACTER_IMAGE_SPRITE_HEIGHT;

        this.characterImageView.setFitWidth(GameConstant.CHARACTER_RUN_IMAGE_WIDTH);
        this.characterImageView.setFitHeight(GameConstant.CHARACTER_RUN_IMAGE_HEIGHT);
        this.characterImageView.relocate(GameConstant.CHARACTER_IMAGEVIEW_X, GameConstant.CHARACTER_IMAGEVIEW_Y);
        this.characterImageView.setImage(ResourceUtil.getImage(ImageNm.Character_Run_Image));
        this.characterImageView.setViewport(new Rectangle2D(0,0, GameConstant.CHARACTER_IMAGE_SPRITE_WIDTH, GameConstant.CHARACTER_IMAGE_SPRITE_HEIGHT));

        super.setCycleDuration(Duration.millis(350));
        super.setInterpolator(Interpolator.LINEAR);
        this.setCycleCount(Animation.INDEFINITE);
    }

    public void setSlideMotion(){

    }

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
