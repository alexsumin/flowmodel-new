package ru.alexsumin.flowmodel.controllers;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

@FXMLController
public class AuthorizationController {

    @FXML
    private ChoiceBox<String> userChoiceBox;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void initialize() {

        userChoiceBox.getItems().addAll(FXCollections.observableArrayList("Исследователь", "Администратор"));
        userChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldSelected, newSelected) -> {
                    if (newSelected.equals(0))
                        setElementsDisable(false);
                    else {
                        setElementsDisable(true);
                        passwordField.textProperty().addListener((obv, oldVal, newVal) ->
                                loginButton.setDisable(newVal.trim().isEmpty()));
                    }

                });
        userChoiceBox.setTooltip(new Tooltip("Выберите категорию пользователя"));
        userChoiceBox.setValue("Исследователь");

    }

    private void setElementsDisable(boolean disabled) {
        passwordLabel.setVisible(disabled);
        passwordField.setVisible(disabled);
        loginButton.setDisable(disabled);

    }


}
