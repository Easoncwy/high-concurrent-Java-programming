package Chapter2_Java并行程序基础;

/**
 * Created by eason on 2017/6/4.
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(){
            public void run(){
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("Interruted When Sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
