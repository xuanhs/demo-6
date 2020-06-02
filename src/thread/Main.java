package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Factory factory = new Factory(queue, 5);


        for(int i = 0;i<10;i++){
            Product product = new Product(factory);
            new Thread(product).start();
        }

        for(int i =0;i<10;i++){
            Customer customer = new Customer(factory);
            new Thread(customer).start();
        }




    }
}
