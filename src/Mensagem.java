
public class Mensagem {
	
	private int id;
	private Integer tipo;
	private String texto;
	
	public Mensagem(Integer tipo, String texto){
		this.tipo = tipo;
		this.texto = texto;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo.intValue();
	}

	public void setTipo(int tipo) {
		this.tipo = Integer.valueOf(tipo);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
