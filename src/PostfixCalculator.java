public class PostfixCalculator {
    private static Stack<Integer> mainStack;

    public static int calculate(String equation){
        mainStack = new Stack();
        String[] instructions = equation.split(" ");



        System.out.println();
        for(int i = 0; i < instructions.length; i++){
            if(instructions[i].equals("+") || instructions[i].equals("-") || instructions[i].equals("*") ||
                    instructions[i].equals("/") || instructions[i].equals("%")){
                int second = mainStack.pop();
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
