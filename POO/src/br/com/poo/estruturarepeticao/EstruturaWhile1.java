package br.com.poo.estruturarepeticao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstruturaWhile1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;
	
	String dados = "";
	int i; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
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
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(new Color(184, 188, 5));
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 431);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número Inicial");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 140, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número Final");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 48, 140, 26);
		contentPane.add(lblNewLabel_1);
		
		txtInicial = new JTextField();
		txtInicial.setBounds(119, 16, 128, 20);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(119, 53, 128, 20);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 237, 256);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = Integer.parseInt(txtInicial.getText());
				
				while(i <= Integer.parseInt(txtFinal.getText())) {
					dados += i +"\n";
					i++;
				}
				txtResultado.setText(dados);
				txtInicial.setText("");
				txtFinal.setText("");
				dados = "";
				
			}
		});
		btnExecutar.setBounds(10, 91, 237, 23);
		contentPane.add(btnExecutar);
		
	}
}
