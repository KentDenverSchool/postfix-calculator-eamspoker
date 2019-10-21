import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StackDriver {
    public static void main(String[] args)
            throws IOException{
        Scanner s = new Scanner(System.in);
        String results = "_________Postfix Test_________"+
                "\n\nTests in format passed: true/false expected: actual: \n\n";







        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(s.nextLine()));
        writer.write(results);

        writer.close();
    }
}
