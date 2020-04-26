package universidade;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private Map<String, String> properties = new HashMap<String, String>();
    
    public Table(Map<String, String> properties) {
    	this.properties = properties;
    }

    public String get(String key) {
        return properties.get(key);
    }

    public void set(String key, String value) {
        properties.put(key, value);
    }
    
    public void print() {
    	for (Map.Entry<String,String> entry : properties.entrySet())  
            System.out.println(entry.getKey() + ": " + entry.getValue()); 
    }
}