package com.example.demo.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompileAndRunTests {



    public String compileJavaFiles(String className) throws IOException, InterruptedException {
        String currentWorkingDirectory = System.getProperty("user.dir");
        String classpath = currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\junit-4.13.2.jar".replace("\\","/") +
                ":"+currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\hamcrest-core-1.3.jar".replace("\\","/");
        String classLoc=currentWorkingDirectory+("\\src\\main\\java\\com\\example\\demo\\junit\\"+className+".java").replace("\\","/");
        ProcessBuilder pb = new ProcessBuilder(
                "//usr/local/openjdk-11/bin/javac",
                "-d", ".",
                "-cp", classpath,
                currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\TwoPlayerGame.java".replace("\\","/"),
                currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\ThreePlayerGame.java".replace("\\","/"),classLoc

        );

        System.out.println("javac"+ "-d "+ " ."+" -cp "+ classpath+" "+currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\TwoPlayerGame.java".replace("\\","/")+ " "+ currentWorkingDirectory+"\\src\\main\\java\\com\\example\\demo\\junit\\ThreePlayerGame.java".replace("\\","/")+" "+classLoc
        );

        pb.redirectErrorStream(true);
        pb.directory(new File(currentWorkingDirectory+"\\src\\main\\java".replace("\\","/")));
        Process process = pb.start();
        String output="";
        // Print the output and errors
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output+=line;
            }

        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Compilation failed with exit code " + exitCode);
            return "Compilation Error \n"+output;
        }
        return "";
    }










    public String compileJavaFiles(String className,String twoPlayer,String threePlayer) throws IOException, InterruptedException {
        String currentWorkingDirectory = System.getProperty("user.dir");
        String classpath = currentWorkingDirectory+"/src/main/java/com/example/demo/junit/junit-4.13.2.jar" +
                ":"+currentWorkingDirectory+"/src/main/java/com/example/demo/junit/hamcrest-core-1.3.jar";
        String classLoc=currentWorkingDirectory+"/src/main/java/com/example/demo/junit/"+className+".java";
        ProcessBuilder pb = new ProcessBuilder(
                "/usr/local/openjdk-11/bin/javac",
                "-d", ".",
                "-cp", classpath,
                currentWorkingDirectory+"/src/main/java/com/example/demo/junit/TwoPlayerGame.java".replace("TwoPlayerGame",twoPlayer),
                currentWorkingDirectory+"/src/main/java/com/example/demo/junit/ThreePlayerGame.java".replace("ThreePlayerGame",threePlayer),classLoc

        );
        pb.redirectErrorStream(true);
        pb.directory(new File(currentWorkingDirectory+"/src/main/java"));
        Process process = pb.start();
        String res="";
        // Print the output and errors
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                res+=line;
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Compilation failed with exit code " + exitCode);
            return "Compilation Error "+res+"\n";
        }
    return "";
    }













    public String runJUnitTests(String className) throws IOException, InterruptedException {
       String res="";
        String classpath = ".:/app/src/main/java/com/example/demo/junit/junit-4.13.2.jar:/app/src/main/java/com/example/demo/junit/hamcrest-core-1.3.jar";

//        String classpath = ".;com\\example\\demo\\junit\\junit-4.13.2.jar" +
 //               ";com\\example\\demo\\junit\\hamcrest-core-1.3.jar";
        className="com.example.demo.junit."+className;
        ProcessBuilder pb = new ProcessBuilder(
                "/usr/local/openjdk-11/bin/java",
                "-cp", classpath,
                "org.junit.runner.JUnitCore",
                className
        );
        String currentWorkingDirectory = System.getProperty("user.dir");
        System.out.println("compiled now running the code ");
        pb.redirectErrorStream(true);
        pb.directory(new File(currentWorkingDirectory +"/src/main/java"));
        Process process = pb.start();
        // Print the output and errors
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            boolean testStarted = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                res+=line+"\n";
                if (line.startsWith("Time:") || line.startsWith("OK") || line.startsWith("Failures:") || line.startsWith("Errors:")) {
                    testStarted = true;
                }
            }

            // Check if the tests were executed (by checking the first line of output)
            if (!testStarted) {
                System.err.println("No test output detected. Ensure JUnit tests are properly configured.");
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("JUnit tests failed with exit code " + exitCode);
        }
    return res;
    }

}
