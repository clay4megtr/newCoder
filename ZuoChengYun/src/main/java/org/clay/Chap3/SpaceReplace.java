package org.clay.Chap3;

/**
 * 把所有的空格，替换成20%
 * @author clay
 */
public class SpaceReplace {

	public String replaceSpace(String source){
		int spaceNum = 0;		//空格数量
		for(int i = 0; i < source.length(); i++){
			
			if((source.charAt(i)+"").equals(" ")){
				spaceNum++;
			}
		}
		
		int resLen = source.length()+spaceNum*2;//需要的结果数组长度
		
		char[] res = new char[resLen];			//需要的结果数组
		
		for(int i = source.length()-1; i >= 0; i--){
			
			if(!(source.charAt(i)+"").equals(" ")){
				res[--resLen] = source.charAt(i);
			}else{
				res[--resLen] = '%';
				res[--resLen] = '0';
				res[--resLen] = '2';
			}
		}
		for(int i = 0; i < resLen; i++){
			System.out.println(res[i]);
		}
		return new String(res);
	}
	
	public static void main(String[] args) {
		SpaceReplace sr = new SpaceReplace();
		System.out.println(sr.replaceSpace("a b c"));
	}
}
