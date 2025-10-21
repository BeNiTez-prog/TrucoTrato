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

        // 1. Pre-calculate the final angle and the result
        Random random = new Random();
        int finalAngle = random.nextInt(360);
        String resultado;

        // 2. Determine result based on the angle (0-179 is TRUCO, 180-359 is TRATO)
        if (finalAngle < 180) {
            resultado = "TRUCO";
        } else {
            resultado = "TRATO";
        }

        // 3. Calculate total rotation to land on that angle
        int fullSpins = 5;
        double totalRotation = (360 * fullSpins) + finalAngle;

        // 4. Set up and play the animation
        RotateTransition rt = new RotateTransition(Duration.seconds(3), ruletaImage);
        rt.setByAngle(totalRotation);
        rt.setOnFinished(event -> {
            // 5. Show the pre-calculated result and re-enable the button
            resultadoLabel.setText(resultado);
            girarButton.setDisable(false);
        });
        rt.play();
    }
}
