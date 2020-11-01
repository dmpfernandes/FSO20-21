import javax.swing.JTextArea;

public class ReceberMensagem_Servico implements Runnable{

	private TratamentoMensagem tratamentoMensagem;
	private int tipo;
	private JTextArea textArea;

	public ReceberMensagem_Servico(TratamentoMensagem tratamentoMensagem, int tipo, JTextArea textArea) {
		this.tratamentoMensagem = tratamentoMensagem;
		this.tipo = tipo;
		this.textArea = textArea;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Mensagem msg = tratamentoMensagem.receberMensagem(tipo);
			if(msg != null) {
				textArea.setText(textArea.getText() + "\n" + msg.toString());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
