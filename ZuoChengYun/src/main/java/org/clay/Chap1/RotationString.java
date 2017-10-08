package org.clay.Chap1;

/**
 * 旋转字符：1234  和     3412  是旋转字符
 * @author clay
 */
public class RotationString {
	
	public boolean chkRotation(String A, int lena, String B, int lenb){
		
		if(A.length() != B.length()){
			return false;
		}else{
			String sumString = A + A;
			int j;
			for(int i = 0; i < sumString.length()-lenb + 1; i++){
				for(j = 0; j < lenb; j++){
					
					if(sumString.charAt(i + j) != B.charAt(j)){
						break;
					}
				}
				if(j == B.length()){
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
	
		RotationString rs = new RotationString();
		
		boolean chkRotation = rs.chkRotation("1234", 4, "3412", 4);
		System.out.println(chkRotation);
	}
}
