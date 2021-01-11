import java.util.ArrayList;
import java.util.List;

public class DesenharQuadrado{
	
	public List<Mensagem> gerarComandos(){
		List<Mensagem> comandos = new ArrayList<Mensagem>();
		
		for(int i = 0; i < 4; i++) {
			comandos.add(new Mensagem(0, 50));
			comandos.add(new Mensagem(1, false));
			comandos.add(new Mensagem(3, 0, 90));
		}
		
		return comandos;
	}
}
