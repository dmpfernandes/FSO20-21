
public class TratamentoMensagem {
	
	private CanalDeComunicacao canal;
	
	TratamentoMensagem(String nomeDoFicheiro){
		canal = new CanalDeComunicacao(nomeDoFicheiro);
		
	}
	
	
	public void enviarMensagem (Mensagem msg){
		canal.put(msg);
	}
	
	public Mensagem receberMensagem (int tipo) {
		if(tipo == 0 || canal.get().getTipo() == tipo) {
			if(!canal.estaVazio()) {
				return canal.get();
			}
		}
		return null;
	}
	
	
}
