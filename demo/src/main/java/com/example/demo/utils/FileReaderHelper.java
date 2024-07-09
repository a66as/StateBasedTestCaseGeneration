package com.example.demo.utils;

import com.example.demo.POJOs.LocationsPOJO;
import statemachinereader.StateMachineReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileReaderHelper {


    public String getClassCode(String task) throws IOException {
        String code="";
        Map<String, LocationsPOJO> locations=new LocationsPOJO().getLocations();
        try{
            code = Files.readString(Paths.get(locations.get(task).getUserSavedFileLoc()));

        }
        catch (Exception e){
            code = Files.readString(Paths.get(locations.get(task).getPrimaryFileLoc()));

        }

        return code;
    }
}
