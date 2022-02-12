package org.degelad.races;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author degelad
 */
public class Car implements Runnable {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier barrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if (ai.incrementAndGet() == 1) {
                System.out.println(name + " WIN !");
            }
            if (ai.get() == 2) {
                System.out.println(name + " II место");
                }
            if (ai.get() == 3) {
                System.out.println(name + " III место");
                }
            if (ai.get() == 4) {
                System.out.println(name + " IV место");
                }
            
            barrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
