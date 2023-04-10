package br.com.poo.estruturaif;

import java.util.Scanner;

public class EstruturaINSS {
	public static void main(String[] args) {
		double salario;
		Scanner salarioTotal = new Scanner(System.in);
		
		System.out.println("Digite o seu salario:");
		salario = salarioTotal.nextDouble();
		
		if (salario <= 1302) {
			System.out.println("O desconto será de: "+salario*0.075);
		}
		else if (salario <= 2471.29) {
			System.out.println("O desconto será de: "+salario*0.09);
		}
		else if (salario <= 3856.94) {
			System.out.println("O desconto será de: "+salario*0.12);
		}
		else if (salario <= 7507.49) {
			System.out.println("O desconto será de:"+salario*0.14);
		}
		else {
			System.out.println("O desconto será de:" +7507.49 *0.14);
			
		}
	}

}
