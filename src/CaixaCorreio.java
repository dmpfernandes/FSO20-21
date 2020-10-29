import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import TrabalhoPratico1.canalComunicacao.Mensagem;

public class CaixaCorreio {

	private RandomAccessFile memoryMappedFile;
	private static MappedByteBuffer map;
	private static File file;
	final static int MAX_BUFFER = 8448;//256bytes texto + 4bytes id + 4Bytes tipo * 32 mensagens 
	
	public CaixaCorreio(String nomeDoFicheiro) {
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
		map.putInt(msg.getId());
		map.putInt(msg.getTipo());
		for( char c : msg.getTexto().toCharArray()) {
			map.putChar(c);
			
		};
	}

	public Mensagem get() {
		
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
		System.out.println(resultado.toString());
		return resultado;
	}
}
