package thread;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2020/6/1 18:51
 * @description：生产
 */
public class Product implements Runnable {

    private Factory factory;

    public Product(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
       /* for (int i = 0; i < 10; i++) {
            factory.product(Thread.currentThread().toString() + i);
        }*/
    }
}
