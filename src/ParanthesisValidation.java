import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gmani on 2/7/16.
 */
public class ParanthesisValidation {

    public static void main(String[] agrs) {
        System.out.println(validateParanthesis("{{}}[]"));
        System.out.println(validateParanthesis("{{}}["));
        System.out.println(validateParanthesis("{{}}[]]"));
    }

    public static boolean validateParanthesis(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == '}' && stack.peekLast() == '{') {
                stack.removeLast();
            } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peekLast() == '[' ) {
                stack.removeLast();
            } else if (s.charAt(i) == ')' && stack.peekLast() == '(') {
                stack.removeLast();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
