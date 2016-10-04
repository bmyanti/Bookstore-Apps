
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yanti
 */
public class removeDuplicate {
    public void stripDuplicatesFromFile(String filename) throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for (String unique : lines) {
        writer.write(unique);
        writer.newLine();
    }
    writer.close();
}
    
}
