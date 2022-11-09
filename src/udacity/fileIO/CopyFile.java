package udacity.fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CopyFile {

    public static void main(String[] args) throws IOException {
        // 1st way
//        InputStream in = Files.newInputStream(Path.of(args[0]));
//        OutputStream out = Files.newOutputStream(Path.of(args[1]));
//
//        byte[] data = new byte[10];
//        while (in.read(data) != -1) {
//            out.write(data);
//        }
//        in.close();
//        out.close();

        // 2nd way
        Files.copy(Path.of(args[0]), Path.of(args[1]));
    }
}
