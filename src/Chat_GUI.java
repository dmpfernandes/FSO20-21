import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Chat_GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldPesquisa;
	private JTextField textFieldMsgEnviar;
	
	private static Chat_GUI frame;
	private TratamentoMensagem tratamentoMensagem;
	protected String nomeFicheiro;
	protected ReceberMensagem_Servico receberMensagem_Servico;
	private JTextArea textAreaCaixaCorreio;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Chat_GUI();
					frame.setPreferredSize(new Dimension(600, 300));
				    frame.pack();
				    frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Chat_GUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelCaixaCorreio = new JLabel("Caixa de Correio");
		labelCaixaCorreio.setBounds(20, 6, 104, 16);
		panel.add(labelCaixaCorreio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo de Mensagem", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 34, 141, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton btnTodas = new JRadioButton("Todas");
		btnTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCaixaCorreio.setText("");
				if(receberMensagem_Servico != null) {
					receberMensagem_Servico.setTipo(0);
				}
			}
		});
		btnTodas.setName("0");
		buttonGroup.add(btnTodas);
		btnTodas.setBounds(6, 18, 141, 23);
		panel_1.add(btnTodas);
		
		JRadioButton btnFSO = new JRadioButton("FSO");
		btnFSO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCaixaCorreio.setText("");
				if(receberMensagem_Servico != null) {
					receberMensagem_Servico.setTipo(1);
				}
			}
		});
		btnFSO.setName("1");
		buttonGroup.add(btnFSO);
		btnFSO.setBounds(6, 73, 141, 23);
		panel_1.add(btnFSO);
		
		JRadioButton btnRobots = new JRadioButton("Robots");
		btnRobots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCaixaCorreio.setText("");
				if(receberMensagem_Servico != null) {
					receberMensagem_Servico.setTipo(2);
				}
			}
		});
		btnRobots.setName("2");
		buttonGroup.add(btnRobots);
		btnRobots.setBounds(6, 133, 141, 23);
		panel_1.add(btnRobots);
		
		JRadioButton btnJava = new JRadioButton("Java");
		btnJava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCaixaCorreio.setText("");
				if(receberMensagem_Servico != null) {
					receberMensagem_Servico.setTipo(3);
				}
			}
		});
		btnJava.setName("3");
		buttonGroup.add(btnJava);
		btnJava.setBounds(6, 193, 141, 23);
		panel_1.add(btnJava);
		
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(159, 1, 218, 26);
		panel.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Arrays.asList(panel_1.getComponents()).stream().filter(c -> ((JRadioButton)c).isSelected()).forEach(c -> System.out.println(c.getName()));
				nomeFicheiro = textFieldPesquisa.getText();
			}
		});
		btnPesquisar.setBounds(389, 1, 94, 29);
		panel.add(btnPesquisar);
		
		textFieldMsgEnviar = new JTextField();
		textFieldMsgEnviar.setBounds(159, 55, 218, 26);
		panel.add(textFieldMsgEnviar);
		textFieldMsgEnviar.setColumns(10);
		
		JLabel lblMsgEnviar = new JLabel("Mensagem a Enviar");
		lblMsgEnviar.setLabelFor(lblMsgEnviar);
		lblMsgEnviar.setBounds(159, 29, 141, 26);
		panel.add(lblMsgEnviar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tratamentoMensagem != null) {
					Integer tipo = Integer.parseInt(Arrays.asList(panel_1.getComponents()).stream().filter(c -> ((JRadioButton)c).isSelected()).findFirst().get().getName());
					Mensagem msg = new Mensagem(tipo, textFieldMsgEnviar.getText());
					tratamentoMensagem.enviarMensagem(msg);
				}
			}
		});
		btnEnviar.setBounds(389, 55, 94, 29);
		panel.add(btnEnviar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaCaixaCorreio.setText("");
			}
		});
		btnLimpar.setBounds(483, 55, 94, 29);
		panel.add(btnLimpar);
		
		textAreaCaixaCorreio = new JTextArea();
		textAreaCaixaCorreio.setBounds(159, 93, 411, 163);
		panel.add(textAreaCaixaCorreio);
		
		JRadioButton rdbtnAbrir = new JRadioButton("Abrir");
		rdbtnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeFicheiro != null && !nomeFicheiro.isEmpty()) {
					int tipo = Integer.parseInt(Arrays.asList(panel_1.getComponents()).stream().filter(c -> ((JRadioButton)c).isSelected()).findFirst().get().getName());
					tratamentoMensagem = new TratamentoMensagem(nomeFicheiro);
					receberMensagem_Servico = new ReceberMensagem_Servico(tratamentoMensagem, tipo, textAreaCaixaCorreio);
					Thread thread = new Thread(receberMensagem_Servico);
					thread.start();
				}
			}
		});
		rdbtnAbrir.setBounds(500, 2, 70, 23);
		panel.add(rdbtnAbrir);
	}
}
