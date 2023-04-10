package br.com.poo.estruturaswitch;

import java.util.Scanner;

public class EstruturaSwitch1 {

	public static void main(String[] args) {
		
		int numSemana;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o número do dia da semana:");
		numSemana = input.nextInt();
		
		switch(numSemana) {
			case 1:
				System.out.println("Domingo");
			break;
			case 2:
				System.out.println("Segunda-Feira");
			break;
			case 3:
				System.out.println("Terça-Feira");
			break;
			case 4:
				System.out.println("Quarta-Feira");
			break;
			case 5:
				System.out.println("Quinta-Feira");
			break;
			case 6:
				System.out.println("Sexta-Feira");
			break;
			case 7:
				System.out.println("Sábado");
			break;
			default:
				System.out.println("Este dia da semana não existe");
			break;		
			
			
		}
		

	}

}
