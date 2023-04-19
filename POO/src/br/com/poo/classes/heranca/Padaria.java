package br.com.poo.classes.heranca;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JTextField txtTotalItem;
	private JTextField txtSubtotal;
	private JTextArea txtNota;
	private String cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java\\Isack\\POO\\src\\br\\com\\poo\\imagens\\logopadaria2.jpg"));
		valorPagar = 0.0;
		item = 1;
		cabecalho = "\t\t\tBAKERY PADARIA TRADICIONAL DESDE 1990"+
		"\nPADARIA ATERSANAL"+
		"\n\tAv. CAMPANELLA, 761 - VILA REGINA" +
		"\n\tCEP: 08220-705 - SÃO PAULO - SP" +
		"\nCNPJ: 28.157.953/126-76"+
		"\nIE: 981.124376.9802"+
		"\nIM: 1.534.654/022-0"+
		"\n---------------------------------------------------------------------------------------------------------------------------------------------------"
		+ "---------------------------------------------"+
		"\n\t\t\t\tCUMPOM FISCAL"+
		"\n\nITEM\tCÓDIGO\tDESCRIÇÃO\t\t\tQTD\tVL.UNIT\tVL.TOTAL"+
		"\n---------------------------------------------------------------------------------------------------------------------------------------------------"
		+ "---------------------------------------------"
		;
				
		String[][] produtos = {
				
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","15.00","14032024"},
				{"2025","Torta de Frango","50.00","17032025"},
				{"2026","Leite Integral A","5.00","17032026"},
				{"2027","Manteiga","5.00","17032027"},
				{"2028","Bolo", "20.00","17032028"},
				{"2029","Bauru","12.00","17032029"},
				{"2030","Fanta Uva","14.00","17032030"}
				
				
				
		};
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(new Color(128, 0, 0));
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 300);
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/imagens/logopadaria2.jpg")).getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setForeground(new Color(255, 255, 255));
		lblCodigoProduto.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCodigoProduto.setBounds(10, 311, 186, 33);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setForeground(new Color(255, 255, 255));
		lblCodigoBarras.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCodigoBarras.setBounds(432, 311, 186, 33);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				for(int linha = 0 ; linha <produtos.length ; linha++){
					for(int coluna = 0 ; coluna < produtos[0].length; coluna++) {
						if(txtCodigoProduto.getText().equals(produtos[linha][0])) {
							txtCodigoBarras.setText(produtos[linha][3]);
							txtDescricao.setText(produtos[linha][1]);
							txtValorUnitario.setText(produtos[linha][2]);
							break;
							
						}
					}
					
				}
				
			
				
				
			}
			
		});
		txtCodigoProduto.setFont(new Font("Arial", Font.ITALIC, 20));
		txtCodigoProduto.setForeground(SystemColor.window);
		txtCodigoProduto.setBackground(new Color(128, 0, 0));
		txtCodigoProduto.setBounds(10, 343, 214, 30);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBorder(null);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setForeground(new Color(255, 255, 255));
		txtCodigoBarras.setFont(new Font("Arial", Font.ITALIC, 20));
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBackground(new Color(128, 0, 0));
		txtCodigoBarras.setBounds(432, 343, 214, 30);
		pnlEsquerdo.add(txtCodigoBarras);
		txtCodigoBarras.setBorder(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 384, 780, 2);
		pnlEsquerdo.add(separator);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Arial", Font.ITALIC, 20));
		lblDescricao.setBounds(10, 397, 186, 33);
		pnlEsquerdo.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(Color.WHITE);
		txtDescricao.setFont(new Font("Arial", Font.ITALIC, 20));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(new Color(128, 0, 0));
		txtDescricao.setBounds(10, 429, 780, 30);
		pnlEsquerdo.add(txtDescricao);
		txtDescricao.setBorder(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 469, 780, 2);
		pnlEsquerdo.add(separator_1);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario");
		lblValorUnitario.setForeground(new Color(255, 255, 255));
		lblValorUnitario.setFont(new Font("Arial", Font.ITALIC, 20));
		lblValorUnitario.setBounds(10, 472, 186, 33);
		pnlEsquerdo.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setForeground(Color.WHITE);
		txtValorUnitario.setFont(new Font("Arial", Font.ITALIC, 20));
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBackground(new Color(128, 0, 0));
		txtValorUnitario.setBounds(10, 504, 214, 30);
		pnlEsquerdo.add(txtValorUnitario);
		txtValorUnitario.setBorder(null);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(new Color(255, 255, 255));
		lblQuantidade.setFont(new Font("Arial", Font.ITALIC, 20));
		lblQuantidade.setBounds(267, 470, 186, 33);
		pnlEsquerdo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addFocusListener(new FocusAdapter(){
			public void focusLost (FocusEvent e) {
				txtTotalItem.setText("" +
				Double.parseDouble(txtQuantidade.getText()) *
				Double.parseDouble(txtValorUnitario.getText())
				);
				txtSubtotal.setText("R$: " +
						Double.parseDouble(txtQuantidade.getText()) *
						Double.parseDouble(txtValorUnitario.getText())
						);
			};
		});
		
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setFont(new Font("Arial", Font.ITALIC, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(new Color(128, 0, 0));
		txtQuantidade.setBounds(267, 502, 214, 30);
		pnlEsquerdo.add(txtQuantidade);
		txtQuantidade.setBorder(null);
		
		JLabel lblTotalItem = new JLabel("Total Item");
		lblTotalItem.setForeground(new Color(255, 255, 255));
		lblTotalItem.setFont(new Font("Arial", Font.ITALIC, 20));
		lblTotalItem.setBounds(523, 470, 186, 33);
		pnlEsquerdo.add(lblTotalItem);
		
		txtTotalItem = new JTextField();
		txtTotalItem.setForeground(Color.WHITE);
		txtTotalItem.setFont(new Font("Arial", Font.ITALIC, 20));
		txtTotalItem.setColumns(10);
		txtTotalItem.setBackground(new Color(128, 0, 0));
		txtTotalItem.setBounds(523, 502, 214, 30);
		pnlEsquerdo.add(txtTotalItem);
		txtTotalItem.setBorder(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 542, 780, 2);
		pnlEsquerdo.add(separator_1_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setForeground(new Color(255, 255, 255));
		lblSubtotal.setFont(new Font("Arial", Font.ITALIC, 25));
		lblSubtotal.setBounds(10, 562, 186, 33); 
		pnlEsquerdo.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setForeground(Color.WHITE);
		txtSubtotal.setFont(new Font("Arial", Font.BOLD, 35));
		txtSubtotal.setColumns(10);
		txtSubtotal.setBackground(new Color(128, 0, 0));
		txtSubtotal.setBounds(183, 562, 270, 89);
		pnlEsquerdo.add(txtSubtotal);
		txtSubtotal.setBorder(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cabecalho +="\n"+item+"\t"+txtCodigoProduto.getText()+"\t"+txtDescricao.getText()
						+"\t\t\t"+txtQuantidade.getText()+"\t"+txtValorUnitario.getText()+"\t"+txtTotalItem.getText();
				txtNota.setText(cabecalho);
				item++;
				
				valorPagar +=Double.parseDouble(txtTotalItem.getText());
				lblValorPagar.setText("R$: " + valorPagar);
			}
		});
		btnIncluir.setBackground(SystemColor.activeCaption);
		btnIncluir.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/imagens/Icone.png")));
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 30));
		btnIncluir.setBounds(481, 566, 243, 80);
		pnlEsquerdo.add(btnIncluir);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(SystemColor.activeCaptionBorder);
		pnlDireito.setBounds(810, 0, 774, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 710, 1584, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor a Pagar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setBounds(41, 25, 391, 84);
		panel.add(lblNewLabel);
		
		lblValorPagar = new JLabel("");
		lblValorPagar.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblValorPagar.setBounds(474, 25, 391, 84);
		panel.add(lblValorPagar);
		lblValorPagar.setText("R$ "+valorPagar);
	}
}
