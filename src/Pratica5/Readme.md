# UNIVERSIDADE FEDERAL RURAL DO SEMIÁRIDO - UFERSA

# Departamento de Computação - DC

# Graduação em Ciência da Computação

# Disciplina: Sistemas Distribuídos

# Prof.: Paulo Henrique Lopes Silva

# Prática 5

# 1. Servidor de Eco sem threads.

# • Classe Cliente.java

```
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
```
```
public class ClienteSemThreads {
```
```
public static void main(String[] args) throws UnknownHostException, IOException {
```
```
Socket cliente = new Socket("127.0.0.1", 54321);
```
```
System. out .println("O cliente se conectou ao servidor!");
```
```
InetAddress inet = cliente.getInetAddress();
System. out .println("HostAddress = "+inet.getHostAddress());
System. out .println("HostName = "+inet.getHostName());
```
```
Scanner teclado = new Scanner(System. in );
PrintStream saida = new PrintStream(cliente.getOutputStream());
```
```
while (teclado.hasNextLine()) {
saida.println(teclado.nextLine());
}
```
```
saida.close();
teclado.close();
cliente.close();
}
```
```
}
```
# • Classe Servidor.java

```
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
```
```
public class ServidorSemThreads {
```

```
public static void main(String[] args) throws IOException {
```
```
ServerSocket servidor = new ServerSocket(54321);
System. out .println("Servidor rodando na porta "+servidor.getLocalPort());
System. out .println("HostAddress = "+ InetAddress. getLocalHost ().getHostAddress());
System. out .println("HostName = "+ InetAddress. getLocalHost ().getHostName());
```
```
Socket cliente = servidor.accept();
System. out .println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
```
```
Scanner entrada = new Scanner(cliente.getInputStream());
```
```
while (entrada.hasNextLine()) {
```
```
System. out .println(entrada.nextLine());
}
```
```
entrada.close();
servidor.close();
```
```
}
```
```
}
```
# Exercícios:

# 1. Crie um projeto no Eclipse, codifique, execute e observe o funcionamento dessa aplicação.

# 2. Elabore uma estratégia para finalizar a execução de um cliente. Por exemplo, o envio de uma

# mensagem específica de finalização da conexão.

# 3. Após um cliente se conectar ao servidor, tente conectar outro cliente.

# • O que acontece?

# • Faça um pesquisa sobre o construtor da classe Socket para ajudar nesse cenário.


