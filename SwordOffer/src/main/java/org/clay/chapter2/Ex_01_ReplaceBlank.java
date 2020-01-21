package org.clay.chapter2;

/**
 * 替换空格，把空格替换成 %20
 */
public class Ex_01_ReplaceBlank {

    /**
     * 第二种方法：空间复杂度 O(1)
     * 核心点：从后往前
     */
    public static String process2(StringBuffer str){
        if(str == null || str.equals("") || str.indexOf(" ") == -1){
            return str.toString();
        }

        int blankCount = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                blankCount++;
            }
        }

        int originalIndex = str.length() - 1;
        int newIndex = str.length() + 2 * blankCount - 1;
        str.setLength(str.length() + 2 * blankCount);

        while(newIndex >= 0){
            if(str.charAt(originalIndex) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
                originalIndex--;
            }else{
                str.setCharAt(newIndex--,str.charAt(originalIndex--));
            }
        }

        return str.toString();
    }

    /**
     * 第一种方法：空间复杂度  O(N)
     */
    public static String process1(String str){
        if(str == null || str.equals("") || !str.contains(" ")){
            return str;
        }

        int blankCount = 0;
        for(char c: str.toCharArray()){
            if(c == ' '){
                blankCount++;
            }
        }

        char[] source = str.toCharArray();
        char[] dest = new char[str.length() + blankCount*2];
        for(int i = source.length-1, j = dest.length-1; i >= 0 && j >= 0; i--,j--){
            if(source[i] == ' '){
                dest[j--] = '0';
                dest[j--] = '2';
                dest[j] = '%';
            }else{
                dest[j] = source[i];
            }
        }

        return new String(dest);
    }


    public static void main(String[] args) {
        String str = "abc de f";
        System.out.println(process1(str));
        System.out.println(process2(new StringBuffer(str)));
    }
}
