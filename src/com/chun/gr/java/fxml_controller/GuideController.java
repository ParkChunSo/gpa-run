package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.model.enums.FxmlNm;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GuideController implements Initializable {
    @FXML
    private StackPane guidePane;
    @FXML
    private GuideChildrenController1 children1Controller;
    @FXML
    private GuideChildrenController2 children2Controller;
    @FXML
    private GuideChildrenController3 children3Controller;
    @FXML
    private GuideChildrenController4 children4Controller;
    @FXML
    private GuideChildrenController5 children5Controller;
    @FXML
    private GuideChildrenController6 children6Controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        guidePane.setBackground(ResourceUtil.getBackgroundImage(ImageNm.Background_image));

        children1Controller.setParentController(this);
        children2Controller.setParentController(this);
        children3Controller.setParentController(this);
        children4Controller.setParentController(this);
        children5Controller.setParentController(this);
        children6Controller.setParentController(this);

        children1Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> changeOtherChildren(2)));
        children2Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> changeOtherChildren(3)));
        children3Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> changeOtherChildren(4)));
        children4Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> changeOtherChildren(5)));
        children5Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> changeOtherChildren(6)));
        children6Controller.toggleProperty().addListener(((observable, oldValue, newValue) -> ResourceUtil.changePage((StackPane) guidePane.getScene().getRoot(), this.guidePane, FxmlNm.game)));
    }

    private void changeOtherChildren(int num){
        StringBuilder sb = new StringBuilder("children");
        sb.append(num);
        guidePane.getChildren().forEach(node -> {
            if (node.getId().equals(sb.toString()))
                node.setVisible(true);
            else
                node.setVisible(false);
        });
    }
}
