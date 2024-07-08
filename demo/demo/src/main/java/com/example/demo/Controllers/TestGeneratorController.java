package com.example.demo.Controllers;

import com.example.demo.services.JUnitRunnerService;
import com.example.demo.utils.FileReaderHelper;
import com.example.demo.utils.StringTokenizerUtil;
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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class TestGeneratorController {
@Autowired
JUnitRunnerService compilerService;

String modelAddress="Models/StateMachine.uml";
String userSavedModelAddress="Models/User_StateMachine.uml";
    @GetMapping("/")
    public String index(Model model) throws IOException {
        String fileName1="/app/src/niSUT/niTwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="/app/src/niSUT/niThreePlayerGame.java";
        String content2 = Files.readString(Paths.get(fileName2));
        model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        return "index";
    }

    @GetMapping("/index")
    public String index1(Model model) throws IOException {
        String fileName1="/app/src/niSUT/niTwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="/app/src/niSUT/niThreePlayerGame.java";
        String content2 = Files.readString(Paths.get(fileName2));
        model.addAttribute("name", "User");
        model.addAttribute("text1",content1 );
        model.addAttribute("text2", content2);
        return "index";
    }



    @GetMapping("/instrumented_sut")
    public String instrumentedSUT(Model model) throws IOException {
        String fileName1="/app/src/SUT/TwoPlayerGame.java";
        String content1 = Files.readString(Paths.get(fileName1));
        String fileName2="/app/src/SUT/ThreePlayerGame.java";
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

    @PostMapping("/submitCheckBox")
    @ResponseBody
    public String submitCheckBox(@RequestParam("tasks") String[] tasks) throws Exception {


        FileReaderHelper fileHelper = new FileReaderHelper();
        String c="";
        String mutantsDetails="";


        // get orignal outputs in this String
        String[] orignalOutputs= new String[tasks.length];
        // now this list will hold a list of failed testcases in orignal classes
        List<List<String>> failedTestCases=new ArrayList<>();
        int index=0;
        StringTokenizerUtil tokenizer=new StringTokenizerUtil();
        List<List<String>> methodNames=new ArrayList<>();
       //To get the results for original code so that we can compare it to kill the mutants
        for(String task:tasks){
            String code=fileHelper.getClassCode(task);
            orignalOutputs[index]=compilerService.processAndExecute(code);
            methodNames.add(tokenizer.processString(code));
            List<String> failedTestMethods=new ArrayList<>();
            for(int l=0;l<methodNames.get(index).size();l++){
                //get indivisual failed testcases
                if(orignalOutputs[index].contains(methodNames.get(index).get(l))){
                    failedTestMethods.add(methodNames.get(index).get(l));
                }
            }
            failedTestCases.add(failedTestMethods);
            index++;
        }





        index=0;
        for(String task : tasks){
            for(int i=0 ;i<18;i++) {
                String temp="";
                c+="Runnning m"+i+"\n\n";
                temp=compilerService.processAndExecuteMutations(fileHelper.getClassCode(task),"m"+i+"TwoPlayerGame","m"+i+"ThreePlayerGame");
                c+=temp;
                if(temp.contains("FAILURES")){
                    if(!orignalOutputs[index].contains("FAILURES")){
                        mutantsDetails += task+"-> M"+i+" killed!\n";
                    }
                    else{

                        //getting all testcases which are failed in the mutants
                        List<String> failedTestCasesInMutants=new ArrayList<>();
                        for(int m=0;m<methodNames.get(index).size();m++){
                            if(temp.contains(methodNames.get(index).get(m)));
                            {
                                failedTestCasesInMutants.add(methodNames.get(index).get(m));
                            }

                        }
                        //now compare the orignal class Failed Testcases and the new class failed testcases
                        boolean checker=false;
                       for(String testcase:failedTestCases.get(index)){
                           String result = failedTestCasesInMutants.stream().collect(Collectors.joining(", "));

                           if(result.contains(testcase) && (failedTestCases.get(index).size()<failedTestCasesInMutants.size())){

                           }else{
                                checker=true;
                               mutantsDetails += task+"-> M"+i+" Survived!\n";
                               break;
                           }

                       }
                       if(!checker){
                           mutantsDetails += task+"-> M"+i+" Killed!\n";



                       }




                    }

                }
                else {
                    mutantsDetails+=task+"-> M"+i+" Survived!\n";
                }
                System.out.println(c);
            }
            index++;
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
            try{
                System.out.println("reading");
                StateMachineReader stateMachineReader=new StateMachineReader(userSavedModelAddress);

            }
            catch (Exception ex){
                StateMachineReader stateMachineReader=new StateMachineReader(modelAddress);

            }
            flag=false;
            fileName1="src/SUT/tests/AllTransitionsTestSuite.java";
            content1 = Files.readString(Paths.get(fileName1));
        }


        try{

            content2 = Files.readString(Paths.get(fileName2));
        }
        catch (Exception e){
            if(flag) {
                try{
                    StateMachineReader stateMachineReader=new StateMachineReader(userSavedModelAddress);

                }
                catch (Exception ex){
                    StateMachineReader stateMachineReader=new StateMachineReader(modelAddress);

                }
            }
            fileName2="src/SUT/tests/SneakPathTestSuit.java";
            content2 = Files.readString(Paths.get(fileName2));
        }

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

        String umlData="";
        try{
            umlData=Files.readString(Paths.get(userSavedModelAddress));
        }
        catch(Exception e){
            umlData=Files.readString(Paths.get(modelAddress));

        }

        model.addAttribute("uml", umlData);


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