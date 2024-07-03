package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionParser {
    public static String[] parseCondition(String condition) {
       // String condition = "this.p1_Score()==20";
        condition=condition.replace(",", "");
        condition=condition.replace("[", "");
        condition=condition.replace("]", "");
        condition=condition.replace("this", "sut");
        
        

        // Define the regex pattern to match individual conditions
        String conditionPatternString = "(sut\\.\\w+\\(\\))\\s*(==|!=|<=|>=|<|>)\\s*(\\d+)";
        Pattern conditionPattern = Pattern.compile(conditionPatternString);

        // Define the regex pattern to split by logical operators (&&, ||)
        String logicalOperatorPatternString = "\\s*(&&|\\|\\|)\\s*";
        Pattern logicalOperatorPattern = Pattern.compile(logicalOperatorPatternString);

        // Split the conditions and logical operators
        List<String> conditionsList = new ArrayList<>();
        List<String> logicalOperatorsList = new ArrayList<>();

        Matcher conditionMatcher = conditionPattern.matcher(condition);
        Matcher logicalOperatorMatcher = logicalOperatorPattern.matcher(condition);

        int lastEnd = 0;
        while (logicalOperatorMatcher.find()) {
            String subCondition = condition.substring(lastEnd, logicalOperatorMatcher.start()).trim();
            if (!subCondition.isEmpty()) {
                conditionsList.add(subCondition);
            }
            logicalOperatorsList.add(logicalOperatorMatcher.group().trim());
            lastEnd = logicalOperatorMatcher.end();
        }
        // Add the last condition
        String lastCondition = condition.substring(lastEnd).trim();
        if (!lastCondition.isEmpty()) {
            conditionsList.add(lastCondition);
        }

        // List to store the parsed conditions
        List<String[]> parsedConditions = new ArrayList<>();

        for (String subCondition : conditionsList) {
            // Match the pattern against each sub-condition
            Matcher matcher = conditionPattern.matcher(subCondition);

            // Check if the pattern matches and extract components
            if (matcher.matches()) {
                String[] conditionComponents = new String[3];
                conditionComponents[0] = matcher.group(1);  // Left operand
                conditionComponents[1] = matcher.group(2);  // Operator
                conditionComponents[2] = matcher.group(3);  // Right operand
                parsedConditions.add(conditionComponents);
            } else {
                System.out.println("The sub-condition does not match the expected pattern: " + subCondition);
            }
        }

        // Convert the list to a 2D array
        String[][] conditionsArray = new String[parsedConditions.size()][3];
        for (int i = 0; i < parsedConditions.size(); i++) {
            conditionsArray[i] = parsedConditions.get(i);
        }

        // Print the 2D array
        for (int i = 0; i < conditionsArray.length; i++) {
           // System.out.println("Condition " + (i + 1) + ":");
        	// System.out.println("Left Operand: " + conditionsArray[i][0]);
        	//System.out.println("Operator: " + conditionsArray[i][1]);
        	//System.out.println("Right Operand: " + conditionsArray[i][2]);
        	//System.out.println();
        }
        
        if(conditionsArray.length==0)
        	return null;
        return conditionsArray[0];
        // Print the logical operators
       
    }
}
