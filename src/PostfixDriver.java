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


        File testFile = new File("tests.txt");

        Scanner fr = new Scanner(testFile);

        String results = "_________Postfix Test_________"+
                "\n\nTests in format passed: true/false expected: actual: \n\n";
        int calculated = 0;
        try {
            calculated = PostfixCalculator.calculate(fr.nextLine());
            results += "" + (calculated == 2);
            results += " expected: 2" + " actual: " + calculated;
        } catch(Exception e){
            results += e;
        }

        results += "\n";

        try {
            calculated = PostfixCalculator.calculate(fr.nextLine());
            results += "false expected: empty stack exception actual: " + calculated;
        } catch(Exception e){
            if(e instanceof EmptyStackException) {
                results += "true expected: empty stack exception actual: " + e;
            } else {
                results += "false expected: empty stack exception actual: " + e;
            }
        }
        results += "\n";

        try {
            calculated = PostfixCalculator.calculate(fr.nextLine());
            results += "false expected: empty stack exception actual: " + calculated;
        } catch(Exception e) {
            if(e instanceof EmptyStackException) {
                results += "true expected: empty stack exception actual: " + e;
            } else {
                results += "false expected: empty stack exception actual: " + e;
            }
        }
        results += "\n";


        try {
            calculated = PostfixCalculator.calculate(fr.nextLine());
            results += "" + (calculated == -1);
            results += " expected: -1" + " actual: " + calculated;
        } catch(Exception e){
            results += e;
        }
        results += "\n";

        try{
            calculated = PostfixCalculator.calculate(fr.nextLine());
            results += "" + (calculated == -4);
            results += " expected: -4" + " actual: " + calculated;
        } catch(Exception e){
            results += e;
        }







        Scanner sys = new Scanner(System.in);
        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(sys.nextLine()));
        writer.write(results);

        writer.close();
    }
}
