package org.example;

import java.util.concurrent.CountDownLatch;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch endMeals = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new PhilosofersDinnary(endMeals, new Philosof(String.valueOf(i))));
            thread.setDaemon(true);
            thread.start();
        }
        endMeals.await();
        System.out.println("Все пообедали");
    }
}