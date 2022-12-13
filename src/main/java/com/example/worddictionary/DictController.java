package com.example.worddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictController {
    private dictionarySaver db;
    @FXML
    TextField Search;
    @FXML
    public void SearchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new dictionarySaver();
       // db.serialization();
        db.deserialization();
        db.getdList();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Ditionary");

        if(Search.getText().equals("")){
            alert.setContentText("Please enter a word");
            alert.showAndWait();
            return;
        }
      if(db.getdList().containsKey(Search.getText().toLowerCase())){
          alert.setContentText("Word is avaible in the dictionary");
          alert.showAndWait();
      }
      else{
          alert.setContentText("Word is not present in the dictionary");
          alert.showAndWait();
      }
    }
    @FXML
    TextField Add;
    @FXML
    TextField meaning;
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new dictionarySaver();
        db.deserialization();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Ditionary");
        if(Add.getText().equals("") || meaning.getText().equals("")){
            alert.setContentText("Please enter word/Meaning");
            alert.showAndWait();
        }
        else {
            if(db.getdList().containsKey(Add.getText().toLowerCase())){
                alert.setContentText("This word is already present Please enter a new word");
                alert.showAndWait();
                return;
            }
            db.getdList().put(Add.getText().toLowerCase(), meaning.getText());
            db.serialization();

            alert.setContentText("Word is added");
            alert.showAndWait();
        }
    }
    @FXML
    TextField Find;
    @FXML
    public void Find(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new dictionarySaver();
        db.deserialization();
        db.getdList();

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");
        if(Find.getText().equals("")){
            alert.setContentText("Please enter a word");;
            alert.showAndWait();
            return;
        }
        if(db.getdList().containsKey(Find.getText())){
            alert.setContentText(db.getdList().get(Find.getText().toLowerCase()));
            alert.showAndWait();
        }
        else{
            alert.setContentText("Word is not available in the dictionary");
            alert.showAndWait();
        }
    }

    public void Remove(MouseEvent event) throws IOException {
        db=new dictionarySaver();
        db.serialization();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        alert.setContentText("All Data is Removed");
        alert.showAndWait();
    }
}
