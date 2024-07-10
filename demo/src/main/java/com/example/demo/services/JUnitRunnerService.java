package com.example.demo.services;
import com.example.demo.Controllers.CompileAndRunTests;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

@Service
public class JUnitRunnerService {

    public String processAndExecute(String javaCode) throws IOException, InterruptedException {
        String currentWorkingDirectory = System.getProperty("user.dir");
        String saveLocation=currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit".replace("\\","/");
        String className = extractClassName(javaCode); // Extract class name from Java code
        String fileName = saveLocation + File.separator + className + ".java"; // Construct file name with class name

        String processedCode = removePackageStatement(javaCode);

        saveJavaClass(processedCode, fileName);

        // Execute shell commands (compile and run tests)
        String result=executeShellCommands(className);
        deleteFile(saveLocation + File.separator + className + ".java");
        deleteFile(saveLocation + File.separator + className + ".class");
        return result;
    }

















// code for mutations
    public String processAndExecuteMutations(String javaCode,String twoPlayer,String threePlayer) throws IOException, InterruptedException {
        String processedCode="";
        String currentWorkingDirectory = System.getProperty("user.dir");
        String saveLocation=currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit".replace("\\","/");
        String className = extractClassName(javaCode); // Extract class name from Java code
        String fileName = saveLocation + File.separator + className + ".java"; // Construct file name with class name
        if(className.contains("UnitTests")){
            processedCode = removePackageStatement(javaCode).replaceAll("niThreePlayerGame",threePlayer);
            processedCode = removePackageStatement(processedCode).replaceAll("niTwoPlayerGame",twoPlayer);


        }
        else {
            processedCode = removePackageStatement(javaCode).replaceAll("ThreePlayerGame", threePlayer);
            processedCode = removePackageStatement(processedCode).replaceAll("TwoPlayerGame", twoPlayer);

        }
        System.out.println(processedCode);
        saveJavaClass(processedCode, fileName);

        // Execute shell commands (compile and run tests)
        String result=executeShellCommandsForMutations(className,twoPlayer, threePlayer);
        deleteFile(saveLocation + File.separator + className + ".java");
        deleteFile(saveLocation + File.separator + className + ".class");
        return result;
    }


//code for executing unit test
    public String processAndExecuteUnitTest(String javaCode,String twoPlayer,String threePlayer) throws IOException, InterruptedException {

        String currentWorkingDirectory = System.getProperty("user.dir");
        String saveLocation=currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit".replace("\\","/");
        String className = extractClassName(javaCode); // Extract class name from Java code
        String fileName = saveLocation + File.separator + className + ".java"; // Construct file name with class name
        String processedCode = removePackageStatement(javaCode);
        System.out.println(processedCode);
        saveJavaClass(processedCode, fileName);

        // Execute shell commands (compile and run tests)
        String result=executeShellCommandsForMutations(className,twoPlayer, threePlayer);
        deleteFile(saveLocation + File.separator + className + ".java");
        deleteFile(saveLocation + File.separator + className + ".class");
        return result;
    }













private void deleteFile(String filePath){

    // Create a File object representing the file to be deleted
    File fileToDelete = new File(filePath);

    // Check if the file exists
    if (fileToDelete.exists()) {
        // Attempt to delete the file
        if (fileToDelete.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.err.println("Failed to delete the file.");
        }
    } else {
        System.err.println("File does not exist.");
    }
}
    public String extractClassName(String javaCode) {
        // Extract class name from Java code
        String className = "DynamicTest"; // Default if not found
        String[] lines = javaCode.split("\n");
        for (String line : lines) {
            if (line.trim().startsWith("public class")) {
                className = line.trim().substring("public class".length()).trim().split(" ")[0].replace("{","");
                break;
            }
        }
        return className;
    }

    private String removePackageStatement(String javaCode) {
        // Remove package statement
        javaCode="package com.example.demo.junit;\n"+javaCode.replaceAll("(?m)^.*package.*$", "").replaceAll("(?m)^[ \t]*\r?\n", "");
        //javaCode=javaCode.replace("package SUT.tests;","");
        javaCode=javaCode.replaceAll("import niSUT.niThreePlayerGame;","");
        javaCode=javaCode.replaceAll("import niSUT.niTwoPlayerGame;","");
        javaCode=javaCode.replaceAll("import SUT.TwoPlayerGame;;","");
        return javaCode.replaceAll("import SUT.ThreePlayerGame;","");
    }

    private void saveJavaClass(String javaCode, String fileName) {
        // Save processed code to a file
        FileWriter fileWriter = null;
        try {
            File file = new File(fileName);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs(); // Create parent directories if they don't exist
            }
            fileWriter = new FileWriter(file);
            fileWriter.write(javaCode);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception properly
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String executeShellCommands(String className) throws IOException, InterruptedException {

        CompileAndRunTests c=new CompileAndRunTests();
        String res=c.compileJavaFiles(className);
        if(!res.equals("")){
            return res;
        }
        return c.runJUnitTests(className);
    }

    private String executeShellCommandsForMutations(String className,String twoPlayer,String threePlayer) throws IOException, InterruptedException {

        CompileAndRunTests c=new CompileAndRunTests();

        String res = c.compileJavaFiles(className,twoPlayer,threePlayer);
        if(!res.equals("")){
            return res;
        }
        return c.runJUnitTests(className);
    }
}