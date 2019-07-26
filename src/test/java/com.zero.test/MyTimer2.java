import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MyTimer2 {

    private String name;
    private long timeOut;

    private Thread thread;

    public MyTimer2(String name, long timeOut) {
        this.name = name;
        this.timeOut = timeOut;
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer2 m1 = new MyTimer2("1 - ", 100);
        MyTimer2 m2 = new MyTimer2("2 - ", 160);
        MyTimer2 m3 = new MyTimer2("3 - ", 300);
        MyTimer2 m4 = new MyTimer2("4 - ", 380);

        m1.myTest();
        m2.myTest();
        m3.myTest();
        m4.myTest();
        TimeUnit.SECONDS.sleep(20);
    }

    /**
     * 在节点的处理线程消耗的时间过长时，计时器将调用{@link System#exit System.exit} 系统退出的方法，强制该节点的事务处理线程关闭。这个计时器是一个守护进程，
     * 所以当一个服务正常完整的关闭时，任务不会运行该程序。
     */
    public void startShutdownTimeout(long timeOut) {
        new Timer(true).schedule(new TimerTask() { // true，表示执行的线程是一个守护线程
            @Override
            public void run() {
                if (thread.isAlive()) {
                    System.out.println("线程" + name + "超时，执行守护线程 !");
                    // System.exit(1);
//                thread.stop();
                    thread.interrupt();// 发出中断信号
                }
            }
        }, timeOut);
    }

    public void myTest() {
        thread = new Thread(() -> {
            startShutdownTimeout(timeOut); // 该线程受到守护线程的作用
            System.out.println(name + "Begin");
            try {
                Thread.sleep(200); // 函数要执行至少200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "Over");
        });
        thread.start();
    }
}  