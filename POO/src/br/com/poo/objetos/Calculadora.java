package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JButton btnMutiplicacao;
	private JButton btnAdicao;
	private JButton btnDivisao;
	private JButton bntSubtracao;
	private JButton btnApagar;
	private JButton btnResultado;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private String resultado;
	private JTextField txtResultado;
	private double valor1;
	private double valor2;
	private String operacao;
	private double valorFinal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		
		
		resultado = "0";
		operacao = "";
		valor1 = 0.0;
		valor1 = 0.0;
		valorFinal = 0.0;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculadora.class.getResource("/br/com/poo/imagens/Dtafalonso-Android-L-Calculator.512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setText(resultado);
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 55));
		txtResultado.setForeground(new Color(255, 255, 255));
		txtResultado.setBackground(new Color(0, 0, 0));
		txtResultado.setBounds(22, 11, 409, 87);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		txtResultado.setBorder(null);
		
		btnMutiplicacao = new JButton("X");
		btnMutiplicacao.setBackground(new Color(255, 255, 255));
		btnMutiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao = "*";
				valor1 = Double.parseDouble(txtResultado.getText());
				resultado = "";
				txtResultado.setText(resultado);
				
				
			}
		});
		btnMutiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnMutiplicacao.setBounds(244, 122, 89, 61);
		contentPane.add(btnMutiplicacao);
		
		btnAdicao = new JButton("+");
		btnAdicao.setBackground(new Color(255, 255, 255));
		btnAdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					operacao = "+";
					valor1 = Double.parseDouble(txtResultado.getText());
					resultado = "";
					txtResultado.setText(resultado);
					
					
			}
		});
		btnAdicao.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnAdicao.setBounds(343, 122, 89, 61);
		contentPane.add(btnAdicao);
		
		bntSubtracao = new JButton("-");
		bntSubtracao.setBackground(new Color(255, 255, 255));
		bntSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao = "-";
				valor1 = Double.parseDouble(txtResultado.getText());
				resultado = "";
				txtResultado.setText(resultado);
				
				
			}
		});
		bntSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 55));
		bntSubtracao.setBounds(343, 188, 89, 61);
		contentPane.add(bntSubtracao);
		
		btnDivisao = new JButton("÷");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacao = "/";
				valor1 = Double.parseDouble(txtResultado.getText());
				resultado = "";
				txtResultado.setText(resultado);
				
			}
		});
		btnDivisao.setBackground(new Color(255, 255, 255));
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnDivisao.setBounds(132, 122, 89, 61);
		contentPane.add(btnDivisao);
		
		btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 255, 255));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "7";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "7";
					txtResultado.setText(resultado);
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn7.setBounds(22, 188, 89, 61);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 255, 255));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "8";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "8";
					txtResultado.setText(resultado);
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn8.setBounds(132, 188, 89, 61);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(new Color(255, 255, 255));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "9";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "9";
					txtResultado.setText(resultado);
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn9.setBounds(241, 191, 89, 61);
		contentPane.add(btn9);
		
		btn4 = new JButton("4");
		btn4.setBackground(new Color(255, 255, 255));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "4";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "4";
					txtResultado.setText(resultado);
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn4.setBounds(22, 260, 89, 61);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(new Color(255, 255, 255));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "5";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "5";
					txtResultado.setText(resultado);
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn5.setBounds(132, 260, 89, 61);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(new Color(255, 255, 255));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "6";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "6";
					txtResultado.setText(resultado);
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn6.setBounds(241, 260, 89, 61);
		contentPane.add(btn6);
		
		btn1 = new JButton("1");
		btn1.setBackground(new Color(255, 255, 255));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "1";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "1";
					txtResultado.setText(resultado);
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn1.setBounds(22, 332, 89, 61);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(new Color(255, 255, 255));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "2";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "2";
					txtResultado.setText(resultado);
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn2.setBounds(132, 332, 89, 61);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBackground(new Color(255, 255, 255));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "3";
					txtResultado.setText(resultado);
				}
				else {
					resultado += "3";
					txtResultado.setText(resultado);
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn3.setBounds(241, 332, 89, 61);
		contentPane.add(btn3);
		
		btn0 = new JButton("0");	
		btn0.setBackground(new Color(255, 255, 255));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtResultado.getText().equals("0")) {
					resultado = "0";
					txtResultado.setText("0");
				}
				else {
					resultado += "0";
					txtResultado.setText(resultado);
				}
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btn0.setBounds(132, 404, 89, 78);
		contentPane.add(btn0);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 109, 463, 2);
		contentPane.add(separator);
		
		btnApagar = new JButton("C");
		btnApagar.setBackground(new Color(255, 255, 255));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText("0");
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnApagar.setBounds(22, 119, 89, 61);
		contentPane.add(btnApagar);
		
		btnResultado = new JButton("=");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(operacao) {
				case "-":
					valor2 = Double.parseDouble(txtResultado.getText());
					valorFinal= (valor1 - valor2);
					txtResultado.setText(""+valorFinal);
					break;
				case "+":
					valor2 = Double.parseDouble(txtResultado.getText());
					valorFinal= (valor1 + valor2);
					txtResultado.setText(""+valorFinal);
					break;
				case "/":
					valor2 = Double.parseDouble(txtResultado.getText());
					valorFinal= (valor1 / valor2);
					txtResultado.setText(""+valorFinal);
					break;
				case "*":
					valor2 = Double.parseDouble(txtResultado.getText());
					valorFinal= (valor1 * valor2);
					txtResultado.setText(""+valorFinal);
					break;
				}
				
			}
		});
		btnResultado.setBackground(new Color(0, 255, 255));
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnResultado.setBounds(343, 260, 89, 222);
		contentPane.add(btnResultado);
		
	
		
	}
}
