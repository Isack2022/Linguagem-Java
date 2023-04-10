package br.com.poo.estruturaarray;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JTextField txtTotalItem;
	private JTextField txtSubtotal;

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
		
		
		String[][] produtos = {
				
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","15.00","14032024"},
				{"2025","Torta de Frango","50.00","17032025"},
				{"2026","Leite Integral A","5.00","17032026"},
				{"2027","Manteiga","5.00","17032027"},
				{"2028","Bolo","20.00","17032028"},
				{"2029","Bauru","12.00","17032029"},
				{"2030","Suco Laranja","7.00","17032030"}
				
		};
			
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Padaria.class.getResource("/br/com/poo/images/logopadaria3.jpg")));
		setResizable(false);
		setTitle("Janela Padaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(new Color(18, 57, 90));
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 400);
		
		/*
		 * Para ajustar a imagem ao tamanho da Label, foi necessário aplicar o comando 
		 * new ImageIcon para definir a scala no elemento getImage. 
		 * O tamanho da imagem foi de ajustado para largura da label(lbl.getWidth) e altura da 
		 * label (lbl.getHeight) e para finalizar, foi alterado a forma de fechamento da 
		 * imagem quando a tela fecha, foi setado o valor para suaviazação(image.SCALE_SMOOTH)
		 * */
		
		
		lblLogo.setIcon(new ImageIcon
				(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/logopadaria3.jpg"))
						.getImage().getScaledInstance(lblLogo.getWidth(), 
								lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		
		
		
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setForeground(new Color(255, 255, 255));
		lblCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoProduto.setBounds(20, 395, 214, 42);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setForeground(Color.WHITE);
		lblCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoBarras.setBounds(444, 395, 214, 42);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				for(int linha = 0 ; linha < produtos.length ; linha++) {
					
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
		txtCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoProduto.setForeground(new Color(255, 255, 255));
		txtCodigoProduto.setBackground(new Color(18, 57, 90));
		txtCodigoProduto.setBounds(20, 433, 194, 30);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBorder(null);
		
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setForeground(Color.WHITE);
		txtCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBackground(new Color(18, 57, 90));
		txtCodigoBarras.setBounds(444, 433, 194, 30);
		pnlEsquerdo.add(txtCodigoBarras);
		txtCodigoBarras.setBorder(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 470, 780, 2);
		pnlEsquerdo.add(separator);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescricao.setBounds(20, 464, 214, 42);
		pnlEsquerdo.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(Color.WHITE);
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(new Color(18, 57, 90));
		txtDescricao.setBounds(20, 495, 770, 30);
		pnlEsquerdo.add(txtDescricao);
		txtDescricao.setBorder(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 536, 780, 2);
		pnlEsquerdo.add(separator_1);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitário:");
		lblValorUnitario.setForeground(Color.WHITE);
		lblValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorUnitario.setBounds(20, 528, 214, 42);
		pnlEsquerdo.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setForeground(Color.WHITE);
		txtValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBackground(new Color(18, 57, 90));
		txtValorUnitario.setBounds(20, 559, 194, 30);
		pnlEsquerdo.add(txtValorUnitario);
		txtValorUnitario.setBorder(null);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidade.setBounds(290, 528, 214, 42);
		pnlEsquerdo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(new Color(18, 57, 90));
		txtQuantidade.setBounds(292, 559, 194, 30);
		pnlEsquerdo.add(txtQuantidade);
		txtQuantidade.setBorder(null);
		
		JLabel lblTotalItem = new JLabel("Total Item:");
		lblTotalItem.setForeground(Color.WHITE);
		lblTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalItem.setBounds(576, 528, 214, 42);
		pnlEsquerdo.add(lblTotalItem);
		
		txtTotalItem = new JTextField();
		txtTotalItem.setForeground(Color.WHITE);
		txtTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotalItem.setColumns(10);
		txtTotalItem.setBackground(new Color(18, 57, 90));
		txtTotalItem.setBounds(576, 559, 194, 30);
		pnlEsquerdo.add(txtTotalItem);
		txtTotalItem.setBorder(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 600, 780, 2);
		pnlEsquerdo.add(separator_1_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSubtotal.setBounds(20, 598, 214, 42);
		pnlEsquerdo.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setForeground(Color.WHITE);
		txtSubtotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		txtSubtotal.setColumns(10);
		txtSubtotal.setBackground(new Color(18, 57, 90));
		txtSubtotal.setBounds(225, 613, 303, 76);
		pnlEsquerdo.add(txtSubtotal);
		txtSubtotal.setBorder(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setMnemonic('I');
		btnIncluir.setForeground(new Color(255, 255, 255));
		btnIncluir.setBackground(new Color(18, 57, 90));
		btnIncluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIncluir.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/iconinsert.png")));
		btnIncluir.setBounds(576, 620, 201, 56);
		pnlEsquerdo.add(btnIncluir);
		btnIncluir.setBorder(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(324, 427, 12, 36);
		pnlEsquerdo.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(251, 558, 12, 36);
		pnlEsquerdo.add(separator_2_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(528, 553, 12, 36);
		pnlEsquerdo.add(separator_2_1_1);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(new Color(255, 255, 255));
		pnlDireito.setBounds(810, 0, 774, 700);
		contentPane.add(pnlDireito);
		
		JPanel pnlBase = new JPanel();
		pnlBase.setBackground(new Color(192, 192, 192));
		pnlBase.setBounds(0, 710, 1584, 150);
		contentPane.add(pnlBase);
	}
}
