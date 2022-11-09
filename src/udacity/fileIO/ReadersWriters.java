package udacity.fileIO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadersWriters {
    public static void main(String[] args) throws IOException {
        char[] data = new char[10];
        Reader reader = Files.newBufferedReader(Path.of("BigIntegerTest"), StandardCharsets.UTF_8);
        while (reader.read(data) != -1) {
//            useData(data);  // useData is the function you customize to use "characters of text"
        }
        reader.close();


        Writer writer = Files.newBufferedWriter(Path.of("BigIntegerTest"), StandardCharsets.UTF_8);
        writer.write("hello, world");
        writer.close();
    }
}
