package ru.alexsumin.flowmodel.controllers;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alexsumin.flowmodel.services.AccountService;

@FXMLController
public class AuthorizationController {

    private final static int ADMIN_INDEX = 1;

    @FXML
    private ChoiceBox<String> userChoiceBox;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @Autowired
    private final AccountService accountService;

    public AuthorizationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @FXML
    private void initialize() {

        userChoiceBox.getItems().addAll(FXCollections.observableArrayList("Исследователь", "Администратор"));
        userChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, oldSelected, newSelected) -> {
                    if (!newSelected.equals(ADMIN_INDEX))
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

    @FXML
    private void login(final Event event) {
        if (userChoiceBox.getSelectionModel().isSelected(ADMIN_INDEX)) {
            if (accountService.checkAdminPassword(passwordField.getText())) {
                //todo: load dbeditor
                System.out.println("db editor");
            } else {
                //todo: alert
                System.out.println("ooups!");
            }
        } else {
            //todo: load calculationview
            System.out.println("calc view");
        }
    }

    private void setElementsDisable(boolean disabled) {
        passwordLabel.setVisible(disabled);
        passwordField.setVisible(disabled);
        loginButton.setDisable(disabled);
    }


}
