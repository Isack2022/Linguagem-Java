package br.comm.projetoescola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projetoescola.dao.CRUDCurso;
import br.com.projetoescola.domain.Curso;

public class GerenciaCurso extends JFrame {

	private JPanel contentPane;
	private Long id = null;
	private JTextField txtTitulo;
	private JTextPane txtDescricao;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataTermino;
	private JFormattedTextField txtHorarioInicial;
	private JFormattedTextField txtHorarioTermino;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnConsultar;
	private JButton btnApagar;
	
	
	private MaskFormatter di;
	private MaskFormatter dt;
	private MaskFormatter hi;
	private MaskFormatter ht;
	
	CRUDCurso cc = new CRUDCurso();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciaCurso frame = new GerenciaCurso();
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
	public GerenciaCurso() {
		try {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciaCurso.class.getResource("/br/com/projetoescola/view/image/senai.png")));
		setTitle("Gerenciamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		carregarTabela();
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(48, 48, 48));
		btnCadastrar.setBounds(517, 273, 375, 178);
		contentPane.add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso cadCurso = new Curso();
				if(txtTitulo.getText().trim().equals("")
					||txtDescricao.getText().trim().equals("")
					||txtDataInicio.getText().trim().equals("")
					||txtDataTermino.getText().trim().equals("")
					||txtHorarioInicial.getText().trim().equals("")
					||txtHorarioTermino.getText().trim().equals("")
					){
					JOptionPane.showMessageDialog(null, "Você deve precisa preencher todos os campos","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadCurso.setTitulo(txtTitulo.getText());
					cadCurso.setDescricao(txtDescricao.getText());
					cadCurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setDatatermino(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setHorarioinicio(txtHorarioInicial.getText());
					cadCurso.setHorariotermino(txtHorarioTermino.getText());
					cadCurso.setIdCurso(id);
					
					JOptionPane.showMessageDialog(null, cc.atualizar(cadCurso).getTitulo()+" Foi atualizado!");
					carregarTabela();
					limparCampos();
				}
				
			}
		});
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnAtualizar.setBackground(Color.BLACK);
		btnAtualizar.setBounds(921, 85, 207, 106);
		contentPane.add(btnAtualizar);
		
		btnConsultar = new JButton("consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnConsultar.setBackground(Color.BLACK);
		btnConsultar.setBounds(921, 214, 207, 107);
		contentPane.add(btnConsultar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione um curso para apagar");
				}
				else {
					if(JOptionPane.showConfirmDialog(null, "Você realente deseja apagar este curso?","ANTEÇÃO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0) {
						
					
					Curso cr = new Curso();
					cr.setIdCurso(id);
					JOptionPane.showMessageDialog(null, cc.apagar(cr));
					carregarTabela();
					limparCampos();
					}
				}
				
				
			}
		});
		btnApagar.setForeground(new Color(255, 255, 255));
		btnApagar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnApagar.setBackground(Color.BLACK);
		btnApagar.setBounds(921, 345, 207, 106);
		contentPane.add(btnApagar);
		
		txtDescricao = new JTextPane();
		txtDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDescricao.setBackground(new Color(250, 250, 250));
		txtDescricao.setBounds(10, 165, 470, 286);
		contentPane.add(txtDescricao);
		txtDescricao.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDescricao.setBounds(10, 131, 97, 23);
		contentPane.add(lblDescricao);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtTitulo.setBackground(Color.WHITE);
		txtTitulo.setBounds(10, 87, 470, 33);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 63, 97, 19);
		contentPane.add(lblTitulo);
		
		JLabel lblDataDeInicio = new JLabel("Data de Inicio:");
		lblDataDeInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDataDeInicio.setBounds(517, 83, 130, 33);
		contentPane.add(lblDataDeInicio);
		
		di = new MaskFormatter("####-##-##");
		di.setPlaceholderCharacter('_');
		
		txtDataInicio = new JFormattedTextField(di);
		txtDataInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDataInicio.setBounds(689, 87, 195, 32);
		contentPane.add(txtDataInicio);
		

		
		JLabel lblDataDeInicio_1 = new JLabel("Data de Termino:");
		lblDataDeInicio_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDataDeInicio_1.setBounds(517, 130, 130, 33);
		contentPane.add(lblDataDeInicio_1);
		
		dt = new MaskFormatter("####-##-##");
		dt.setPlaceholderCharacter('_');
		
		txtDataTermino = new JFormattedTextField(dt);
		txtDataTermino.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtDataTermino.setBounds(689, 131, 195, 32);
		contentPane.add(txtDataTermino);
		
		JLabel lblHorarioInicial = new JLabel("Horario Inicial:");
		lblHorarioInicial.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblHorarioInicial.setBounds(517, 170, 130, 33);
		contentPane.add(lblHorarioInicial);
		
		JLabel lblDataDeInicio_2_1 = new JLabel("Horario Termino:");
		lblDataDeInicio_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDataDeInicio_2_1.setBounds(517, 214, 157, 33);
		contentPane.add(lblDataDeInicio_2_1);
		
		ht = new MaskFormatter("##:##h");
		ht.setPlaceholderCharacter('_');
		
		txtHorarioTermino = new JFormattedTextField(ht);
		txtHorarioTermino.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtHorarioTermino.setBounds(689, 218, 195, 32);
		contentPane.add(txtHorarioTermino);
		
		hi = new MaskFormatter("##:##h");
		hi.setPlaceholderCharacter('_');
		
		txtHorarioInicial = new JFormattedTextField(hi);
		txtHorarioInicial.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtHorarioInicial.setBounds(689, 175, 195, 32);
		contentPane.add(txtHorarioInicial);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GerenciaCurso.class.getResource("/br/com/projetoescola/view/image/linha.png")));
		lblNewLabel.setBounds(0, 0, 1138, 46);
		contentPane.add(lblNewLabel);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso cadCurso = new Curso();
				if(txtTitulo.getText().trim().equals("")
					||txtDescricao.getText().trim().equals("")
					||txtDataInicio.getText().trim().equals("")
					||txtDataTermino.getText().trim().equals("")
					||txtHorarioInicial.getText().trim().equals("")
					||txtHorarioTermino.getText().trim().equals("")
					){
					JOptionPane.showMessageDialog(null, "Existe campo não preenchido","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadCurso.setTitulo(txtTitulo.getText());
					cadCurso.setDescricao(txtDescricao.getText());
					cadCurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setDatatermino(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setHorarioinicio(txtHorarioInicial.getText());
					cadCurso.setHorariotermino(txtHorarioTermino.getText());
					
					JOptionPane.showMessageDialog(null, cc.gravar(cadCurso));
					carregarTabela();
					limparCampos();
				}
			}
		});

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void carregarTabela() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 462, 1118, 236);
		contentPane.add(scrollPane);
		
		String [] cabecalho = {
			"Id Curso",
			"Título do Curso",
			"Descrição do Curso",
			"Data de Início",
			"Data de Término",
			"Horário de Início",
			"Horário de Término"
		};
		
		Object[][] dados = new Object[cc.listar().size()][7];
		
		for(int i = 0; i < dados.length; i++) {
			dados[i][0] =cc.listar().get(i).getIdCurso();
			dados[i][1] =cc.listar().get(i).getTitulo();
			dados[i][2] =cc.listar().get(i).getDescricao();
			dados[i][3] =cc.listar().get(i).getDatainicio();
			dados[i][4] =cc.listar().get(i).getDatatermino();
			dados[i][5] =cc.listar().get(i).getHorarioinicio();
			dados[i][6] =cc.listar().get(i).getHorariotermino();
		}
		
		DefaultTableModel model = new DefaultTableModel(dados,cabecalho);
		
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTitulo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
				txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
				txtDataInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
				txtDataTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
				txtHorarioInicial.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
				txtHorarioTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),6)));
				id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
			}
		});
		scrollPane.setViewportView(table);
	}
	
	private void limparCampos() {
		
		txtTitulo.setText("");
		txtDescricao.setText("");
		txtDataInicio.setText("");
		txtDataTermino.setText("");
		txtHorarioInicial.setText("");
		txtHorarioTermino.setText("");
	}

}
