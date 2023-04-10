package br.com.projetoacessoria.view;

import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.projetoacessoria.dao.CRUDChamado;
import br.com.projetoacessoria.domain.Chamado;
import java.awt.Color;
import java.awt.Toolkit;

public class Solicitacoes extends JFrame {

	private JPanel contentPane;
	CRUDChamado cc = new CRUDChamado();
	
	private JTextField txtDepartamento;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblDepartamento;
	private JTextArea txtDescricao;
	private JLabel lblRealizarChamado;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solicitacoes frame = new Solicitacoes();
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
	public Solicitacoes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Solicitacoes.class.getResource("/br/com/projetoacessoria/image/zap.png")));
		setTitle("Suporte");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Insira seu nome:");
		lblNome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNome.setBounds(51, 60, 151, 32);
		contentPane.add(lblNome);
		
		lblDescricao = new JLabel("Fale seu problema:");
		lblDescricao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblDescricao.setBounds(51, 225, 251, 32);
		contentPane.add(lblDescricao);
		
		lblDepartamento = new JLabel("Informe o departamento:");
		lblDepartamento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblDepartamento.setBounds(51, 139, 304, 32);
		contentPane.add(lblDepartamento);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 257, 495, 199);
		contentPane.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
	
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(51, 182, 304, 32);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(51, 103, 304, 32);
		contentPane.add(txtNome);
		
		JPanel panel = new JPanel();
		panel.setBounds(145, 513, 273, 57);
		contentPane.add(panel);
		
		lblRealizarChamado = new JLabel("Registrar Chamado");
		panel.add(lblRealizarChamado);
		lblRealizarChamado.setBackground(new Color(255, 255, 255));
		lblRealizarChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado soliChamado = new Chamado();
				
				if(txtNome.getText().trim().equals("") || txtDepartamento.getText().trim().equals("") || txtDescricao.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro na solicitação" , JOptionPane.ERROR_MESSAGE);
				}
				else {
					soliChamado.setSolicitacao(txtNome.getText());
					soliChamado.setDepSolicitado(txtDepartamento.getText());
					soliChamado.setDescChamado(txtDescricao.getText());
					
					JOptionPane.showMessageDialog(null, cc.registrar(soliChamado));
					
					limparCampos();
				}
			}
		});
		lblRealizarChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarChamado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 30));
		
		
	}
	private void limparCampos() {
		txtNome.setText("");
		txtDepartamento.setText("");
		txtDescricao.setText("");
	}
}
