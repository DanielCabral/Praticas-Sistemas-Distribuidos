# UNIVERSIDADE FEDERAL RURAL DO SEMIÁRIDO - UFERSA

# Departamento de Computação - DC

# Graduação em Ciência da Computação

# Disciplina: Sistemas Distribuídos

# Prof.: Paulo Henrique Lopes Silva

# Prática 4 - Threads em Java

# 1. Interface Runnable

# • Classe MinhaThread.java

```
public class MinhaThread implements Runnable {
privateprivate intint idtempo; ;
```
```
public MinhaThread( int id, int tempo) {
this .id = id;
this .tempo = tempo;
}
public void run () {
for ( int i = 0; i < 1000; i++) {
System. out .println("Thread " + id + " valor: " + i);
try {
} catch Thread. (InterruptedException sleep( this .tempo);e) {
// TODO Auto-generated catch block
} e.printStackTrace();
}
}
}
```
# • Classe Teste.java

```
package sd.threads;
public class Teste {
public static void main(String[] args) {
MinhaThread p1 = new MinhaThread(1, 500);
Thread t1 = new Thread(p1);
t1.start();
MinhaThread p2 = new MinhaThread(2, 750);
Thread t2 = new Thread(p2);
```

```
t2.start();
MinhaThread p3 = new MinhaThread(3, 900);
Thread t3 = new Thread(p3);
t3.start();
} }
```
# Exercícios:

# 1. Crie um projeto no Eclipse, codifique, execute e observe o funcionamento dessa aplicação com

# threads.


