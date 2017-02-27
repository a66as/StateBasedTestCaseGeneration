/**
 * Feb 26, 2017
 * TestCaseTemplate.java
 * Abbas Khan
 */
package Templates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
