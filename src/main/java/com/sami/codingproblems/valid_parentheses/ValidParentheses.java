package com.sami.codingproblems.valid_parentheses;

import java.util.Stack;


/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses
{

    public static void main(String[] args)
    {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";

        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid(s1));
        System.out.println(validParentheses.isValid(s2));
        System.out.println(validParentheses.isValid(s3));
        System.out.println(validParentheses.isValid(s4));
    }

    public boolean isValid(String input)
    {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{')
            {
                stack.push(current);

            }
            else if (current == ')' && !stack.isEmpty() && stack.peek().equals('('))
            {
                stack.pop();
            }
            else if (current == ']' && !stack.isEmpty() && stack.peek().equals('['))
            {
                stack.pop();
            }
            else if (current == '}' && !stack.isEmpty() && stack.peek().equals('{'))
            {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
