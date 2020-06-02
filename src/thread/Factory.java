package thread;

import java.util.Queue;

public class Factory {

    private Queue<String> products;

    private Integer max;


    public Factory(Queue<String> products, Integer max) {
        this.products = products;
        this.max = max;
    }


    public void product(String product) throws InterruptedException {
        synchronized (products) {
            //库存过多时暂停生产
            Thread.sleep(500);
            while (products.size() > max) {
                System.out.println("库存量：" + products.size() + "不能生产啦!");
                try {
                    //条件不满足，生产阻塞
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.add(product);
            System.out.println("生产啦，现仓储量为:" + products.size());
            products.notifyAll();
        }
    }

    public void customer() throws InterruptedException {
        synchronized (products) {
            Thread.sleep(500);
            //不满足消费条件
            while(0 >= products.size()){
                System.out.println("库存为0不能消费啦");
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费啦:" +products.poll());
            products.notifyAll();
        }
    }
}
