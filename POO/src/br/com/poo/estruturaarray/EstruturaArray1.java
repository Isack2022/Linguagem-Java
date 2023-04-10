package br.com.poo.estruturaarray;

public class EstruturaArray1 {

	public static void main(String[] args) {
		
		String[] cidades = {"Leme","Campinas","Atibaia","Vinhedo"};
		
		System.out.println(cidades[1]);
		
		for(int i = 0 ; i < cidades.length ; i++) {
			System.out.println(cidades[i]);
		}
		
		System.out.println(cidades.length);

	}

}
