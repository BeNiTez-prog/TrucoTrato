package org.trucotrato.trucotrato;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class ruletaTrucoTrato {

    @FXML
    private Label nombreLabel;

    @FXML
    private Label cursoLabel;

    @FXML
    private ImageView ruletaImage;

    @FXML
    private Button girarButton;

    @FXML
    private Label resultadoLabel;

    private String nombre;
    private String curso;

    public void setDatos(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
        nombreLabel.setText(nombre);
        cursoLabel.setText(curso);
    }

    @FXML
    private void girar() {
        girarButton.setDisable(true);
        resultadoLabel.setText("");

        ruletaImage.setRotate(0);

        RotateTransition rt = new RotateTransition(Duration.seconds(3), ruletaImage);
        rt.setByAngle(360 * 5 + new Random().nextInt(360));
        rt.setOnFinished(event -> {
            String resultado;
            if (new Random().nextBoolean()) {
                resultado = "TRUCO";
            } else {
                resultado = "TRATO";
            }
            resultadoLabel.setText(resultado);
            girarButton.setDisable(false);
        });
        rt.play();
    }
}
