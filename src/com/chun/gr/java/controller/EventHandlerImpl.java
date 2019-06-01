package com.chun.gr.java.controller;

import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;

public class EventHandlerImpl implements EventHandler<ActionEvent> {
    private ImageView object;
    private ImageView character;
    private BooleanProperty strike;

    public EventHandlerImpl(ImageView object, ImageView character) {
        this.object = object;
        this.character = character;
    }

    @Override
    public void handle(ActionEvent event) {
        double objectMinX = object.getBoundsInParent().getMinX();
        double objectMaxY = object.getBoundsInParent().getMaxY();
        if (objectMinX > character.getBoundsInParent().getMinX()
                        && objectMinX < character.getBoundsInParent().getMaxX()
                        && objectMaxY < character.getBoundsInParent().getMaxY()
                        && objectMaxY > character.getBoundsInParent().getMinY()) {
            setStrike(!isStrike());
            object.setEffect(new Lighting());
        }

    }

    public boolean isStrike() {
        return strike.get();
    }

    public BooleanProperty strikeProperty() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike.set(strike);
    }
}
