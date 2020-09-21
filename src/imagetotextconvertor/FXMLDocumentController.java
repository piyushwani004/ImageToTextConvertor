/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetotextconvertor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {

    FileChooser fileChooser = new FileChooser();

    @FXML
    private Button chooseimg;

    @FXML
    private Button convertimg;

    @FXML
    private Button choosPdf;

    @FXML
    private Button convertPdf;

    String path = "";

    @FXML
    private Text imgname;

    @FXML
    private Text pdfname;

    Dialog<String> dialog = new Dialog<String>();
    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dialog.setTitle("Dialog");

        //Setting the content of the dialog
        dialog.setContentText("File Created successfully");
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);

        chooseimg.setOnAction(a -> {
            File selectedFile = fileChooser.showOpenDialog(null);
            path = selectedFile.getPath();
            imgname.setText(path);

        });
        convertimg.setOnAction(a -> {
            ImgToText imgtotext = new ImgToText();
            try {
                imgtotext.ImgToTextConvert(path);
                dialog.showAndWait();
            } catch (IOException ex) {

            }
        });

        choosPdf.setOnAction(a -> {
            File selectedPdf = fileChooser.showOpenDialog(null);
            path = selectedPdf.getPath();
            pdfname.setText(path);
        });
        convertPdf.setOnAction((ActionEvent a) -> {
            ImgToPDF imgtopdf = new ImgToPDF();
            imgtopdf.imgToPdf(path);
            dialog.showAndWait();
        });
    }

}
