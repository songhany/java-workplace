package udacity.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("BigIntegerTest"), StandardCharsets.UTF_8);
        String line;
        while ((line = reader.readLine()) != null) {
//            useString(line);  // // useData is the function you customize to use "a line of text"
        }
        reader.close();


        BufferedWriter writer = Files.newBufferedWriter(Path.of("BigIntegerTest"), StandardCharsets.UTF_8);
        writer.write("Hello, ");
        writer.write("world!");
        writer.flush();
        writer.close();
    }
}
