package udacity.designPattern.structuralPatterns.decoratorPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

// In this demo, we wrote a decorator that counted the number of reads to a Reader. The decorator proved that the BufferedReader reduced the number of reads from disk by about 90%. Pretty good!
public final class CountReads {

    public static final class CountingReader extends Reader {
        private int count = 0;

        private final Reader delegate;

        CountingReader(Reader delegate) {
            this.delegate = Objects.requireNonNull(delegate);
        }

        public int getCount() {
            return count;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            count++;
            return delegate.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            delegate.close();

        }
    }

    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader(new File("randomtext.txt"))) {
            CountingReader unbufferedReads = new CountingReader(reader);
            CountingReader bufferedReads = new CountingReader(new BufferedReader(unbufferedReads));

            char[] data = new char[100];
            while (bufferedReads.read(data) != -1);

            System.out.println("Calls to BufferedReader.read(): " + bufferedReads.getCount());
            System.out.println("Calls to FileReader.read(): " + unbufferedReads.getCount());
        }
    }
}
