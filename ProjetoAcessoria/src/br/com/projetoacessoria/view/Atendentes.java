package br.com.projetoacessoria.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projetoacessoria.dao.CRUDChamado;
import br.com.projetoacessoria.domain.Chamado;
import br.com.projetoacessoria.util.AcessoSSH;

public class Atendentes extends JFrame {

	private JPanel contentPane;
	CRUDChamado cc = new CRUDChamado();
	MaskFormatter dr;
	private JTable table;
	private JTextField txtObservacoes;
	private JTextField txtId;
	private JTextField txtStatus;
	private JTextField txtResponsavel;
	private JFormattedTextField txtDataResolucao;
	private JLabel lblExcluir;
	private JLabel lblAtualizar;
	private JLabel lblObservacoes;
	private JLabel lblResponsavel;
	private JLabel lblDataResolucao;
	private JLabel lblStatus;
	private JLabel lblId;
	private Long id = null;
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atendentes frame = new Atendentes();
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
	public Atendentes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Atendentes.class.getResource("/br/com/projetoacessoria/image/zap.png")));
		try {
			setTitle("Suporte");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 833, 625);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 210, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			carregarTabela();
			
			lblId = new JLabel("ID:");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			lblId.setBounds(28, 109, 40, 40);
			contentPane.add(lblId);
			
			lblStatus = new JLabel("Status:");
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			lblStatus.setBounds(349, 109, 69, 40);
			contentPane.add(lblStatus);
			
			lblDataResolucao = new JLabel("Data de resolução do Chamado:");
			lblDataResolucao.setHorizontalAlignment(SwingConstants.CENTER);
			lblDataResolucao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			lblDataResolucao.setBounds(34, 179, 246, 40);
			contentPane.add(lblDataResolucao);
			
			lblResponsavel = new JLabel("Funcionário:");
			lblResponsavel.setHorizontalAlignment(SwingConstants.CENTER);
			lblResponsavel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			lblResponsavel.setBounds(333, 179, 146, 40);
			contentPane.add(lblResponsavel);
			
			lblObservacoes = new JLabel("Observações:");
			lblObservacoes.setHorizontalAlignment(SwingConstants.CENTER);
			lblObservacoes.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			lblObservacoes.setBounds(28, 258, 124, 40);
			contentPane.add(lblObservacoes);

			
			
			txtObservacoes = new JTextField();
			txtObservacoes.setBounds(38, 293, 773, 45);
			contentPane.add(txtObservacoes);
			txtObservacoes.setColumns(10);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(34, 144, 289, 40);
			contentPane.add(txtId);
			
			txtStatus = new JTextField();
			txtStatus.setColumns(10);
			txtStatus.setBounds(354, 144, 457, 34);
			contentPane.add(txtStatus);
			
			txtResponsavel = new JTextField();
			txtResponsavel.setColumns(10);
			txtResponsavel.setBounds(354, 210, 453, 40);
			contentPane.add(txtResponsavel);
			
			dr = new MaskFormatter("####-##-##");
			dr.setPlaceholderCharacter('_');
			
			txtDataResolucao = new JFormattedTextField(dr);
			txtDataResolucao.setBounds(34, 210, 289, 40);
			contentPane.add(txtDataResolucao);
			
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(645, 452, 166, 40);
			contentPane.add(panel);
			
			lblExcluir = new JLabel("Excluir Chamados");
			panel.add(lblExcluir);
			lblExcluir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(id.equals(null)) {
						JOptionPane.showMessageDialog(null,"Selecione o chamado a ser excluído.","Erro 4000770x" ,JOptionPane.ERROR_MESSAGE);
					}
					else {
						if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "
								+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == 0                                                                      ) {
							
							Chamado cr = new Chamado();
							cr.setIdChamado(id);
							JOptionPane.showConfirmDialog(null, cc.apagar(cr));
							carregarTabela();
							limparCampos();
						}
					}
				}
			});
			lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
			lblExcluir.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
			
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(645, 401, 162, 40);
			contentPane.add(panel_1);
			
			
			lblAtualizar = new JLabel("Atualizar Chamados");
			panel_1.add(lblAtualizar);
			lblAtualizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Chamado rChamado = new Chamado();
					
					if(txtResponsavel.getText().trim().equals("") || txtStatus.getText().trim().equals("") || txtId.getText().trim().equals("") 
							|| txtDataResolucao.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos",
								"Erro 202363XXc" , JOptionPane.ERROR_MESSAGE);
					}
					else {
						rChamado.setAtendente(txtResponsavel.getText());
						rChamado.setStatusChamado(txtStatus.getText());
						rChamado.setDataResolucao(Date.valueOf(txtDataResolucao.getText()));
						rChamado.setObservacoes(txtObservacoes.getText());
						rChamado.setIdChamado(id);
						
						JOptionPane.showMessageDialog(null, cc.atualizar(rChamado));
						carregarTabela();
						limparCampos();
					}
				}
			});
			lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
			lblAtualizar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
			
			JLabel lblNewLabel = new JLabel("Parte administrativa - Whatsapp");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
			lblNewLabel.setBounds(34, 58, 773, 40);
			contentPane.add(lblNewLabel);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(645, 503, 166, 40);
			contentPane.add(panel_2);
			
			JLabel lblGrafico = new JLabel("Gráfico");
			lblGrafico.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AcessoSSH shh = new AcessoSSH();
					shh.executar();
				}
			});
			lblGrafico.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrafico.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
			panel_2.add(lblGrafico);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void carregarTabela() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 349, 601, 226);
		contentPane.add(scrollPane);
		
		String[] cabecalho = {
				"Id Chamado",
				"Solicitação",
				"Departamento",
				"Descrição",
				"Data de Abertura"
			};
		Object[][] dados = new Object[cc.listar().size()][5];
		for(int i = 0 ; i < dados.length ; i++) {
			dados[i][0] = cc.listar().get(i).getIdChamado();
			dados[i][1] = cc.listar().get(i).getSolicitacao();
			dados[i][2] = cc.listar().get(i).getDepSolicitado();
			dados[i][3] = cc.listar().get(i).getDescChamado();
			dados[i][4] = cc.listar().get(i).getDataAbertura();
		}
		
		DefaultTableModel model = new DefaultTableModel(dados,cabecalho);
		JTable table = new JTable(model);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
				txtId.setText(String.valueOf(id));
			}
		});
		
		table.setForeground(SystemColor.desktop);
		table.setBackground(SystemColor.control);
		scrollPane.setViewportView(table);
	}
	private void limparCampos() {
		txtResponsavel.setText("");
		txtDataResolucao.setText("");
		txtStatus.setText("");
		txtId.setText("");
		txtObservacoes.setText("");
	}
}
