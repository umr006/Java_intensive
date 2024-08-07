package ex02;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger cointer = new AtomicInteger();


    public void setCointer(AtomicInteger cointer) {
        cointer.set(0);
    }

    public int getCointer() {
        return cointer.get();
    }

    public void inc() {
        this.cointer.incrementAndGet();
    }

    public void dec() {
        this.cointer.decrementAndGet();
    }
}
