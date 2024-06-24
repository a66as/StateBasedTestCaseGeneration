/**
 * Feb 26, 2017
 * TestCaseTemplate.java
 * Abbas Khan
 */
package Templates;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

import utils.JavaCodeFormatter;

import java.io.*;

/**
 * @author Abbas Khan
 *
 */
/*
package SUT.tests;

import SUT.ThreePlayerGame;
import static org.junit.Assert.*;

import org.junit.Test;
public class checkTest {

	@Test
	public void test() {
		ThreePlayerGame tpg= new ThreePlayerGame();
		assertEquals("Game Started", tpg.stateReporter());
	}

}
*/
public class TestCaseTemplate {
	public String pkg;
	public String cut;
	public EList<String> imports;
	public String testName;
	public EList<String> body;
	public TestCaseTemplate(String sut, String tstName)
	{
		pkg="package SUT.tests;";
		imports=new BasicEList<String>();
		body=new BasicEList<String>();
		cut=sut;
		imports.add("import SUT."+cut+";");
		imports.add("import static org.junit.Assert.*;");
		imports.add("import org.junit.Test;");
		testName=tstName;
	}
	public boolean generateTemplateFile()
	{
		try {
			String code="/* Auto generated test case for "+cut+" */\n";
			code+=pkg+"\n";
			for(String s:imports)
			{
				code+=s+"\n";
			}
			code+="\n";
			code+="\npublic class "+testName+"{\n";
			for(String line:body)
			{
				code+=line+"\n";
			}
			code+="\n}";
			Files.write(Paths.get("src/SUT/Tests/"+testName+".java"), code.getBytes());
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	
	 public void filterTestCases() {
	      // load Test case file
	        	String fileName="src/SUT/Tests/"+this.testName+".java";
	        	   try {
	        		   String content="";
	        		   	List<String> contents=Files.readAllLines(Paths.get(fileName));
	        		   	for(String i : contents)
	        		   	{
	        		   		content+=i+"\n";
	        		   	}
	        	        String[] tokens = content.split("@Test");
	        	        StringBuilder filteredContent = new StringBuilder();
	        	        boolean firstToken = true;

	        	        for (String token : tokens) {
	        	            if (firstToken) {
	        	                filteredContent.append(token.trim());
	        	                firstToken = false;
	        	            } else {
	        	                if (token.contains("_131231")) {
	        	                    // Remove _131231
	        	                    token = token.replace("_131231", "");
	        	                    filteredContent.append("\n@Test\n").append(token.trim());
	        	                }
	        	            }
	        	        }

	        	        // Append '}' if the last token was removed and the file ended with an incomplete test case
	        	        if (!tokens[tokens.length - 1].contains("_131231")) {
	        	            filteredContent.append("\n}");
	        	        }
	        	        //to save Formated code
	        	        String formattedCode=filteredContent.toString();
	        	        JavaCodeFormatter formatter=new JavaCodeFormatter();
	        	        formattedCode= formatter.formatCode(formattedCode);
	        	        
	        	        Files.write(Paths.get(fileName), formattedCode.getBytes());

	        	    } catch (IOException e) {
	        	        e.printStackTrace();
	        	    }
	    }

	
	

	
	
	
	
	
	
	
	
	
}
