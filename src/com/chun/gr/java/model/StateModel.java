package com.chun.gr.java.model;

import com.chun.gr.java.model.enums.State;

public class StateModel {
    private String id;
    private String name;
    private int stage;
    private int hitPoint;
    private int score;
    private State state;

    public StateModel(){
    }

    public StateModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public State isFever() {
        return state;
    }

    public void setFever(State fever) {
        state = fever;
    }
}
