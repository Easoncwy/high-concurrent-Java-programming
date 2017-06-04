package Chapter2_Java并行程序基础;

/**
 * Created by eason on 2017/2/14.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted");
                        break;
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
