package com.example.worddictionary;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DictPage {
    public AnchorPane root;
    DictPage() throws IOException {
        root= FXMLLoader.load(getClass().getResource("dict.fxml"));
    }
}
