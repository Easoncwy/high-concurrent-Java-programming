package Chapter5_并行模式与算法;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by eason on 2017/7/1.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        //建立缓冲区
        BlockingDeque<PCData> queue = new LinkedBlockingDeque<>(10);

        Producer producer1 = new Producer(queue);                 //建立生产者
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);                 //建立消费者
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();  //建立线程池
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);

        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        Thread.sleep(10 * 1000);    //停止生产者
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();

    }

}
