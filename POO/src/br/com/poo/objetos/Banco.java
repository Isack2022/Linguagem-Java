package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Banco extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banco frame = new Banco();
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
	public Banco() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Banco.class.getResource("/br/com/poo/imagens/itau-logo-2.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 128, 7));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPoupanca = new JButton("Poupança");
		btnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Poupanca jp = new Poupanca();
				jp.setVisible(true);
			}
		});
		btnPoupanca.setForeground(new Color(255, 255, 0));
		btnPoupanca.setBackground(new Color(11, 62, 150));
		btnPoupanca.setBounds(380, 212, 181, 79);
		contentPane.add(btnPoupanca);
		
		JButton btnCorrente = new JButton("Corrente");
		btnCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Corrente jp = new Corrente();
				jp.setVisible(true);
			}
		});
		btnCorrente.setForeground(new Color(255, 255, 0));
		btnCorrente.setBackground(new Color(11, 62, 150));
		btnCorrente.setBounds(56, 212, 181, 79);
		contentPane.add(btnCorrente);
		
		JLabel lblItau = new JLabel("");
		lblItau.setIcon(new ImageIcon(Banco.class.getResource("/br/com/poo/imagens/itau.png")));
		lblItau.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
		lblItau.setForeground(new Color(255, 255, 0));
		lblItau.setBounds(222, 11, 157, 147);
		contentPane.add(lblItau);
	}
}
