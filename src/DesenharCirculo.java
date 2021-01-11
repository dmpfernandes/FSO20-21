import java.util.ArrayList;
import java.util.List;

public class DesenharCirculo{
	
	//Tipos possiveis:
			//Reta = 0
			//Parar = 1
			//Curva esquerda = 2
			//Curva direita = 3
			
	public List<Mensagem> gerarComandos(){
		List<Mensagem> comandos = new ArrayList<Mensagem>();

		comandos.add(new Mensagem(3, 25, 360));
		comandos.add(new Mensagem(1, false));

		return comandos;
	}
}