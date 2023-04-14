package br.com.poo.objetos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Processo {

	public static void main(String[] args) {
		
		try {
			/*
			 * O comando process executa um comando do sistema do operacional,
			 * neste caso o sistema e windoes.
			 * O comando Runtime(tempo de execução) get Runtime(chamar para executar)
			 * são utilizadopara executar um comando do sistema operacional. Este
			 * comando será executado quando a aplicação do java for executada(Runtime).
			 * Abaixo estamos abrindo a calculadora
			 * */
			Process pr = Runtime.getRuntime().exec("c:\\program files\\google\\chrome\\application\\chrome.exe http://127.0.0.1:8888");
			
			/*
			 * O comando BufferedReader(A classe BufferedReader) é um leitor que
			 * trabalha com dados em memoria. Ela é responsavel para ler os dados em memoria
			 * Abaixo e feito um inserção de leitura de dados com comando
			 * InputStreamReader(Inserir um dado de leitura). Neste caso
			 * foi inserido e lido o processo que executa o comando que abre a calculadora
			 * */
			BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			/*
			 * Para exibir as informaçoes retornadas pelo Buffer, podemos usar uma
			 * variavel no formato de String para armazenar estas informações e
			 * depois exibi-las
			 * */
			String rs = "";
			/*
			 * Para pegar todos os dados em memoria e exibir em tela, foi utilizado
			 * o comando while e os dados foram passados para a variavel rs.
			 * Assim foi possivel exibir no console.
			 * */
			while((rs = leitor.readLine())!=null) {
				System.out.print(rs);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
