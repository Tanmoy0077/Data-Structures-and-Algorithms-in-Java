package threads;
class Daemon extends Thread {
    public void run() {
        System.out.println("Daemon Child Thread");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
}

public class DaemonThreads {
    public static void main(String[] args) {
        Daemon d = new Daemon();
        System.out.println(d.isDaemon());
        d.setDaemon(true);
        System.out.println(d.isDaemon());
        d.start();
        System.out.println("End of main");
    }
}
