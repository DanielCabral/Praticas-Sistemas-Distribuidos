package Cliente_ServidorUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Cliente{

	private DatagramSocket socketCliente;
	private InetAddress endereco;
	
	public Cliente() throws IOException{
		socketCliente = new DatagramSocket();
		endereco = InetAddress.getByName("localhost");
	}
	
	public InetAddress getEndereco() {
		return endereco;
	}

	public void setEndereco(InetAddress endereco) {
		this.endereco = endereco;
	}

	public void send(String msg) throws IOException{
		byte[] bufferEnvio = msg.getBytes();
		//Enviar datagrama para destinatário na porta 5050.
		DatagramPacket datagramaEnvio = new DatagramPacket(bufferEnvio,
		bufferEnvio.length, endereco, 5000);
		System.out.println("Cliente UDP "+endereco.getHostAddress()+" " +socketCliente.getLocalPort() + " enviando mensagem > "+msg);
		//Envia o datagrama.
		socketCliente.send(datagramaEnvio);
	}
	
	public byte[] receive() throws IOException{
		//Passa um recvBuffer e o tamanho do recvBuffer para receber a mensagem.
		//Se o conteúdo da mensagem recebida for maior que o recvBuffer o
		//excedente é descartado.

		byte [] bufferRecebimento = new byte[1024];
		DatagramPacket datagramaRecebimento = new
		DatagramPacket(bufferRecebimento, bufferRecebimento.length);
		socketCliente.receive(datagramaRecebimento);
		bufferRecebimento = datagramaRecebimento.getData();
		return bufferRecebimento;
	}
	
	public void close() {
		//Fechando o socket.
		socketCliente.close();
	}
	
	
public static void main(String args []) throws IOException{
	Cliente client = new Cliente();
	
	
	// entrada de dados do cliente
	Scanner sc = new Scanner(System.in);
	System.out.println("Digite uma mensagem >\n");

	String msg = sc.nextLine();


	client.send(msg);

	byte[] retorno = client.receive();
	
	System.out.println("Cliente UDP "+client.getEndereco().getHostAddress()+" recebeu mensagem < "+ new String(retorno));
	
	
	client.close();

	sc.close();

}
}