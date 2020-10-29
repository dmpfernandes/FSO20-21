import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Chat_GUI extends JFrame{
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
		buttonGroup.add(btnTodas);
		btnTodas.setBounds(6, 18, 141, 23);
		panel_1.add(btnTodas);
		
		JRadioButton btnFSO = new JRadioButton("FSO");
		buttonGroup.add(btnFSO);
		btnFSO.setBounds(6, 73, 141, 23);
		panel_1.add(btnFSO);
		
		JRadioButton btnRobots = new JRadioButton("Robots");
		buttonGroup.add(btnRobots);
		btnRobots.setBounds(6, 133, 141, 23);
		panel_1.add(btnRobots);
		
		JRadioButton btnJava = new JRadioButton("Java");
		buttonGroup.add(btnJava);
		btnJava.setBounds(6, 193, 141, 23);
		panel_1.add(btnJava);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(159, 1, 218, 26);
		panel.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
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
		btnEnviar.setBounds(389, 55, 94, 29);
		panel.add(btnEnviar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(483, 55, 94, 29);
		panel.add(btnLimpar);
		
		JTextArea textAreaCaixaCorreio = new JTextArea();
		textAreaCaixaCorreio.setBounds(159, 93, 411, 163);
		panel.add(textAreaCaixaCorreio);
		
		JRadioButton rdbtnAbrir = new JRadioButton("Abrir");
		rdbtnAbrir.setBounds(500, 2, 70, 23);
		panel.add(rdbtnAbrir);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldPesquisa;
	private JTextField textFieldMsgEnviar;
}
