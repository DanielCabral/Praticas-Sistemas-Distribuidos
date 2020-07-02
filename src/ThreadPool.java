import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {

	public static void main(String [] args) throws InterruptedException, ExecutionException {
		/*
		O metodo newFixedThreadPool cria uma ThreadPoolExecutor com corePoolSize e maximumPoolSize iguais e keepAliveTime igual a zero
		
		ThreadPoolExecutor executor = 
				  (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				 
				System.out.println(executor.getPoolSize());
				System.out.println(executor.getQueue().size());*/
		
		//Outro ThreadPoolExecutor pr�-configurado pode ser criado com o m�todo Executors.newCachedThreadPool () . Este m�todo n�o recebe um n�mero de threads. O corePoolSize est� realmente definido como 0 e o maximumPoolSize est� definido como Integer.MAX_VALUE para esta inst�ncia. O keepAliveTime � de 60 segundos para este.
		
				/*ThreadPoolExecutor executor = 
				  (ThreadPoolExecutor) Executors.newCachedThreadPool();
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});
				executor.submit(() -> {
				    Thread.sleep(1000);
				    return null;
				});*/
				
				
//				A API Executors.newSingleThreadExecutor () cria outra forma t�pica de ThreadPoolExecutor que cont�m um �nico thread. O executor de thread �nico � ideal para criar um loop de eventos. Os corePoolSize e maximumPoolSize par�metros s�o iguais a 1, eo KeepAliveTime � zero.

//				As tarefas no exemplo acima ser�o executadas sequencialmente, portanto, o valor do sinalizador ser� 2 ap�s a conclus�o da tarefa:

				AtomicInteger counter = new AtomicInteger();
				 
				ExecutorService executor = Executors.newSingleThreadExecutor();
				executor.submit(() -> {
				    counter.set(1);
				});
				executor.submit(() -> {
				    counter.compareAndSet(1, 2);
				});
				
				/*
				 * O ScheduledThreadPoolExecutor estende a classe ThreadPoolExecutor e tamb�m implementa a interface ScheduledExecutorService com v�rios m�todos adicionais:

m�todo de programa��o permite executar uma tarefa uma vez ap�s um atraso especificado;
O m�todo scheduleAtFixedRate permite executar uma tarefa ap�s um atraso inicial especificado e execut�-la repetidamente com um determinado per�odo; o argumento do per�odo � o tempo medido entre os hor�rios de in�cio das tarefas , portanto a taxa de execu��o � fixa;
O m�todo scheduleWithFixedDelay � semelhante ao scheduleAtFixedRate, na medida em que executa repetidamente a tarefa especificada, mas o atraso especificado � medido entre o final da tarefa anterior e o in�cio da pr�xima ; a taxa de execu��o pode variar dependendo do tempo necess�rio para executar qualquer tarefa.
O m�todo Executors.newScheduledThreadPool () geralmente � usado para criar um ScheduledThreadPoolExecutor com um determinado corePoolSize , maximumPoolSize ilimitado e zero keepAliveTime . Veja como agendar uma tarefa para execu��o em 500 milissegundos:


ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
executor.schedule(() -> {
    System.out.println("Hello World");
}, 500, TimeUnit.MILLISECONDS);


O c�digo a seguir mostra como executar uma tarefa ap�s um atraso de 500 milissegundos e, em seguida, repeti-la a cada 100 milissegundos. Depois de agendar a tarefa, temos que esperar at� que ele dispara tr�s vezes usando o CountDownLatch bloqueio , em seguida, cancel�-la usando o Future.cancel () m�todo.


CountDownLatch lock = new CountDownLatch(3);
 
ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
    System.out.println("Hello World");
    lock.countDown();
}, 500, 100, TimeUnit.MILLISECONDS);
 
lock.await(1000, TimeUnit.MILLISECONDS);
future.cancel(true);
				 * */
	}
}
