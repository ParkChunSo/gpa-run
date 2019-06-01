package com.chun.gr.java.controller;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class EventController {
    private ArrayList<ImageView> list;
    private ImageView gauge;

    public EventController(ArrayList<ImageView> list, ImageView gauge) {
        this.list = list;
        this.gauge = gauge;
    }

    public void setMap() {
        for (ImageView img :
                list) {

        }
    }
}
