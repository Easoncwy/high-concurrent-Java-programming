package Chapter5_并行模式与算法;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

/**
 * Created by eason on 2017/7/1.
 */
public class Consumer implements Runnable{
    private BlockingDeque<PCData> queue; //缓冲区
    private static final int SLLEPTIME = 1000;
    public Consumer(BlockingDeque<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();

        try {
            while (true){
                PCData data = queue.take();     //提取任务
                if (null != data){
                    int re = data.getData() * data.getData(); //计算平方
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(),re));
                    Thread.sleep(r.nextInt(SLLEPTIME));

                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }





}
