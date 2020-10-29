import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import TrabalhoPratico1.canalComunicacao.Mensagem;

public class CaixaCorreio {

	private RandomAccessFile memoryMappedFile;
	private static MappedByteBuffer map;
	private static File file;
	final static int MAX_BUFFER = 256;
	
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
		this.map.putInt(msg.getId());
		this.map.putInt(msg.getTipo());
		this.map.putChar(value)
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
}
