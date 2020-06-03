package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Factory factory = new Factory(queue, 5);


        //实现runnable接口
        for (int i = 0; i < 30; i++) {
            Product product = new Product(factory);
            new Thread(product).start();
        }

        //继承thread类
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer(factory);
            customer.start();
        }

        //实现Callable接口，获取返回值
        for (int i = 0; i < 5; i++) {
            CustomerCallable customerCallable = new CustomerCallable(factory);
            FutureTask<String> futureTask = new FutureTask<String>(customerCallable);
            new Thread(futureTask, "线程" + i).start();
        }

        //线程池
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer(factory);
            executorService.execute(customer);
        }

    }
}
