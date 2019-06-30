package ch4;

import java.util.Scanner;
import java.util.Stack;



/**
 * @anthor wangyul
 * @date 2019/6/28 23:25
 * 判断字符串中 括号是否合法  ((([[]])))
 * 用堆栈 时间复杂度为o(n)  空间复杂度为 o(n)
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        String a = "()[]{}((({]})))";
         signCheck(a);
        // System.out.println(ab);
    }

    // 时间复杂度 比 用堆栈的时间复杂度低
    public static Boolean isValid(String s){
        int length;
        do{
            length = s.length();
            s = s.replace("()","").replace("{}","")
                    .replace("[]","");
        }while (length != s.length());

        return s.length() ==0;
    }

    // 字符串检查
    public static void signCheck(String str) throws Exception {
        Stack stack = new Stack();
        String[] arr = expToStringArray(str);
        for (int i = 0; i < arr.length; i++) {
            // 如果数组中有这三种左括号元素那么直接进行入栈操作
            if (arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{")) {
                stack.push(arr[i]);
            }

            else if (arr[i].equals(")") && !stack.isEmpty()
                    && stack.peek().equals("(")) {
                // 上面的if判断主要是当我们遇到右括号时，发现当前位于栈顶的是左括号，那么此时可以出栈了
                stack.pop();
            }

            else if (arr[i].equals(")") && !stack.isEmpty()
                    && !stack.peek().equals("(")) {

                System.out.println("左右括号匹配次序不成功");
                return;
            }
            // 遇到中括号时
            else if (arr[i].equals("]") && !stack.isEmpty()
                    && stack.peek().equals("[")) {
                // 上面的if判断主要是当我们遇到右括号时，发现当前位于栈顶的是左括号，那么此时可以出栈了
                stack.pop();
            }

            else if (arr[i].equals("]") && !stack.isEmpty()
                    && !stack.peek().equals("[")) {

                System.out.println("左右括号匹配次序不成功");
                return;
            }

            // 大括号匹配
            else if (arr[i].equals("}") && !stack.isEmpty()
                    && stack.peek().equals("{")) {
                // 上面的if判断主要是当我们遇到右括号时，发现当前位于栈顶的是左括号，那么此时可以出栈了
                stack.pop();
            }

            else if (arr[i].equals("}") && !stack.isEmpty()
                    && !stack.peek().equals("{")) {

                System.out.println("左右括号匹配次序不成功");
                return;
            }

            // 右括号多于左括号的情况
            else if (arr[i].equals(")") || arr[i].equals("]")
                    || arr[i].equals("}") && stack.isEmpty()) {
                System.out.println("右括号多于左括号");
                return;
            }
        }
        // 经历完一趟循环后如果堆栈不为空，那么左括号就多了
        if (!stack.isEmpty()) {
            System.out.println("左括号多于右括号");
        } else {
            System.out.println("匹配正确");
        }

    }

    // 字符串转为字符串数组
    public static String[] expToStringArray(String exp) {
        // 字符串数组长度
        int n = exp.length();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = exp.substring(i, i + 1);
        }

        return arr;
    }
}
