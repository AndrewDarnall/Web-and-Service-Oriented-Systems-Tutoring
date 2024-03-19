/**
 * Consegna: Simulare il gioco dell'oca mediante 2 threads. 
 *           Essi dovevano lanciare un dado e avanzare di massimo 10 passi, il primo a raggiungere o 
 *           superare i 100 passi vinceva ed il programma terminava. Bisognava illustrare l'alternanza 
 *           tra i threads e gestire la mutua esclusione tra di essi.
 */
import java.util.Random;

 // The Shared Object
 class Shared {
 
     private int turn = 0;
 
     public int getTurn() {
         return turn;
     }
 
     public void setTurn(int indx) {
         turn = indx;
     }
 
 }
 
 class MyThread extends Thread {
 
     private Shared shm;
     private String tName = "Thread[";
     private int waitTime = 500;
     private int position = 0;
     private int index;
     private Random rand = new Random();
 
     // The constructor links the shared object with the thread, as seen in the SharingIsCaring.java example
     public MyThread(Shared mem, int index) {
         this.shm = mem;
         this.index = index;
         this.tName = tName + index + "]";
     }
 
     @Override
     public void run() {
 
         while(true) {
 
             try{
                 sleep(waitTime);
             } catch(InterruptedException e) {
                 e.printStackTrace();
             }
 
             // Defining concurrent-sensitive operations in the synchronized block
             synchronized (shm) {
 
                 if(shm.getTurn() == index) {
                     
                     position += ((rand.nextInt(10)) + 1);
                     System.out.println(tName + " advancing -> pos:\t" + position);
                     if(position >= 100) {
                         System.out.println(tName + " wins!");                
                         shm.setTurn(-1);
                         shm.notify();
                         break;
                     }
 
                     shm.setTurn(1 - index);
                     shm.notify();
                     
                     try {
                         shm.wait();
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
 
                 } else if(shm.getTurn() == -1) {
                     break;
                 }
 
             }
 
         }
 
     }
 
 }
 
 
 // Entry point for the solution
 public class Main {
 
     public static void main(String[] args) {
 
 
         Shared shared = new Shared();
         MyThread t0 = new MyThread(shared, 0);
         MyThread t1 = new MyThread(shared, 1);
 
         t0.start();
         t1.start();
 
         try{
             t0.join();
             t1.join();
         } catch(Exception e) {
             e.printStackTrace();
         }
 
         System.out.println("Game Over!");
 
     }
     
 }
 /**
  * Notice how in this solution, we implemented the synchronized block directly within the Thread
  * instead of the Shared object itself
  */