import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PostfixDriver {
    public static void main(String[] args)
            throws IOException{


        File testFile = new File("tests.txt");

        Scanner fr = new Scanner(testFile);

        String results = "_________Postfix Test_________"+
                "\n\nTests in format passed: true/false expected: actual: \n\n";
        int calculated = PostfixCalculator.calculate(fr.nextLine());
        results += "" + (calculated == 42);
        results += " expected: 42" + " actual: " + calculated;





        Scanner sys = new Scanner(System.in);
        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(sys.nextLine()));
        writer.write(results);

        writer.close();
    }
}
