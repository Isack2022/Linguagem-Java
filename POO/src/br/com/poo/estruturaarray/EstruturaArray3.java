package br.com.poo.estruturaarray;

public class EstruturaArray3 {

	public static void main(String[] args) {
		
		int[] v1 = {12,3,25,16,28,10,11,37};
		int[] v2 = {81,23,12,10,22,3,45,19,31,100,29};
		
		for(int i = 0; i < v1.length ; i++) {
			for(int j = 0; j < v2.length; j++) {
				if(v1[i]==v2[j]) {
					System.out.println(v1[i]);
					break;
				}
			}
		}
		

	}

}
