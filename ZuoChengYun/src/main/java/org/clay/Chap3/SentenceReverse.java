package org.clay.Chap3;

/**
 * 旋转句子里的单词
 * @author clay
 */
public class SentenceReverse {

	public String reverse(String source){
		
		char[] array = source.toCharArray();
		
		int n = source.length() -1;
		
		int halfLength = n/2;
		
		for(int i = 0; i < halfLength; i++){
			
			char temp = array[i];
			array[i] = array[n - i];
			array[n - i] = temp;
		}
		return new String(array);
	}
	
	public String sentenceReverse(String snetence){
		
		StringBuilder builder = new StringBuilder();
		
		String reverseSentence = reverse(snetence);
		
		String[] split = reverseSentence.split(" ");
		
		for(int i = 0; i < split.length; i++){
			
			builder.append(reverse(split[i]) + " ");
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		
		SentenceReverse sr = new SentenceReverse();
		
		String sentence = "pig loves dog";
		String reverse = sr.sentenceReverse(sentence);
		System.out.println(reverse);
	}
}
