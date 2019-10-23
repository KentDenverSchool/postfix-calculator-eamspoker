import java.util.EmptyStackException;
/*
 * PostfixCalculator.java
 * This class performs a calculation in postfix notation. This is where the program pushes numbers on to the stack,
 * then pops off and performs a calculation on these numbers, then pushes the result back. It does this until all
 * the operators and operands in the equation are used.
 * Date: 10/23/19
 * On my honor: EA
 */
public class PostfixCalculator {

    //static stack for calculation
    private static Stack<Integer> mainStack;

    //returns the calculated int, has an equation as a string for a parameter, uses postfix notation to
    // perform a calculation
    public static int calculate(String equation) {
        mainStack = new Stack();
        String[] instructions = equation.split(" ");
        for(int i = 0; i < instructions.length; i++){

            //check if the next thing entered is an operator
            if(instructions[i].equals("+") || instructions[i].equals("-") || instructions[i].equals("*") ||
                    instructions[i].equals("/") || instructions[i].equals("%")){

                //the first one popped off will also be the second operand, and vice versa
                int second = mainStack.pop();
                int first = mainStack.pop();
                int result = 0;

                //perform one of 5 operation if it is an operator
                switch(instructions[i]){
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;

                    case "*":
                        result = first * second;
                        break;

                    case "/":
                        result = first / second;
                        break;

                    case "%":
                        result = first % second;
                        break;
                }

                mainStack.push(result);


            } else {
                //if it is a number, push it on to the stack
                mainStack.push(instructions[i].charAt(0) - '0');
            }
        }

        //return the last number (i.e. the result) on the stack
        return mainStack.pop();

    }



}
