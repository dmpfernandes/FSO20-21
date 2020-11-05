import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;


public class CanalDeComunicacao {

	private RandomAccessFile memoryMappedFile;
	private static MappedByteBuffer map;
	private static File file;
	final static int MAX_BUFFER = 8448;//256bytes texto + 4bytes id + 4Bytes tipo * 32 mensagens 
	private int idx = 0; 
	
	public CanalDeComunicacao(String nomeDoFicheiro) {
		file = new File(nomeDoFicheiro);
		try {
			this.memoryMappedFile = new RandomAccessFile(file, "rw");
			this.map = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, MAX_BUFFER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//file.deleteOnExit();
	}

	public void put(Mensagem msg) {
		
		map.position(0);
		map.putInt(idx);
		map.putInt(msg.getTipo());
		for( char c : transformaTexto(msg.getTexto())) {
			map.putChar(c);
		};
	}

	public Mensagem get() {
		map.position(0);
		Integer id = map.getInt();
		Integer tipo = map.getInt();
		String texto = "";
		for(int i = 0; i<256; i++) {
			texto += map.getChar();
		}
		Mensagem msg = new Mensagem(tipo,texto);
		msg.setId(id);
		idx = id+1;
		
		if(id != null && tipo != null && texto != "") {
			return msg;
		}
		return null;
		
		
	}
	
	public void fecharCanal() {
		try {
			this.memoryMappedFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private char[] transformaTexto(String texto) {
		char[] resultado = new char[256];
		
		for (int i = 0; i < 256; i++) {
			resultado[i] = (texto.toCharArray().length>i)?texto.toCharArray()[i]:' ';
		}
		System.out.println(String.valueOf(resultado));
		return resultado;
	}
	
}
