package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Poupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtAgencia;
	private JTextField txtTitular;
	private JTextField txtNumeroConta;
	private JTextField txtSaldoInicial;
	private JTextField txtRedimento;
	private JTextField txtValorDeposito;
	private JButton btnVerificar;
	private JButton btnDepositar;
	private JButton btnSacar;
	private JLabel lblValorDeDepsito;

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the frame.
	 */
	public Poupanca() {
		setBackground(new Color(248, 128, 7));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Poupanca.class.getResource("/br/com/poo/imagens/itau-logo-2.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 128, 7));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPoupanca = new JLabel("Conta Poupança");
		lblPoupanca.setForeground(new Color(255, 255, 0));
		lblPoupanca.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		lblPoupanca.setBounds(189, 152, 214, 27);
		contentPane.add(lblPoupanca);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Java\\Isack\\POO\\src\\br\\com\\poo\\imagens\\itau-logo-1.png"));
		lblNewLabel_1.setBounds(160, 147, 254, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNumBanco = new JLabel("Número do Banco:");
		lblNumBanco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNumBanco.setBounds(21, 196, 129, 14);
		contentPane.add(lblNumBanco);
		
		JLabel lblNomeDoTitular = new JLabel("Nome do Titular:");
		lblNomeDoTitular.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNomeDoTitular.setBounds(21, 259, 129, 14);
		contentPane.add(lblNomeDoTitular);
		
		JLabel lblAgencia = new JLabel("Agência:");
		lblAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAgencia.setBounds(189, 190, 64, 27);
		contentPane.add(lblAgencia);
		
		JLabel lblNumConta = new JLabel("Número da Conta:");
		lblNumConta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNumConta.setBounds(360, 196, 129, 14);
		contentPane.add(lblNumConta);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSaldoInicial.getText().equals("")||txtSaldoInicial.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o nome Titular!");
					txtSaldoInicial.requestFocus();
				}
			}
		});
		lblSaldoInicial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSaldoInicial.setBounds(21, 322, 129, 14);
		contentPane.add(lblSaldoInicial);
		
		JLabel lblRendimento = new JLabel("Rendimento");
		lblRendimento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRendimento.setBounds(285, 322, 129, 14);
		contentPane.add(lblRendimento);
		
		JTextField txtBanco = new JTextField();
		txtBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtBanco.getText().equals("")||txtBanco.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Número banco obrigatório!");
					txtBanco.requestFocus();
				}
			}
		});
		txtBanco.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtBanco.setBackground(new Color(255, 255, 255));
		txtBanco.setBounds(21, 221, 129, 27);
		contentPane.add(txtBanco);
		txtBanco.setColumns(10);
		
		txtAgencia = new JTextField();
		txtAgencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAgencia.getText().equals("")||txtAgencia.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o Número da Agência!");
					txtAgencia.requestFocus();
				}
			}
		});
		txtAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtAgencia.setColumns(10);
		txtAgencia.setBackground(Color.WHITE);
		txtAgencia.setBounds(189, 221, 141, 27);
		contentPane.add(txtAgencia);
		
		txtTitular = new JTextField();
		txtTitular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitular.getText().equals("")||txtTitular.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o nome Titular!");
					txtTitular.requestFocus();
				}
			}
		});
		txtTitular.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtTitular.setColumns(10);
		txtTitular.setBackground(Color.WHITE);
		txtTitular.setBounds(21, 284, 515, 27);
		contentPane.add(txtTitular);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroConta.getText().equals("")||txtNumeroConta.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o Número da Conta!");
					txtNumeroConta.requestFocus();
				}
			}
		});
		txtNumeroConta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBackground(Color.WHITE);
		txtNumeroConta.setBounds(360, 221, 178, 27);
		contentPane.add(txtNumeroConta);
		
		txtSaldoInicial = new JTextField();
		txtSaldoInicial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSaldoInicial.getText().equals("")||txtSaldoInicial.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o seu saldo inicial");
					txtTitular.requestFocus();
				}
			}
		});
		txtSaldoInicial.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtSaldoInicial.setColumns(10);
		txtSaldoInicial.setBackground(Color.WHITE);
		txtSaldoInicial.setBounds(21, 348, 194, 27);
		contentPane.add(txtSaldoInicial);
		
		txtRedimento = new JTextField();
		txtRedimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRedimento.getText().equals("")||txtRedimento.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Coloque o nome Titular!");
					txtRedimento.requestFocus();
				}
				btnVerificar.setText("Abrir Conta");
				btnVerificar.setEnabled(true);
			}
		});
		txtRedimento.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtRedimento.setColumns(10);
		txtRedimento.setBackground(Color.WHITE);
		txtRedimento.setBounds(285, 348, 263, 27);
		contentPane.add(txtRedimento);
		
		btnVerificar = new JButton("Verificar Saldo");
		
		btnVerificar.setForeground(new Color(255, 255, 0));
		btnVerificar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnVerificar.setBackground(new Color(11, 62, 150));
		btnVerificar.setBounds(21, 413, 194, 92);
		contentPane.add(btnVerificar);
		btnVerificar.setEnabled(false);
		
		btnDepositar = new JButton("Depositar");
		btnDepositar.setForeground(new Color(255, 255, 0));
		btnDepositar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnDepositar.setBackground(new Color(11, 62, 150));
		btnDepositar.setBounds(225, 414, 141, 27);
		contentPane.add(btnDepositar);
		btnDepositar.setEnabled(false);
		
		
		btnSacar = new JButton("Sacar");
		btnSacar.setForeground(new Color(255, 255, 0));
		btnSacar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSacar.setBackground(new Color(11, 62, 150));
		btnSacar.setBounds(225, 478, 141, 27);
		contentPane.add(btnSacar);
		btnSacar.setEnabled(false);
		
		
		txtValorDeposito = new JTextField();
		txtValorDeposito.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtValorDeposito.setColumns(10);
		txtValorDeposito.setBackground(Color.WHITE);
		txtValorDeposito.setBounds(395, 410, 153, 89);
		contentPane.add(txtValorDeposito);
		txtValorDeposito.setEnabled(false);
		
		lblValorDeDepsito = new JLabel("Valor de Depósito:");
		lblValorDeDepsito.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblValorDeDepsito.setBounds(395, 385, 129, 14);
		contentPane.add(lblValorDeDepsito);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Poupanca.class.getResource("/br/com/poo/imagens/itau-logo-2.png")));
		lblNewLabel.setBounds(237, 11, 120, 110);
		contentPane.add(lblNewLabel);
	}

}
