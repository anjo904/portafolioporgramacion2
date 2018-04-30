package sample;


import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

public class topscore {


    @FXML
    Button atras2;

    @FXML
    TextField textfield;

    public void regresar(ActionEvent actionEvent) {
        //para cambio de pantalla

        Stage stage = (Stage) atras2.getScene().getWindow();
        //para seleccionar a donde ir (en este caso a menu)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Aplicación");
            alerta.setContentText("Llame a Soporte.");
            alerta.showAndWait();
            Platform.exit();
        }
        FadeTransition ft = new FadeTransition(Duration.millis(1500), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ver2(ActionEvent actionEvent) {

        File archivo = new File("bestscore.txt");
        String ultimalinea = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            ultimalinea = "";
            while ((linea = br.readLine()) != null) {
                ultimalinea = linea;
            }
            System.out.println(ultimalinea);
        } catch (FileNotFoundException e) {
            System.out.println("Problema con el archivo!");
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo!");
        }
        //para que se vean el resultado de ultimalinea a textSet
        textfield.setText(ultimalinea);
    }

}
