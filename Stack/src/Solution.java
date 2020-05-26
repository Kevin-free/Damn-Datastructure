import java.util.Stack;

/**
 * 有效的括号
 * 解决方案
 */
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //获取字符串s的第i个字符
            if (c == '(' || c == '[' || c == '{') { //如果是左括号，push到栈stack中
                stack.push(c);
            } else { //否则是右括号，
                if (stack.isEmpty()) //如果当前栈为空，即没有左括号，return false；
                    return false;

                char topChar = stack.pop(); // 有元素的话pop出栈顶元素，即上一个左括号
                if (c == ')' && topChar != '(') //如果c是),但是topChar不是), false
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }

        return stack.isEmpty(); //栈里还有字符的话false，匹配正确时即栈中为空true
    }
}