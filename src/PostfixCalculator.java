import java.util.EmptyStackException;

public class PostfixCalculator {
    private static Stack<Integer> mainStack;

    public static int calculate(String equation) throws EmptyStackException {
        mainStack = new Stack();
        String[] instructions = equation.split(" ");
        for(int i = 0; i < instructions.length; i++){
            if(instructions[i].equals("+") || instructions[i].equals("-") || instructions[i].equals("*") ||
                    instructions[i].equals("/") || instructions[i].equals("%")){
                if(mainStack.isEmpty()){
                    throw new EmptyStackException();
                }

                int second = mainStack.pop();

                if(mainStack.isEmpty()){
                    throw new EmptyStackException();
                }

                int first = mainStack.pop();
                int result = 0;
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
                mainStack.push(instructions[i].charAt(0) - '0');
            }
        }

        return mainStack.pop();

    }



}
