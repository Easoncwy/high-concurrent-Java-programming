package Chapter2_Java并行程序基础;

/**
 * Created by eason on 2017/2/13.
 */
public class CreateThread3 implements Runnable{
    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread3());
        t1.start();
        t1.run();
    }

    @Override
    public void run() {
        System.out.println("Oh, I am runnable");
    }
}
