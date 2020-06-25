package Cliente_ServidorUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Servidor{
	private int port;
	DatagramSocket datagramSocket;
	DatagramPacket datagramaRecebimento;
	
	public Servidor(int port) throws IOException {
		super();
		datagramSocket = new DatagramSocket(port);
		System.out.println("Servidor UDP executando na porta " +
		datagramSocket.getLocalPort());
	}
	
	public String  receive() throws IOException{
		//Cria o datagrama para receber uma mensagem.
		byte [] bufferRecebimento = new byte[1024];
		datagramaRecebimento = new
		DatagramPacket(bufferRecebimento, bufferRecebimento.length);
		//Aguarda ate o recebimento de uma mensagem.
		datagramSocket.receive(datagramaRecebimento);
		bufferRecebimento = datagramaRecebimento.getData();
		String mensagem = new String(bufferRecebimento);
		return mensagem;
	}

	public void send(String message) throws IOException {
		byte[] bufferEnvio = message.getBytes();
		DatagramPacket pacoteEnvio = new DatagramPacket (bufferEnvio,
				bufferEnvio.length, datagramaRecebimento.getAddress(),
				datagramaRecebimento.getPort());
		datagramSocket.send(pacoteEnvio);
	}
	
	public DatagramSocket getDatagramSocket() {
		return datagramSocket;
	}
	
	
	public DatagramPacket getDatagramaRecebimento() {
		return datagramaRecebimento;
	}

	public void close() {
		//Fechando o servidor.
		datagramSocket.close();
	}
	
public static void main(String args []) throws IOException{
	Servidor server = new Servidor(5051);

	
	String mensagem=server.receive();
	System.out.println("Servidor UDP recebeu a mensagem < "+ mensagem);
	
	System.out.println("Preparando uma resposta");
	//Enviando uma resposta
	String msgResposta = "reply:"+
	Servidor.inverteString(mensagem);
	System.out.println(msgResposta);

	server.send(msgResposta);

	System.out.println("Servidor UDP enviou resposta > "+ msgResposta);
	
	server.close();
}

public static String inverteString(String s){
String retorna = "";
s = s.trim();
int len = s.length();
for(int i=len; i > 0; i--){
if (i-1>=0) retorna = retorna+s.charAt(i-1);
}
return retorna;
}
}