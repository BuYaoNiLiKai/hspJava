package files;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Code14_PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = System.out;
        System.setOut(new PrintStream("hello.txt"));
        System.out.println("ni haoa a a  ");
        PrintWriter pw = new PrintWriter(out);
        pw.println("hello");


    }
}
