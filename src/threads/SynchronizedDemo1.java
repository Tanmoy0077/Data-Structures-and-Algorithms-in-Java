package threads;
class Printer {
    public synchronized void displayNum(){
        for(int i=0;i<10;i++){
            System.err.println(i);
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
    public synchronized void displayChars(){
        for(int i=65;i<75;i++){
            System.err.println((char)i);
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
}

class MyThread1 extends Thread{
    Printer p;
    MyThread1(Printer p){
        this.p = p;
    }
    public void run(){
        p.displayNum();
    }
}
class MyThread2 extends Thread{
    Printer p;
    MyThread2(Printer p){
        this.p = p;
    }
    public void run(){
        p.displayChars();
    }
}

public class SynchronizedDemo1 {
    public static void main(String[] args) {
        Printer p = new Printer();
        MyThread1 t1 = new MyThread1(p);
        MyThread2 t2 = new MyThread2(p);

        t1.start();
        t2.start();
    }
}
