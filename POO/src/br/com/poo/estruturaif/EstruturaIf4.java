package br.com.poo.estruturaif;

import java.util.Scanner;

public class EstruturaIf4 {

	public static void main(String[] args) {
		double salario, resultado;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o salário do funcionário");
		salario = entrada.nextDouble();
		
		if(salario <= 1302) {
			resultado = salario * (7.5 /100);
		}
		else if(salario <= 2571.29) {
			resultado = salario * (9.0/100);
		}
		else if(salario <= 3856.94) {
			resultado = salario * (12.0/100);
		}
		else if(salario <= 7507.49) {
			resultado = salario * (14.0/100);
		}
		else {
			resultado = 7507.49 * (14.0/100);
		}
		
		System.out.println("O desconto do INSS para o seu salário é "+resultado);
	}
}
