
public class TratamentoMensagem {
	
	private CanalDeComunicacao canal;
	
	TratamentoMensagem(String nomeDoFicheiro){
		canal = new CanalDeComunicacao(nomeDoFicheiro);
		
	}
	
	
	public void enviarMensagem (Mensagem msg){
		canal.put(msg);
	}

	public Mensagem receberMensagem(int tipo) {
		Mensagem msg = canal.get();
		if (msg != null) {
			if (tipo == 0 || msg.getTipo() == tipo || msg.getTipo() == 0) {
				return msg;
			}
		}
		return null;
	}
	
	public void fecharCanal() {
		canal.fecharCanal();
	}

}
