/**
 * In Java, Threads and concurrency in general are handled by the Java Virtual Machine (JVM), by providing two
 * ways to interact with Threads:
 * 
 * 1) Extending the Thread class
 * 2) Implementing the Runnable interface
 * 
 * The JVM also includes a high-level construct for better handling concurrency and avoiding race-conditions
 * which is the Monitor, unlike C-based software which has to be managed manually with semaphores or Mutex/Futex
 * locks
 */

// Approach 1: Extending the Thread class
class Counter extends Thread {

    private static int counter;

    Counter() {
        counter = 0;
    }

    /**
     * The run() method implements the behavior of the Thread (or the 'templated' behavior of it)
     */
    public void run() {
        System.out.println("Thread ID:\t" + this.getId() + "\tIncrementing the counter by 1\t-->\tCounter:\t" + counter);
        counter++;
    }
}

// Approach 2: Implementing the Runnable Interface
class Multiplyer implements Runnable {

    private static int counter;

    Multiplyer() {
        counter = 1;
    }

    /**
     * The run() method implements the behavior of the Thread (or the 'templated' behavior of it)
     * same as the Thread class
     */
    @Override
    public void run() {
        System.out.println("- Thread ID:\t" + Thread.currentThread().getId() + "\tincrementing counter by 2\t-->\tCounter:\t" + counter);
        counter *= 2;
    }


}



/**
 * "Main class for the demonstration of the example"
 */
public class MultiTasker {

    public static void main(String[] args) {
        System.out.println("--- Java Threads Example ---");

        // Define the Thread objects from the respective classes

        // Declaring an array of 5 Threads ~ The ones that extend the Thread class
        Counter[] threads = new Counter[5];

        // Initialize the threads in the array, because we are only allocating the space
        // with the previous expression
        for (int k = 0; k < 5; k++) {
            threads[k] = new Counter();
        }

        // Run the threads
        for (int i = 0; i < 5; i++) {
            threads[i].start();

            // Make the thread sleep for a while to see that the program does indeed
            // wait for the threads to finish their execution before continuing the program
            try {
                threads[i].sleep(100);
            } catch (Exception e) {
                System.out.println("+++ Thread Exception +++");
                e.printStackTrace();
            }
        }

        // Let the threads run and wait until all threads finish their execution before
        // starting the other types of threads, which is done via the .join() method
        for (int j = 0; j < 5; j++) {
            try {
                threads[j].join();
            } catch (Exception e) {
                System.out.println("+++ Thread Exception +++");
                e.printStackTrace();
            }
        }

        /**
         * -------------------------------------------------------------------------------
         * - Pro-Tip: use fine-grained try-catch statements in your code in order to
         * create more fault-tollerant code and to gain a quicker debugging experience
         * when exceptions are raised, such as a Thread's uncontrolled execution
         * 
         * - Also, stay consistent with your print statement debug information so that 
         * you may distinguish the type of error with ease
         * -------------------------------------------------------------------------------
         */

        
        // Starting the second type of Threads, the ones that implement the runnable interface
        // Notice how the definition of the actual Thread changes since now we are passing a 
        // 'Runnable' Object to the Thread class (hence the name 'Runnable', because we can run it)
        Thread[] multiplyers = new Thread[5];

        // Same concept as the initialization of the threads of the threads array, but with
        // due syntax change
        for (int k = 0; k < 5; k++) {
            multiplyers[k] = new Thread(new Multiplyer());
        }
 
        // Start the Threads
        for (int i = 0; i < 5; i++) {
            multiplyers[i].start();
            
            try {
                multiplyers[i].sleep(100);
            } catch (Exception e) {
                /* 
                    - You could be more specific with the debug information
                    seems trivial in small scale scripts but can be a life changer
                    in large scale software
                    System.out.println("+++ Thread Exception No. 3 +++"); 

                    - The JVM does however have sufficient debug information
                    such as the line of code that triggered the exception
                 */
                System.out.println("+++ Thread Exception +++");
                e.printStackTrace();
            }
        }

        // Wait for the Threads to finish their execution
        for (int j = 0; j < 5; j++) {
            try {
                multiplyers[j].join();
            } catch (Exception e) {
                System.out.println("+++ Thread Exception +++");
                e.printStackTrace();
            }
        }


        System.out.println("***** Example Finished *****");

    }

}

/**
 * In summary, the difference between the two methods lies in their definitions and in some
 * lower-level details, more info at:
 * 
 * 1) https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html (Thread)
 * 2) https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html (Runnable)
 * 
 */