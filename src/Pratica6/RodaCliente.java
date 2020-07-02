package Pratica6;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class RodaCliente {
public static void main(String args[]) throws UnknownHostException, IOException {
/** para se conectar ao servidor, cria-se objeto Socket.
 O primeiro par�metro � o IP ou endere�o da m�quina que
 se quer conectar e o segundo � a porta da aplica��o.
 Neste caso, usa-se o IP da m�quina local (127.0.0.1)
 e a porta da aplica��o ServidorDeEco (12345). */
Socket socket = new Socket("127.0.0.1", 12345);
InetAddress inet = socket.getInetAddress();
System.out.println("HostAddress = "+inet.getHostAddress());
System.out.println("HostName = "+inet.getHostName());
/**Cria um novo objeto Cliente com a conex�o socket para que seja executado em um novo
processo. Permitindo assim a conex�o de v�rio clientes com o servidor.*/
ClienteRunnable c = new ClienteRunnable(socket);
Thread t = new Thread(c);
t.start();
}
}