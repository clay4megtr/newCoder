package org.clay.Chap8;

public class Swap {
	public void swap(int a, int b){
		//a = a0,   b = b0,  
		a = a^b;		//  a = a0^b0,  b = b0
		b = a^b;		//	a = a0^b0,	b = a0^b0^b0=a0
		a = a^b;		//	a = a0^b0^a0=b0,  b = a0
	}
}
