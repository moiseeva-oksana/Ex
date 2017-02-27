package queueAndStack;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketsValidator {
    private Deque<String> queue = new LinkedList<>();
    private Deque<String> stack = new LinkedList<>();
    public boolean validate(String s) {
        stack = getOpeningBrackets(s);
        queue = getClosingBrackets(s);
        if(queue.size()!=stack.size()) {
            return false;
        }
        int size = queue.size();
        boolean result = true;
        for(int i=0; i<size; i++) {
            String concat = stack.removeLast()+queue.removeFirst();
            if (!(concat.equals("()") || concat.equals("[]"))) {
                result=false;
            }
        }
        return result;
    }

    private Deque<String> getOpeningBrackets(String str) {
        Deque<String> openingBrackets = new LinkedList<>();
        Matcher m = Pattern.compile("[\\[(]").matcher(str);
        while (m.find()) {
            openingBrackets.add(m.group());
        }
        return openingBrackets;
    }

    private Deque<String> getClosingBrackets(String str) {
        Deque<String> closingBrackets = new LinkedList<>();
        Matcher m = Pattern.compile("[\\])]").matcher(str);
        while (m.find()) {
            closingBrackets.add(m.group());
        }
        return closingBrackets;
    }

    public static void main(String[] args) {
        System.out.println(new BracketsValidator().validate("([])()[]"));
    }
}
