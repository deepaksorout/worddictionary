package com.example.worddictionary;

import java.io.*;
import java.util.HashMap;

public class dictionarySaver {
    private HashMap<String,String> dList;
    dictionarySaver(){
        dList=new HashMap<>();
    }
    HashMap<String,String> getdList(){
        return dList;
    }
    void serialization() throws IOException{
        FileOutputStream fos=new FileOutputStream("dictionaryData");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(dList);
        oos.close();
        fos.close();
    }
    void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream file=new FileInputStream("dictionaryData");
        ObjectInputStream ois=new ObjectInputStream(file);
        dList= (HashMap<String, String>) ois.readObject();

        file.close();
        ois.close();
    }
}
