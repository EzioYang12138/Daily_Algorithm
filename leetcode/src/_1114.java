import java.util.concurrent.CountDownLatch;

//https://leetcode-cn.com/problems/print-in-order/

public class _1114 {

    private final CountDownLatch second = new CountDownLatch(1);
    private final CountDownLatch third = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        printThird.run();
    }
}
