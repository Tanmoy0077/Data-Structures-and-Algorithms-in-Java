package threads;
class Adder extends Thread {
    int total = 0;

    public void run() {
        System.out.println("Child Thread starting execution");
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("1st Sleep " + i);
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                this.total = this.total + i;
            }
            System.out.println("Sending notification to main");
            this.notify();
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("2nd Sleep " + i);
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        }
    }
}

public class InterThreadComm {
    public static void main(String[] args) {
        Adder a = new Adder();
        a.start();
        synchronized (a) {
            try {
                System.out.println("Main goes into waiting state");
                a.wait();
                System.out.println("Main recieved notification");
                System.out.println("The sum is : " + a.total);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
