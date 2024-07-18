package threads;
class A {
    public synchronized void greetA(B b) {
        System.out.println("Inside Method of A");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("Calling Method of B");
        b.reply();
    }

    public synchronized void reply() {
        System.out.println("Inside reply of A");
    }
}

class B {
    public synchronized void greetB(A a) {
        System.out.println("Inside Method of B");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("Calling Method of A");
        a.reply();
    }

    public synchronized void reply() {
        System.out.println("Inside reply of B");
    }
}

public class Deadlock {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread() {
            public void run() {
                a.greetA(b);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                b.greetB(a);
            }
        };
        t1.start();
        t2.start();
    }
}
