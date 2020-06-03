package thread;

import java.util.concurrent.Callable;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2020/6/3 19:13
 * @description：
 */
public class CustomerCallable implements Callable<String> {

    private Factory factory;

    public CustomerCallable(Factory factory) {
        this.factory = factory;
    }

    @Override
    public String call() throws Exception {
        factory.customer();
        return "线程：" + Thread.currentThread() + "消费成功";
    }
}
