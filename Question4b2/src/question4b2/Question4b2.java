/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question4b2;

/**
 *
 * @author bazil
 */
public class Question4b2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FloristAndBall task1= new FloristAndBall();
        FloristAndBall task2 = new FloristAndBall();
        Thread thread1 = new Thread(task1);
        
        
        thread1.start();
      
        
    }
    
}
