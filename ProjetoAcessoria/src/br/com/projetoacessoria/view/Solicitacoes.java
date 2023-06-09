package br.com.projetoacessoria.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

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
import javax.swing.text.MaskFormatter;

import br.com.projetoacessoria.dao.CRUDChamado;
import br.com.projetoacessoria.domain.Chamado;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;

public class Solicitacoes extends JFrame {

	private JPanel contentPane;
	CRUDChamado cc = new CRUDChamado();
	MaskFormatter ds;
	private JTextField txtDepartamento;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblDepartamento;
	private JTextArea txtDescricao;
	private JLabel lblRealizarChamado;
	private JLabel lblNewLabel;
	private JFormattedTextField txtDataSolicitacao;
	
	

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
		try {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Solicitacoes.class.getResource("/br/com/projetoacessoria/image/zap.png")));
		setTitle("Suporte");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 210, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Insira seu nome:");
		lblNome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblNome.setBounds(27, 73, 151, 32);
		contentPane.add(lblNome);
		
		lblDescricao = new JLabel("Fale seu problema:");
		lblDescricao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDescricao.setBounds(27, 262, 251, 32);
		contentPane.add(lblDescricao);
		
		lblDepartamento = new JLabel("Informe o departamento:");
		lblDepartamento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDepartamento.setBounds(27, 160, 304, 32);
		contentPane.add(lblDepartamento);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 305, 518, 177);
		contentPane.add(scrollPane);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scrollPane.setViewportView(txtDescricao);
	
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(27, 189, 519, 44);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(27, 105, 263, 44);
		contentPane.add(txtNome);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 493, 338, 77);
		contentPane.add(panel);
		
		lblRealizarChamado = new JLabel("Registrar Chamado");
		panel.add(lblRealizarChamado);
		lblRealizarChamado.setBackground(new Color(255, 255, 255));
		lblRealizarChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado soliChamado = new Chamado();
				
				if(txtNome.getText().trim().equals("") || txtDepartamento.getText().trim().equals("") || txtDescricao.getText().trim().equals("") || txtDataSolicitacao.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro na solicitação" , JOptionPane.ERROR_MESSAGE);
				}
				else {
					soliChamado.setSolicitacao(txtNome.getText());
					soliChamado.setDepSolicitado(txtDepartamento.getText());
					soliChamado.setDescChamado(txtDescricao.getText());
					soliChamado.setDataAbertura(Date.valueOf(txtDataSolicitacao.getText()));
					
					JOptionPane.showMessageDialog(null, cc.registrar(soliChamado));
					
					limparCampos();
				}
			}
		});
		lblRealizarChamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarChamado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));
		
		lblNewLabel = new JLabel("Bem vindo ao suporte vitual do Whatsapp");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 23, 519, 39);
		contentPane.add(lblNewLabel);
		
		ds = new MaskFormatter("####-##-##");
		ds.setPlaceholderCharacter('_');
		
		txtDataSolicitacao = new JFormattedTextField(ds);
		txtDataSolicitacao.setBounds(312, 105, 234, 44);
		contentPane.add(txtDataSolicitacao);
		
		JLabel lblDataDeSolicitao = new JLabel("Data de Solicitação:");
		lblDataDeSolicitao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDataDeSolicitao.setBounds(312, 73, 151, 32);
		contentPane.add(lblDataDeSolicitao);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void limparCampos() {
		txtNome.setText("");
		txtDepartamento.setText("");
		txtDescricao.setText("");
		txtDataSolicitacao.setText("");
	}
}

