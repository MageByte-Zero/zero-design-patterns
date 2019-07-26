import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jianqing.li
 * @date 2018/7/23
 */
public class ThreadLocalTest extends Thread {
    public static void main(String[] args) {
        new ThreadLocalTest().start();
        new ThreadLocalTest().start();
    }

    @Override
    public void run() {
        int age = new Random().nextInt(100);
        System.out.println("set thread [" + getName() + "] contextid to " + String.valueOf(age));
        HolderContext.setValue(age);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new BusinessService().businessMethod();
    }
}
