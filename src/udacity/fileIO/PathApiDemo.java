package udacity.fileIO;

import java.nio.file.Path;

public class PathApiDemo {
    public static void main(String[] args) {
        Path p = Path.of(".");
//        System.out.println("Path: " + p.toAbsolutePath().normalize());
        System.out.println("Path: " + p.toAbsolutePath().resolve("..").normalize().toUri());  // it will print "file:///Users/songhan/Desktop/"  This string can be pasted to web broswer, then the browser will navigate to file location

    }
}
