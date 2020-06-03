package thread;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2020/6/1 18:53
 * @description：
 */
public class Customer extends Thread {

    private Factory factory;

    public Customer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {

        try {
            factory.customer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
