package Coding.stack;

import java.util.Stack;

public class EvaluatePostfix {
    static int evaluatePostfix(String[] arr){
        Stack<Integer> s = new Stack<>();
        for(String a : arr){
            if(a.matches("-?\\d+")){
                s.push(Integer.parseInt(a));
            }

            else {
                int val1 = s.pop();
                int val2 = s.pop();
                switch (a) {
                    case "+":
                        s.push(val2 + val1);
                        break;
                    case "-":
                        s.push(val2 - val1);
                        break;
                    case "*":
                        s.push(val2 * val1);
                        break;
                    case "/":
                        s.push(val2 / val1);
                        break;
                }
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr));
    }
}
