package org.clay.basic_class_02_Re;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 这道题目的关键点在于遇到运算符号的时候才去把pre之前的数字放进栈，这样才能保证放进去的是31，而不是3、1，
 * 而且pre初始值为0也很好的解决了负数的问题，0 - num
 */
public class StringCompute {


    /**
     * @param str  原字符串
     * @param i  从str的哪个位置开始计算
     * @return   两个长度的一个数组，第一个值表示结果，第二个值表示后续的计算要从哪个位置继续执行
     */
    public static int[] value(char[] str,int i){

        Stack<String> stack = new Stack<>();
        int pre = 0;

        while(i < str.length && str[i] != ')'){
            if(str[i] >= '0' && str[i] <= '9'){
                pre = pre * 10 + str[i++] - '0';
            }else if(str[i] != '('){  //+ - * /
                addNum(stack,pre);
                stack.push(String.valueOf(str[i++]));
                pre = 0;
            }else{
                int[] res = value(str,i+1);
                pre = res[0];
                i = res[1];
            }
        }
        addNum(stack,pre);
        return new int[]{getNum(stack),i+1};
    }

    public static void addNum(Stack<String> stack,int num){

        if (!stack.isEmpty()){

            String rule = String.valueOf(stack.pop());
            if(rule.equals("+") || rule.equals("-")){
                stack.push(rule);
                stack.push(String.valueOf(num));
            }else if(rule.equals("*")){
                Integer ff = Integer.valueOf(stack.pop()) * num;
                stack.push(String.valueOf(ff));
            }else{
                stack.push(String.valueOf(Integer.valueOf(stack.pop()) / num));
            }
        }else{
            stack.push(String.valueOf(num));
        }
    }

    public static int getNum(Stack<String> stack){

        if(stack.isEmpty()){
            return 0;
        }

        int res = Integer.valueOf(removeLast(stack));

        while(!stack.isEmpty()){
            String rule = removeLast(stack);
            if(rule.equals("+")){
                res += Integer.valueOf(removeLast(stack));
            }else{
                res -= Integer.valueOf(removeLast(stack));
            }
        }

        return res;
    }

    public static String removeLast(Stack<String> stack){

        if(stack.size() > 1){
            String cu = stack.pop();

            String res = removeLast(stack);

            stack.push(cu);

            return res;
        }else{
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(value(exp.toCharArray(),0)[0]);

        exp = "4*(6+78)+53-9/3+45*8";
        System.out.println(value(exp.toCharArray(),0)[0]);

        exp = "10-5*3";
        System.out.println(value(exp.toCharArray(),0)[0]);

        exp = "-3*4";
        System.out.println(value(exp.toCharArray(),0)[0]);

        exp = "3+1*4";
        System.out.println(value(exp.toCharArray(),0)[0]);
    }
}
