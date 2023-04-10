package br.com.projetoacessoria.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.ImageIcon;
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
import java.awt.Color;
import java.awt.Toolkit;

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
			setBounds(100, 100, 737, 571);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 255, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			carregarTabela();
			
			lblId = new JLabel("Id:");
			lblId.setHorizontalAlignment(SwingConstants.CENTER);
			lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
			lblId.setBounds(34, 21, 40, 40);
			contentPane.add(lblId);
			
			lblStatus = new JLabel("Status:");
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
			lblStatus.setBounds(285, 21, 69, 40);
			contentPane.add(lblStatus);
			
			lblDataResolucao = new JLabel("Data de resolução do Chamado:");
			lblDataResolucao.setHorizontalAlignment(SwingConstants.CENTER);
			lblDataResolucao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
			lblDataResolucao.setBounds(34, 104, 191, 40);
			contentPane.add(lblDataResolucao);
			
			lblResponsavel = new JLabel("Funcionário:");
			lblResponsavel.setHorizontalAlignment(SwingConstants.CENTER);
			lblResponsavel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
			lblResponsavel.setBounds(285, 104, 90, 40);
			contentPane.add(lblResponsavel);
			
			lblObservacoes = new JLabel("Observações:");
			lblObservacoes.setHorizontalAlignment(SwingConstants.CENTER);
			lblObservacoes.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
			lblObservacoes.setBounds(34, 179, 90, 40);
			contentPane.add(lblObservacoes);

			
			
			txtObservacoes = new JTextField();
			txtObservacoes.setBounds(41, 230, 508, 45);
			contentPane.add(txtObservacoes);
			txtObservacoes.setColumns(10);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(41, 66, 201, 27);
			contentPane.add(txtId);
			
			txtStatus = new JTextField();
			txtStatus.setColumns(10);
			txtStatus.setBounds(288, 66, 256, 27);
			contentPane.add(txtStatus);
			
			txtResponsavel = new JTextField();
			txtResponsavel.setColumns(10);
			txtResponsavel.setBounds(285, 145, 259, 27);
			contentPane.add(txtResponsavel);
			
			dr = new MaskFormatter("####-##-##");
			dr.setPlaceholderCharacter('_');
			
			txtDataResolucao = new JFormattedTextField(dr);
			txtDataResolucao.setBounds(41, 145, 201, 27);
			contentPane.add(txtDataResolucao);
			
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(554, 442, 149, 34);
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
			lblExcluir.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
			
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(554, 487, 149, 34);
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
								"Erro 4000765x" , JOptionPane.ERROR_MESSAGE);
					}
					else {
						rChamado.setAtendente(txtResponsavel.getText());
						rChamado.setStatusChamado(txtStatus.getText());
						rChamado.setDataResolucao(Date.valueOf(txtDataResolucao.getText()));
						rChamado.setObservacoes(txtObservacoes.getText());
						rChamado.setIdChamado(id);
						
						carregarTabela();
						limparCampos();
					}
				}
			});
			lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
			lblAtualizar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void carregarTabela() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 295, 503, 226);
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
