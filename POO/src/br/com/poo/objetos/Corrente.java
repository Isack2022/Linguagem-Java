package br.com.poo.objetos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.classes.heranca.ContaCorrente;
import java.awt.Toolkit;

public class Corrente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtNumeroConta;
	private JTextField txtAgencia;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtLimite;
	private ContaCorrente corrente;

	/**
	 * Create the frame.
	 */
	public Corrente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Corrente.class.getResource("/br/com/poo/imagens/itau-logo-2.png")));
		 
		corrente = new ContaCorrente();
		
		setTitle("Itaú- Conta Corrente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(228, 228, 228));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(255, 128, 64));
		pnlMenu.setBounds(0, 0, 200, 591);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JLabel lblItau = new JLabel("Itaú");
		lblItau.setForeground(new Color(255, 219, 91));
		lblItau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblItau.setBounds(10, 46, 180, 31);
		pnlMenu.add(lblItau);
		
		JLabel lblAbrirConta = new JLabel("Abrir Conta");
		lblAbrirConta.setForeground(new Color(255, 219, 91));
		lblAbrirConta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAbrirConta.setBounds(10, 165, 180, 31);
		pnlMenu.add(lblAbrirConta);
		
		JLabel lblVerificarSaldo = new JLabel("Verificar Saldo");
		lblVerificarSaldo.setEnabled(false);
		lblVerificarSaldo.setForeground(new Color(255, 219, 91));
		lblVerificarSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVerificarSaldo.setBounds(10, 240, 180, 31);
		pnlMenu.add(lblVerificarSaldo);
		
		JLabel lblDepositar = new JLabel("Depositar");
		lblDepositar.setEnabled(false);
		lblDepositar.setForeground(new Color(255, 219, 91));
		lblDepositar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepositar.setBounds(10, 315, 180, 31);
		pnlMenu.add(lblDepositar);
		
		JLabel lblSacar = new JLabel("Sacar");
		lblSacar.setEnabled(false);
		lblSacar.setForeground(new Color(255, 219, 91));
		lblSacar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSacar.setBounds(10, 390, 180, 31);
		pnlMenu.add(lblSacar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(210, 11, 370, 569);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroBanco = new JLabel("Número do Banco:");
		lblNumeroBanco.setForeground(new Color(43, 75, 108));
		lblNumeroBanco.setBackground(Color.WHITE);
		lblNumeroBanco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroBanco.setBounds(10, 49, 350, 30);
		panel.add(lblNumeroBanco);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setBounds(10, 90, 350, 30);
		panel.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(10, 172, 350, 30);
		panel.add(txtNumeroConta);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setForeground(new Color(43, 75, 108));
		lblNumeroConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroConta.setBackground(Color.WHITE);
		lblNumeroConta.setBounds(10, 131, 350, 30);
		panel.add(lblNumeroConta);
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(10, 254, 350, 30);
		panel.add(txtAgencia);
		
		JLabel lblAgencia = new JLabel("Agência:");
		lblAgencia.setForeground(new Color(43, 75, 108));
		lblAgencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAgencia.setBackground(Color.WHITE);
		lblAgencia.setBounds(10, 213, 350, 30);
		panel.add(lblAgencia);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		txtTitular.setBounds(10, 336, 350, 30);
		panel.add(txtTitular);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setForeground(new Color(43, 75, 108));
		lblTitular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitular.setBackground(Color.WHITE);
		lblTitular.setBounds(10, 295, 350, 30);
		panel.add(lblTitular);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(10, 418, 350, 30);
		panel.add(txtSaldo);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setForeground(new Color(43, 75, 108));
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSaldo.setBackground(Color.WHITE);
		lblSaldo.setBounds(10, 377, 350, 30);
		panel.add(lblSaldo);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(10, 500, 350, 30);
		panel.add(txtLimite);
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setForeground(new Color(43, 75, 108));
		lblLimite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLimite.setBackground(Color.WHITE);
		lblLimite.setBounds(10, 459, 350, 30);
		panel.add(lblLimite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(590, 11, 384, 569);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		
		
		// Comandos para os botões
		lblAbrirConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtNumeroBanco.getText().trim().equals("") || txtAgencia.getText().trim().equals("") || 
				   txtNumeroConta.getText().trim().equals("") || txtTitular.getText().trim().equals("") ||
				   txtSaldo.getText().trim().equals("") || txtLimite.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				else {
					corrente.setNumeroBanco(Long.parseLong(txtNumeroBanco.getText()));
					corrente.setAgencia(Integer.parseInt(txtAgencia.getText()));
					corrente.setNumeroConta(Long.parseLong(txtNumeroConta.getText()));
					corrente.setTitular(txtTitular.getText());
					corrente.setSaldo(Double.parseDouble(txtSaldo.getText()));
					corrente.setLimite(Double.parseDouble(txtLimite.getText()));
					
					//Habilitar os botões de saque, saldo e deposito
					lblVerificarSaldo.setEnabled(true);
					lblDepositar.setEnabled(true);
					lblSacar.setEnabled(true);
					
					//Desabilitar as caixas com os dados da conta
					txtNumeroBanco.setEnabled(false);
					txtAgencia.setEnabled(false);
					txtNumeroConta.setEnabled(false);
					txtTitular.setEnabled(false);
					txtSaldo.setEnabled(false);
					txtLimite.setEnabled(false);
					txtResultado.setText("Conta aberta com sucesso. Bem vindo(a) ao Itaú!");
				}
				
			}
			
		});
		
		lblVerificarSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtResultado.setText(txtResultado.getText() + "\n\n" + corrente.verificarSaldo());
			}
		});
		
		lblDepositar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do depósito");
				txtResultado.setText(txtResultado.getText() + "\n\n" + corrente.depositar(Double.parseDouble(valor)));
			}
		});
		
		lblSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do Saque");
				txtResultado.setText(txtResultado.getText() + "\n\n" + corrente.sacar(Double.parseDouble(valor)));
			}
		});
		
		
	}
}
