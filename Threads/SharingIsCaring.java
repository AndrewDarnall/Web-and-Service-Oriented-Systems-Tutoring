import java.util.Random;

/**
 * Sharing objects or variables among concurrent processes is no easy feat, and that is why Operating Systems such as 
 * Linux, through the POSIX interface, allowed engineers to use reliable systemcalls to avoid race conditions
 * and improve overall software performance without compromising its integrity and reliability
 * 
 * Java does the same, by relying on the same concurrent primitives which are exposed by the host Operating System
 * but exposing a higher-level construct to the engineer, such as a Syncrhonized block or an AtomicInteger object
 * 
 * In the following example we explore the synchronized block approach where we rely on the Java Virtual Machine
 * to manage lower level concurrency
 */


 /**
  * This will be our shared object with various fields that will be modified by other portions of our code
  * in this case, by our Threads (implemented either via the Thread class or Runnable Interface)
  */
  class SharedPerson {

    private String name;
    private int age;
    private String socialSecurity;

    SharedPerson(String name, int age, String socialSecurity) {
        this.name = name;
        this.age = age;
        this.socialSecurity = socialSecurity;
    }

    /*
     * There are 2 ways to define the synchronized behavior in Java, either define the synchronized blocks
     * within the code of the shared object itself (which is easy)
     * 
     * Or simply define it in the Thread's class by passing the reference of the Shared class itself
     * 
     * In a real world situation, the choice depends on the design and the requirements of the software
     *
     */
    public void changeName(String newName) {
       // synchronized (this) {
            this.name = newName;
       // }
    }

    public void changeAge(int newAge) {
       // synchronized (this) {
            this.age = newAge;
       // }
    }

    public void changeSocialSecurity(String newSocialSecurity) {
       // synchronized (this) {
            this.socialSecurity = newSocialSecurity;
       // }
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSocialSecurity() {
        return this.socialSecurity;
    }

    /**
     * The methods used in the class reflect the Command & Query paradigm which is always good to see in code
     * especially when written by top tier engineers
     */

  }

  /**
   * This is our first Thread class that will manipulate the shared object
   */
  class Actor extends Thread {

        String[] names = {"Alessia", "Tiffany", "Ian", "Alan", "Megan", "Omar", "Michionne", "Rick", "Negan", "Kirk", "Leia", "Padme", "Ahsoka", "The Doctor"};
        int[] ages = {18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 40};


        private SharedPerson person;

        // Initialize the Shared Object
        Actor(SharedPerson person) {
            this.person = person;
        }

        public void run() {
            // This is the aforementioned synchronized block of code, to which we pass a reference to the
            // shared class itself
             synchronized (SharedPerson.class) {
                // Within this block is a 'safe-zone' of sorts in which we can easily manipulate
                // the code in a concurrent-safe manner

                // Choose random values to add to the shared object
                Random random = new Random();
                int index = random.nextInt(14);

                // Change the name and age of the person randomly
                this.person.changeAge(ages[index]);
                this.person.changeName(names[index]);

                // Show the Object's State
                System.out.println("Thread ID:\t" + this.getId() + "\tName:\t" + this.person.getName() + "\tAge:\t" + this.person.getAge());

                
             }
        }

  }

 class SharingIsCaring {


    public static void main(String[] args) {
        System.out.println("----- Shared Object (Synchronized) Example -----");

        // Define the shared person
        SharedPerson p = new SharedPerson("Bill", 1, "BILLHARPER1985");

        // Allocate, initialize, spawn and wait for the execution of Threads
        Actor[] actors = new Actor[5];

        for (int k = 0; k < 5; k++) {
            actors[k] = new Actor(p);
        }

        for (int i = 0; i < 5; i++) {
            actors[i].start();
            try {
                actors[i].sleep(100);
            } catch (Exception e) {
                System.out.println("+++ Thread Expcetion +++");
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 5; j++) {
            try {
                actors[j].join();
            } catch (Exception e) {
                System.out.println("+++ Thread Exception +++");
                e.printStackTrace();
            }
        }

        System.out.println("****** End of Threads Shared Object Demo ******");

    }
 }

 // In summary, the JVM allows for a more flexible approach to Concurrency with the syncrhonized blocks
 // Also, do note that in Java, ---> every object has a monitor <---