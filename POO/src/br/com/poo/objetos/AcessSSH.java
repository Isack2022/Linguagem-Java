package br.com.poo.objetos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/*
 * Este arquuivo de java realiza um acesso via SSH em um servidor linux(Fedora Server)
 * para realizar está operação foi necessario a utilização de uma biblioteca chamanda 
 * JSCH(Java Security Channel). Está biblioteca foi abaixada do site http://www.jcraft.com/jsch
 */


import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class AcessSSH {

	/*
	 * Para acesso a máquina remote(linha) foi definido como constante
	 * os seguintes abaixo
	 */
	private static final String REMOTE_HOST = "127.0.0.1";
	private static final String REMOTE_USER = "senac";
	private static final String REMOTE_PASSWORD = "senac@123";
	private static final int REMOTE_PORT = 2222;
	private static final int SESSION_TIMEOUT = 10000;
	private static final int CHANNEL_TIMEOUT = 10000;
	
	/*
	 * Para a sessão e o canal(Channel) foi definido um tempo de execução de 1000
	 * milisegundos, ou seja 10 segudos
	 */
	
	public static void main(String[] args) {
		//O comando que serpa executado remotamente no servidor
		String comando = "python3 /home/senac/python/populacao.py";
		//Tipando a variável sessão para abrir a sessão ssh com o servidor linux
		Session sessao = null;
		try {
			/*
			 * Criação do objeto config para criar as configurações de acesso no servidor 
			 */
			Properties config = new Properties();
			
			/*
			 * Foi setado a configuração restrita para checagem da chave de criptografia
			 * como no(não) isso faz com que não haja a verificação da chave criptografia 
			 * muito usando quando não se tem a chave.
			 */
			config.put("StrictHostKeyChecking", "no");
			
			//Criando o objeto JSCH(Java Security Channel)
			JSch jsch = new JSch();
			
			//Setar o arquivo que contem a chave de criptografia para o acesso SSH
			jsch.setKnownHosts("/home/senac/.ssh/nome_arquivo_chave");
			
			/*
			 * Comando para abrir a sessão remota com servidor linux. Foram asssados
			 * Nome Usuário,Ip do servidor e porta de comunicação nesta ordem 
			 */
			sessao = jsch.getSession(REMOTE_USER, REMOTE_HOST,REMOTE_PORT);
			
			//Setando a senha do servidor remoto
			sessao.setPassword(REMOTE_PASSWORD);
			
			/*
			 * Foi setado a configuração para a sesão não verificar a existência da chave 
			 * de acesso
			 */
			sessao.setConfig(config);
			
			//Passando o tempo de execução de sessão
			sessao.connect(SESSION_TIMEOUT);
			
			/*
			 * Criando o elemento que representa o canal de execussão de comandos. O omando
			 * sesao.openChannel, nos diz que quando a sessão for aberta também será aberta
			 * um canal para passagem dos comando que será executados(exec) no servdor 
			 */
			ChannelExec channelExec = (ChannelExec) sessao.openChannel("exec");
			
			/*
			 * O comando channelExec.setCommmad aponta o comando deve ser executado no servidor 
			 * remoto. Este comando foi definido na declaração de variável String comando
			 */
			channelExec.setCommand(comando);
			
			//Quando há algum error nesperado na execução do chanellExec será exibindo no sysourt
			channelExec.setErrStream(System.err);
			
			/*
			 * O comando InputStream uma entrada por meio do canal criado. Também permite
			 * obter os dados que estão entrado no canal como comando getInputStream()
			 */
			InputStream in = channelExec.getInputStream();
			
			/*
			 * Estabelece a conexão com o canal e passa o tempo em que o canal fica aberto para passagem
			 * de dados
			 */
			channelExec.connect(CHANNEL_TIMEOUT);
			
			/*
			 * Os dados serão passados recebidos por bytes e não diretamente como String ou números(inteiros,reais)
			 * para que está ação seja feita, criamos uma array de bytes para realizar a transação
			 */
			byte[] tmp = new byte[1024];
			/*
			 * Enquato for possíve executar ao lço (wilhe(true)) ele deve verificar se há dados em in, portanto
			 * temos o comando in.available(disponível) se é maior que 0. Sendo positivo ele deve executar
			 * todas as linhas disponíveis que retotrnaram. Se o retorno dados resultou em mais linhas maiores
			 * que 0(zero), está linhas deveram ser apresentadas no terminal. O uso do cmando new String(tmp,0,i)
			 * faz a conversão de bytes que etão vindo como resposta e a variável i contya a quantidades de linhas
			 * que retorna.
			 */
			while(true) {
				while(in.available()>0) {
					int i = in.read(tmp,0,1024);
					if( i < 0 ) break;
					System.out.println(new String(tmp,0,i));
				}
				/*
				 * Se o canal fechado, mas mesmo assim tiver dados em in,o laço deve continuar, ou seja, volta ao inicio e
				 * executa tudo outra vez. Caso não haja mais nada a ser exibido em tela, o canal é fechado e é exibida 
				 * a mensagem do canal fechado
				 */
				if(channelExec.isClosed()) {
					if(in.available() > 0) continue;
					System.out.println("Saída do processo "
										+channelExec.getExitStatus());
					break;
				}
				try {
					//Demora 1 segundo e repete o laço outra vez até o canal ser desconectado
					Thread.sleep(1000);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
			Process pr = Runtime.getRuntime().exec("c:\\program files\\google\\chrome\\application\\chrome.exe http://127.0.0.1:7557/grafico.html");
			BufferedReader leitor = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String rs = "";
			while((rs = leitor.readLine())!=null) {
				System.out.print(rs);
			}
			
			//Desconectar o canal
			channelExec.disconnect();
		}
			catch(JSchException jsex) {
				jsex.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			if(sessao != null) {
				sessao.disconnect(); // Desconectar o canal
			}
				
		}
		
	}

}
