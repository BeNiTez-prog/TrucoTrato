package org.trucotrato.trucotrato;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class entradaTunel {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private ComboBox<String> cursoComboBox;

    @FXML
    private void initialize() {
        cursoComboBox.getItems().addAll("DAM1", "DAM2", "DAW1", "DAW2", "SMR1", "SMR2");
    }

    @FXML
    private void entrar() throws IOException {
        if (nombreField.getText().isEmpty() || apellidosField.getText().isEmpty() || cursoComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Todos los campos son obligatorios.");
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ruleta.fxml"));
            Parent root = loader.load();

            ruletaTrucoTrato controller = loader.getController();
            controller.setDatos(nombreField.getText() + " " + apellidosField.getText(), cursoComboBox.getValue());

            Stage stage = (Stage) nombreField.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("halloween.css").toExternalForm());
            stage.setScene(scene);
        }
    }
}
