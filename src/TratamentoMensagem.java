
public class TratamentoMensagem {
	
	private CanalDeComunicacao canal;
	private int idx = 0;
	
	TratamentoMensagem(String nomeDoFicheiro){
		canal = new CanalDeComunicacao(nomeDoFicheiro);
		
	}
	
	
	public void enviarMensagem (Mensagem msg){
		msg.setId(idx);
		canal.put(msg);
	}

	public Mensagem receberMensagem(int tipo) {
		Mensagem msg = canal.get();
		if (msg != null) {
			if (tipo == 0 || msg.getTipo() == tipo) {
				idx = msg.getId()+1;
				return msg;
			}
		}
		return null;
	}

}
