package threads;
class Display {
    public void greet(){
        for(int i=0;i<5;i++){
            System.out.println("Hello from Display "+Thread.currentThread().getName());
        }
        synchronized(this){
            for(int i=0;i<5;i++){
                System.out.println("Inside block "+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        for(int i=0;i<5;i++){
            System.out.println("Hello from Display "+Thread.currentThread().getName());
        }
    }
}

public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        Display d = new Display();
        Thread t1 = new Thread(){
            public void run() {
                d.greet();
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                d.greet();
            }
        };
        t1.start();
        t2.start();
    }
}
