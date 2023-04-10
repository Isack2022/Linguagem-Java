package br.com.poo.salarioif;

import java.util.Scanner;

public class salarioif {
	
	public static void main(String[] args) {
		double salario,desconto;
		Scanner entrada = new Scanner(System.in);
		System.out.println("================ Sistema de Salarios ================");
		
		System.out.println("\nDigite o salário de um funcionário:");
		salario = entrada.nextDouble();
		
		if(salario <= 1302) {
			desconto = salario * (7.5/100);
			
		}
		else if(salario <= 2571.29) {
			desconto = salario * (9/100);
			
		}
		else if( salario <= 3856.94) {
			desconto = salario * (12/100);
			
		}
		else if(salario <= 7507.49) {
			desconto = salario * (14/100);
			
		}
		else {
			desconto = 7507.49 * (14/100);
			
		}
		System.out.println("O salário com INSS ficou com desconto de: "+desconto);
	}
	
}