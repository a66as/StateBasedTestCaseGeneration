package TransitionTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeyValuePair1 {
     Map<String, ArrayList<String>> map;

    public KeyValuePair1() {
        map = new HashMap<>();
    }

    // Method to add value to a key
    public void addValue(String key, String value) {
        // Check if the key exists in the map
        if (map.containsKey(key)) {
            // Get the existing ArrayList for the key
            ArrayList<String> values = map.get(key);
            // Check if the value already exists in the ArrayList
            if (!values.contains(value)) {
                values.add(value);
            }
        } else {
            // If the key does not exist, create a new ArrayList and add the value
            ArrayList<String> values = new ArrayList<>();
            values.add(value);
            map.put(key, values);
        }
    }

    // Method to get values associated with a key
    public ArrayList<String> getValues(String key) {
        return map.get(key);
    }

 
}
