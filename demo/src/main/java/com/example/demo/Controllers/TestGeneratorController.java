package com.example.demo.Controllers;

import com.example.demo.services.JUnitRunnerService;
import com.example.demo.utils.FileReaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import statemachinereader.StateMachineReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class TestGeneratorController {
@Autowired
JUnitRunnerService compilerService;

    @GetMapping("/")
    public String index(Model model) throws IOException {
        String fileName1="src/niSUT/niTwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="src/niSUT/niThreePlayerGame.java";
        String content2 = Files.readString(Paths.get(fileName2));
        model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        return "index";
    }

    @GetMapping("/index")
    public String index1(Model model) throws IOException {
        String fileName1="src/niSUT/niTwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="src/niSUT/niThreePlayerGame.java";
        String content2 = Files.readString(Paths.get(fileName2));
        model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        return "index";
    }



    @GetMapping("/instrumented_sut")
    public String instrumentedSUT(Model model) throws IOException {
        String fileName1="src/SUT/TwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="src/SUT/ThreePlayerGame.java";
        String content2 = Files.readString(Paths.get(fileName2));
        model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        return "instrumented_sut";
    }


    @GetMapping("/evaluate_sut")
    public String evaluateSUT(Model model) throws IOException {

        return "evaluate_sut";
    }

    // Under Work
    @PostMapping("/submitCheckBox")
    @ResponseBody
    public String submitCheckBox(@RequestParam("tasks") String[] tasks) throws Exception {


        FileReaderHelper fileHelper = new FileReaderHelper();
        String c="";
        String mutantsDetails="";
        for(String task : tasks){
            for(int i=1 ;i<18;i++) {
                String temp="";
                c+="Runnning m"+i+"\n\n";
                temp=compilerService.processAndExecuteMutations(fileHelper.getClassCode(task),"m"+i+"TwoPlayerGame","m"+i+"ThreePlayerGame");
                c+=temp;
                if(temp.contains("FAILURES")){
                    mutantsDetails+=task+"-> M"+i+" killed!\n";
                }
                else {
                    mutantsDetails+=task+"-> M"+i+" Survived!\n";
                }
                System.out.println(c);
            }
        }
        //System.out.println("___"+c);
        return  mutantsDetails+c;
    }




    @GetMapping("/generatetestcases")
    public String generate_testcases(Model model) throws Exception {

        String fileName1="src/SUT/tests/user_AllTransitionsTestSuite.java";
        String fileName2="src/SUT/tests/user_SneakPathTestSuit.java";
        String content2 ="";
        String content1 ="";
        // flag to check if generate path already run or not;
        boolean flag=true;
        try{
            content1 = Files.readString(Paths.get(fileName1));
        }
        catch (Exception e){
            StateMachineReader stateMachineReader=new StateMachineReader();
            flag=false;
            fileName1="src/SUT/tests/AllTransitionsTestSuite.java";
            content1 = Files.readString(Paths.get(fileName1));
        }


        try{

            content2 = Files.readString(Paths.get(fileName2));
        }
        catch (Exception e){
            if(flag) {
                StateMachineReader stateMachineReader = new StateMachineReader();
            }
            fileName2="src/SUT/tests/SneakPathTestSuit.java";
            content2 = Files.readString(Paths.get(fileName2));
        }

        //model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        model.addAttribute("text3", "");
        return "generate_testcases";

    }



    @PostMapping("/submitForm")
    @ResponseBody
    public String submitForm(@RequestParam("codeContent") String code) throws Exception {


        //System.out.println(output);

        return  compilerService.processAndExecute(code);
    }

    @PostMapping("/submitUnitTestForm")
    @ResponseBody
    public String submitUnitTestForm(@RequestParam("codeContent") String code) throws Exception {


        System.out.println("output");

        return  compilerService.processAndExecute(code);
    }


    @GetMapping("/unit-tests")
    public String unitTests(Model model) throws Exception {
        //StateMachineReader stateMachineReader=new StateMachineReader();
        String fileName1="src/niSUT/tests/user_UnitTests.java";
        String content1 = "";
        try{
            content1 = Files.readString(Paths.get(fileName1));
        }
        catch (Exception e){
            fileName1="src/niSUT/tests/UnitTests.java";
            content1 = Files.readString(Paths.get(fileName1));

        }
        //model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text3", "");
        return "unit_tests";

    }


    @GetMapping("/state-model")
    public String stateModel(Model model) throws Exception {
        //StateMachineReader stateMachineReader=new StateMachineReader();
        String fileName1="src/niSUT/tests/user_UnitTests.java";
        String content1 = "";
        try{
            content1 = Files.readString(Paths.get(fileName1));
        }
        catch (Exception e){
            fileName1="src/niSUT/tests/UnitTests.java";
            content1 = Files.readString(Paths.get(fileName1));

        }
        //model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text3", "");
        return "state_model";

    }


    @PostMapping("/download")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadUnitTestClass(@RequestParam("codeContent") String code) throws Exception {
     // String code="hello world";
        String filename =  compilerService.extractClassName(code)+ ".java";
        InputStream fileStream = new ByteArrayInputStream(code.getBytes());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
                .contentType(MediaType.TEXT_PLAIN)
                .body(new InputStreamResource(fileStream));
    }


    @PostMapping("/save-unit-tests")
    @ResponseBody
    public String saveFiles(@RequestParam("codeContent") String code,@RequestParam("fileName") String fileName1) throws Exception {
        //StateMachineReader stateMachineReader=new StateMachineReader();
      //  String fileName1="src/niSUT/tests/user_UnitTests.java";
        try {
            // Write content to the file
            Files.writeString(Paths.get(fileName1), code, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return "File saved successfully!";
        } catch (Exception e) {
            // Handle file writing exception
            System.out.println(e);
            return "Error in saving file please try again.";
        }

    }


    @PostMapping("/delete-file")
    @ResponseBody
    public String deleteFiles(@RequestParam("fileName") String filePath) throws Exception {


        // Check if the file exists and delete if it does
        try{
        boolean deleted = Files.deleteIfExists(Paths.get(filePath));
            System.out.println(deleted);
        }
        catch (Exception e){
            System.out.println(e);

        }
        return "success!";
    }


}