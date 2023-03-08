package Iterators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class IterableReader implements Iterable<String>,Iterator<String>,AutoCloseable {            //Reader class implementing Iterable,Iterator and AutoCloseable

    private String fileName;
    public BufferedReader reader = new BufferedReader(new FileReader(fileName));        //Reader for the file

    public IterableReader(String fileName) throws IOException{              //Parameterized constructor
        this.fileName = fileName;
    }

    @Override
    public void close() throws Exception {              //Closes reader
        reader.close();
    }

    @Override
    public boolean hasNext() {              //Checks if next line is there
        return next() != null;
    }

    @Override
    public String next() {                  //Reads next line, if there is one
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            line = null;
        }
        return line;
    }

    @Override
    public Iterator<String> iterator() {            //Iterator method
        return this;
    }

    public static void main(String[] args) throws Exception {                   //Main test
        try (IterableReader read = new IterableReader("simple.txt")) {
            while (read.hasNext()) {
                System.out.println(read.next());
            }
        }
        try (IterableReader read = new IterableReader("D:\\Documents\\school\\RITsimple.txt")) {
            for (String line : read) {
                System.out.println(line);
            }
        }
    }
    
}
