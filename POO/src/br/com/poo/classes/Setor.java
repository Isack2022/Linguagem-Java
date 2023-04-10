package br.com.poo.classes;

import javax.swing.JOptionPane;

import br.com.poo.interfaces.Acoes;

public class Setor implements Acoes{

	@Override
	public void mensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Setor",JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public String salvar() {
		return "Você está salvando um novo Setor";
	}

	
	//Não pode deletar, pois está no contrato 
	@Override
	public double soma(double[] valores) {
		// TODO Auto-generated method stub
		return 0;
	}

}
