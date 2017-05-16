package mechanics.system.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mechanics.system.constant.AssembledUrls;
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
    private HashMap<String, String> json = null;


    @Test
    public void test(){
        findAndAssembleStage("dev");
    }

    public void findAndAssembleStage(String stage){
        findStageJson(stage);
        assembleUrls();
    }

    private void assembleUrls(){
        AssembledUrls assembledUrls = new AssembledUrls();
        assembledUrls.setApiUrl(json.get("API_URL"));
        assembledUrls.setApiUrlMin(json.get("API_URL_MIN"));
        assembledUrls.setIotEndpoint(json.get("iotEndpoint"));
        assembledUrls.setRedirectClientURI(json.get("redirectClientURI"));
        assembledUrls.assemble();
    }


    private boolean findStageJson(String stage){
        boolean found = false;
        ArrayList<String> files = readFolderContent(pathToFolder);
        for (int i = 0; i < files.size(); i++){
            json = simpleJsonFileToMap(files.get(i));
            if (json != null && json.get("stage") != null && json.get("stage").equals(stage)) {
                found = true;
                System.out.println("Found suitable .json file for specified stage '"+stage+"' in folder '"+pathToFolder+"'");
                return found;
            }
            else{
                json = null;
            }
        }
        if (!found || json==null){
            System.out.println("ERR: Can't find suitable .json file for specified stage '"+stage+"' in folder '"+pathToFolder+"'");
        }
        return found;
    }


    private void printMap(HashMap<String, String> map){
        assert map!=null;
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
