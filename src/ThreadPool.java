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
		
		//Outro ThreadPoolExecutor pré-configurado pode ser criado com o método Executors.newCachedThreadPool () . Este método não recebe um número de threads. O corePoolSize está realmente definido como 0 e o maximumPoolSize está definido como Integer.MAX_VALUE para esta instância. O keepAliveTime é de 60 segundos para este.
		
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
				
				
//				A API Executors.newSingleThreadExecutor () cria outra forma típica de ThreadPoolExecutor que contém um único thread. O executor de thread único é ideal para criar um loop de eventos. Os corePoolSize e maximumPoolSize parâmetros são iguais a 1, eo KeepAliveTime é zero.

//				As tarefas no exemplo acima serão executadas sequencialmente, portanto, o valor do sinalizador será 2 após a conclusão da tarefa:

				AtomicInteger counter = new AtomicInteger();
				 
				ExecutorService executor = Executors.newSingleThreadExecutor();
				executor.submit(() -> {
				    counter.set(1);
				});
				executor.submit(() -> {
				    counter.compareAndSet(1, 2);
				});
				
				/*
				 * O ScheduledThreadPoolExecutor estende a classe ThreadPoolExecutor e também implementa a interface ScheduledExecutorService com vários métodos adicionais:

método de programação permite executar uma tarefa uma vez após um atraso especificado;
O método scheduleAtFixedRate permite executar uma tarefa após um atraso inicial especificado e executá-la repetidamente com um determinado período; o argumento do período é o tempo medido entre os horários de início das tarefas , portanto a taxa de execução é fixa;
O método scheduleWithFixedDelay é semelhante ao scheduleAtFixedRate, na medida em que executa repetidamente a tarefa especificada, mas o atraso especificado é medido entre o final da tarefa anterior e o início da próxima ; a taxa de execução pode variar dependendo do tempo necessário para executar qualquer tarefa.
O método Executors.newScheduledThreadPool () geralmente é usado para criar um ScheduledThreadPoolExecutor com um determinado corePoolSize , maximumPoolSize ilimitado e zero keepAliveTime . Veja como agendar uma tarefa para execução em 500 milissegundos:


ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
executor.schedule(() -> {
    System.out.println("Hello World");
}, 500, TimeUnit.MILLISECONDS);


O código a seguir mostra como executar uma tarefa após um atraso de 500 milissegundos e, em seguida, repeti-la a cada 100 milissegundos. Depois de agendar a tarefa, temos que esperar até que ele dispara três vezes usando o CountDownLatch bloqueio , em seguida, cancelá-la usando o Future.cancel () método.


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
