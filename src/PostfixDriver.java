import jdk.nashorn.internal.runtime.ECMAException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class PostfixDriver {
    public static void main(String[] args)
            throws IOException{


        //read in new file for tests
        File testFile = new File("tests.txt");

        Scanner fr = new Scanner(testFile);

        String results = "_________Postfix Test_________"+
                "\n\nTests in format passed: true/false expected: actual: \n\n";

        //calculated is the calculation, answer is expected
        int calculated = 0;
        int answer = 0;

        while(fr.hasNextLine()){
            //try and catch exceptions, check if calculation equals the expected answer
            try {
                calculated = PostfixCalculator.calculate(fr.nextLine());
                answer = fr.nextInt();
                fr.nextLine();
                results += "" + (calculated == answer);
                results += " expected: " + answer + " actual: " + calculated;
            } catch(Exception e){
                results += "ERROR - test: " + fr.nextLine() + " expected: " + fr.nextInt() + " ";
                fr.nextLine();
                results += e;
            }

            //separate tests by lines
            results += "\n";
        }

        //creates new logfile
        Scanner sys = new Scanner(System.in);
        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(sys.nextLine()));
        writer.write(results);

        writer.close();
    }
}
