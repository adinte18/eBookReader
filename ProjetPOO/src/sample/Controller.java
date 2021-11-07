package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import javafx.event.ActionEvent;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea txt;

    @FXML
    private Button add_button;

    @FXML
    private ToggleButton font_button;

    @FXML
    private ToggleButton font_button1;

    @FXML
    private ListView<String> list_view;

    @FXML
    private ComboBox<String> selectFont;


    public String readFile(String filepath) throws IOException {
        String data = "";

        data = new String(Files.readAllBytes(Paths.get(filepath)));

        return data;
    }

    public void writeToTextArea(File file) throws IOException {
        String SOURCE_FILE = file.getAbsolutePath();

        if (file != null)
        {
            // print chosen file
            list_view.getItems().add(file.getName());

            String text = readFile(SOURCE_FILE);

            txt.setText(text);
        }
        else
        {
            System.out.print("Not valid file");
        }
    }

    public void ButtonAction(ActionEvent event) throws IOException {

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        writeToTextArea(selectedFile);
    }

    public void changeFont(ActionEvent event)
    {
        txt.getText();

        txt.setFont(new Font(selectFont.getValue(), 14));
    }

    public void FontChange(ActionEvent event)
    {
        if (txt.getText().isEmpty())
        {
            System.out.println("No text");
            ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFontNames());
            System.out.println(fonts.toString());
        }
        else
        {
            if (font_button1.isSelected() && font_button.isSelected())
            {
                txt.setStyle("-fx-font-weight: bold; -fx-font-style: italic");
                txt.setFont(new Font(selectFont.getValue(), 14));
            }
            else if (font_button1.isSelected() && !font_button.isSelected())
            {
                txt.setStyle("-fx-font-style: italic");
                txt.setFont(new Font(selectFont.getValue(), 14));
            }
            else if(font_button.isSelected() && !font_button1.isSelected())
            {
                txt.setStyle("-fx-font-weight: bold");
                txt.setFont(new Font(selectFont.getValue(), 14));
            }
            else txt.setStyle("-fx-font-weight: plain");
        }
    }

    ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFontNames());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectFont.setItems(fonts);
    }
}
