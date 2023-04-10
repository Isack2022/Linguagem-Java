package br.com.poo.cargosif;

import javax.swing.JOptionPane;

public class Estruturacargo extends JOptionPane {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bem vindo!","Sistema",JOptionPane.INFORMATION_MESSAGE);
		String salario = JOptionPane.showInputDialog("Digite um cargo");
		String rs;
		switch(salario) {
		case "diretor":
			rs = "Salário de 20 mil por mes";
		break;
		case "Gerente":
			rs = "Salário de 15 mil por mes";
		break;
		case "Secretária":
			rs = "Salário de 8 mil por mes";
		break;
		case "Analista":
			rs = "Salário de 7 mil por mes";
		break;
		
		case "Assistente":
			rs = "Salário de 4 mil por mes";
		break;
		
		case "Estagiário":
			rs = "Salário de 1.5 mil por mes";
		break;
		
		
		
		default:
			rs = "Está estação nao existe";
		break;	
			
		}
		JOptionPane.showMessageDialog(null, rs,"Resposta",JOptionPane.INFORMATION_MESSAGE);
	}


	}


