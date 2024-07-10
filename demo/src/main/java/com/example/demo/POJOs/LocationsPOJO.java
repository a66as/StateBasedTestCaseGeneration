package com.example.demo.POJOs;

import java.util.HashMap;
import java.util.Map;

public class LocationsPOJO {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryFileLoc() {
        return primaryFileLoc;
    }

    public void setPrimaryFileLoc(String primaryFileLoc) {
        this.primaryFileLoc = primaryFileLoc;
    }

    public String getUserSavedFileLoc() {
        return userSavedFileLoc;
    }

    public void setUserSavedFileLoc(String userSavedFileLoc) {
        this.userSavedFileLoc = userSavedFileLoc;
    }

    String primaryFileLoc;
    String userSavedFileLoc;

    public LocationsPOJO(String name, String primaryFileLoc, String userSavedFileLoc) {
        this.name = name;
        this.primaryFileLoc = primaryFileLoc;
        this.userSavedFileLoc = userSavedFileLoc;
    }

    public  LocationsPOJO(){

    }
    public Map<String, LocationsPOJO> getLocations()
    {
        Map<String, LocationsPOJO> map = new HashMap<>();
            map.put("AllTransitionPaths",new LocationsPOJO("AllTransitionPaths","src/SUT/Tests/AllTransitionsTestSuite.java".replace("\\","/"),"src/SUT/Tests/user_AllTransitionsTestSuite.java".replace("\\","/")));
            map.put("sneakPath",new LocationsPOJO("sneakPath","src/SUT/Tests/SneakPathTestSuit.java".replace("\\","/"),"src/SUT/Tests/user_SneakPathTestSuit.java".replace("\\","/")));
            map.put("UnitTests",new LocationsPOJO("UnitTests","src/niSUT/tests/UnitTests.java".replace("\\","/"),"src/niSUT/tests/user_UnitTests.java".replace("\\","/")));
        return map;
    }


}
