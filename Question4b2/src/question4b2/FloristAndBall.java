/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question4b2;

import java.util.Scanner;

/**
 *
 * @author bazil
 */
public class FloristAndBall implements Runnable {

    double height = 0;
    String[] name = null;
    int[] orders;

    public FloristAndBall() {
    }

    @Override
    public void run() {
        enterDetails();
    }

    @SuppressWarnings("empty-statement")
    private void enterDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("How high did the ball drop");
        height = input.nextDouble();
        System.out.println("Enter number of customers");
        int cusOrd = input.nextInt();
        name = new String[cusOrd];
        orders = new int[cusOrd];
        for (int i = 0; i < name.length && i < orders.length; i++) {
            System.out.println("Enter name");
            name[i] = input.next();
            System.out.println("Enter Number of orders");
            orders[i] = input.nextInt();

        }

        System.out.println(name);

        synchronized (FloristAndBall.class) {
            processOrder(name, orders);
            ballBounce(height);

        }
    }

    private void ballBounce(double height) {

        int count = 0;
        while (height >= 0.05) {
            count = count + 1;
            height = height / 2;
            System.out.println("Count " + count + " ball bounced to height of " + height + "m");
        }
    }

    private void processOrder(String[] name, int[] orders) {
        double coupon;
        for (int i = 0; i < name.length && i < orders.length; i++) {
            System.out.println("Thank you customer: " + name[i]);
            if (orders[i] >= 2 && orders[i] <= 6) {
                coupon = orders[i] * 10;
                System.out.println("You receive a coupon of " +coupon);
            } else if (orders[i] >= 7 && orders[i] <= 15) {
                coupon = orders[i] * 11.5;
                System.out.println("You receive a coupon of " +coupon);
            } else if (orders[i] >= 16 && orders[i] <= 30) {
                coupon = orders[i] * 14;
                System.out.println("You receive a coupon of " +coupon);
            } else  if (orders[i] >= 31) {
                coupon = orders[i] * 17;
                System.out.println("You receive a coupon of " +coupon);
            }
            
        }
    }

}
