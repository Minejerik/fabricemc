package minejerik.fabricemc;

import java.util.Dictionary;
import java.util.Hashtable;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class fabricemcconfig {
    private String file_name;
    public Dictionary<String, String> config= new Hashtable<>();

    public fabricemcconfig(String file){
        file_name = "config/"+file+".properties";
    }

    public void load_config(){

    }
}
