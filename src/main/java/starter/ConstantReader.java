package starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstantReader {

    private static ConstantReader instance;
    private Map<String,String> properties;

    private ConstantReader(){
        properties = new HashMap<String,String>();
    }

    public void readFile(){
        try {
            File text = new File("src/test/resources/env-properties.properties");

            //Creating Scanner instance to read File in Java
            Scanner scnr = new Scanner(text);

            //Reading each line of the file using Scanner class
            int lineNumber = 1;
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                propertiesHandler(line);

                //System.out.println("line " + lineNumber + " :" + decodedString);

            }
            scnr.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    private void propertiesHandler(String line){
        String key = line.substring(0,line.indexOf("="));
        String val = line.substring(line.indexOf("=")+1);
        byte[] decodedBytes = Base64.getUrlDecoder().decode(val);
        val = new String(decodedBytes);
        properties.put(key, val);
    }

    public synchronized static ConstantReader getInstance(){
        if(instance == null){
            instance = new ConstantReader();
        }
        return instance;
    }

    public Map<String,String> getProperties() {
        return properties;
    }
}
