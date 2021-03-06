import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Chat_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldPesquisa;
	private JTextField textFieldMsgEnviar;

	private static Chat_GUI frame;
	private CanalDeComunicacao canal;
	protected String nomeFicheiro;
	protected int tipo;
	private Integer id = null;
	private boolean running = false;
	private JTextArea textAreaCaixaCorreio;
	private ArrayList<String> mensagensLidas;

	public static void main(String[] args) {
		try {
			frame = new Chat_GUI();
			frame.setPreferredSize(new Dimension(600, 300));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			if (running) {
				Mensagem msg = canal.get();
				if (msg != null && !msg.getTexto().isEmpty()) {
					if (tipo == 0 || msg.getTipo() == tipo || msg.getTipo() == 0) {
						if (id == null || id < msg.getId()) {
							id = msg.getId();
							mensagensLidas.add(msg.toString() + "\n");
							textAreaCaixaCorreio.setText("");
							if (mensagensLidas.size() > 9) {
								mensagensLidas.remove(0);
							}

							for (int i = mensagensLidas.size(); i > 0; i--) {

								textAreaCaixaCorreio.setText(
										textAreaCaixaCorreio.getText() + mensagensLidas.get(mensagensLidas.size() - i));
							}

						}
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Chat_GUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (canal != null) {
					canal.fecharCanal();
				}
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel labelCaixaCorreio = new JLabel("Caixa de Correio");
		labelCaixaCorreio.setBounds(20, 6, 104, 16);
		panel.add(labelCaixaCorreio);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo de Mensagem",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 34, 141, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JRadioButton btnTodas = new JRadioButton("Todas");
		btnTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaCaixaCorreio.setText("");
				tipo = 0;
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
				tipo = 1;
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
				tipo = 2;
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
				tipo = 3;
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
				nomeFicheiro = textFieldPesquisa.getText();
				if (nomeFicheiro == null || nomeFicheiro.isEmpty()) {
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

					int returnValue = jfc.showOpenDialog(btnPesquisar);
					// int returnValue = jfc.showSaveDialog(null);

					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jfc.getSelectedFile();
						textFieldPesquisa.setText(selectedFile.getName());
						System.out.println(selectedFile.getAbsolutePath());
						nomeFicheiro = selectedFile.getAbsolutePath();
					}
				}

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
				if (canal != null) {
					Integer tipo = Integer.parseInt(Arrays.asList(panel_1.getComponents()).stream()
							.filter(c -> ((JRadioButton) c).isSelected()).findFirst().get().getName());
					Mensagem msg = new Mensagem(tipo, textFieldMsgEnviar.getText());
					canal.put(msg);
					textFieldMsgEnviar.setText("");
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
				if (rdbtnAbrir.isSelected() && nomeFicheiro != null && !nomeFicheiro.isEmpty()
						&& Arrays.asList(panel_1.getComponents()).stream().filter(c -> ((JRadioButton) c).isSelected())
								.findFirst().isPresent()) {
					tipo = Integer.parseInt(Arrays.asList(panel_1.getComponents()).stream()
							.filter(c -> ((JRadioButton) c).isSelected()).findFirst().get().getName());
					canal = new CanalDeComunicacao(nomeFicheiro);
					mensagensLidas = new ArrayList<String>(9);
					running = true;
				} else if (!rdbtnAbrir.isSelected()) {
					running = false;
				} else {
					rdbtnAbrir.setSelected(false);
				}

			}
		});
		rdbtnAbrir.setBounds(500, 2, 70, 23);
		panel.add(rdbtnAbrir);
	}
}
