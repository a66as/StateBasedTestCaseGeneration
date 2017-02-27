/**
 * Feb 26, 2017
 * SuiteTemplate.java
 * Abbas Khan
 */
package Templates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

/**
 * @author Abbas Khan
 *
 */
/*
 *  Suite reference
 * package SUT.tests;
 *
 *	import org.eclipse.emf.common.util.EList;
 *	import org.junit.runner.RunWith;
 *	import org.junit.runners.Suite;
 *	import org.junit.runners.Suite.SuiteClasses;
 *
 *	@RunWith(Suite.class)
 *	@SuiteClasses({ checkTest.class })
 *	public class AllTests {
 *
 *	}
 *
 * 
 */
public class SuiteTemplate {
	public String pkg;
	public EList<String> imports;
	public String runsWith;
	public EList<String> suiteClasses;
	public String suiteName;
	public String suiteBody;
	public SuiteTemplate(String sn, String sb)
	{
		pkg="package SUT.tests;";
		imports=new BasicEList<String>();
		imports.add("import org.eclipse.emf.common.util.EList;");
		imports.add("import org.junit.runner.RunWith;");
		imports.add("import org.junit.runners.Suite;");
		imports.add("import org.junit.runners.Suite.SuiteClasses;");
		runsWith="@RunWith(Suite.class)";
		suiteClasses=new BasicEList<String>();
		//suiteClasses.add("checkTest.class");
		//suiteClasses.add("checkTest1.class");
		suiteName=sn;
		suiteBody=sb;
		//generateTemplateFile();
	}
	public boolean generateTemplateFile()
	{
		try {
			String code="/* Auto generated test suite for "+suiteName+" */\n";
			code+=pkg+"\n";
			for(String s:imports)
			{
				code+=s+"\n";
			}
			code+="\n";
			code+=runsWith+"\n";
			code+="@SuiteClasses({ ";
			String suiteClasses_s="";
			for(String s:suiteClasses)
			{
				suiteClasses_s+=s+".class, ";
			}
			code+=suiteClasses_s.substring(0, suiteClasses_s.length()-2);
			code+= " })";
			code+="\npublic class "+suiteName+"{\n";
			code+=suiteBody;
			code+="\n}";
			Files.write(Paths.get("src/SUT/Tests/"+suiteName+".java"), code.getBytes());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
