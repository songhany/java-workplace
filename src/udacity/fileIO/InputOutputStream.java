package udacity.fileIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InputOutputStream {
    public static void main(String[] args) throws IOException {
        InputStream in = Files.newInputStream(Path.of("BigIntegerTest"), StandardOpenOption.READ);
        byte[] data = new byte[10];
        while(in.read(data) != -1) {
//            useData(data);   // useData is the function you customize to use "bytes"
        }
        in.close();

        //------------------------------------
        OutputStream out = Files.newOutputStream(Path.of("BigIntegerTest"));
        out.write("Hello, world!".getBytes());
        out.close();
    }
}
