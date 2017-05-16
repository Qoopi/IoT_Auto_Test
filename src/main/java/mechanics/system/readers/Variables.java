package mechanics.system.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alex Storm on 16.05.2017.
 */
public class Variables {
    //read folder content
    //find all *.json
    //return list of paths to all *.json

    //read json file
    //check if json file contains stage which equals stage
    //if yes
    //if true
    private final String pathToFolder = "variables";




    @Test
    public void test(){
        findStageJson("dev");
    }


    public HashMap<String, String> findStageJson(String stage){
        boolean found = false;
        HashMap<String, String> json = null;
        ArrayList<String> files = readFolderContent(pathToFolder);
        for (int i = 0; i < files.size(); i++){
            json = simpleJsonFileToMap(files.get(i));
            if (json != null && json.get("stage") != null && json.get("stage").equals(stage)) {
                found = true;
                System.out.println("Found suitable .json file for specified stage '"+stage+"' in folder '"+pathToFolder+"'");
//                printMap(json);
                return json;
            }
            else{
                json = null;
            }
        }
        if (!found){
            System.out.println("ERR: Can't find suitable .json file for specified stage '"+stage+"' in folder '"+pathToFolder+"'");
        }
        return json;
    }


    private void printMap(HashMap<String, String> map){
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

    private ArrayList<String> readFolderContent(String folderPath){
        ArrayList<String> files = new ArrayList<>();
        File curDir = new File(folderPath);
        File[] filesList = curDir.listFiles();
        assert filesList != null;
        for(File f : filesList){
            if(f.isFile() && f.getName().contains(".json")){
                files.add(f.getAbsolutePath());
//                System.out.println(f.getAbsolutePath());
            }
        }
        return files;
    }

    private HashMap<String, String> simpleJsonFileToMap(String filePath){
        HashMap<String, String> result = null;
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            result = new ObjectMapper().readValue(stream, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



}
