import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args){

        try{
            Thread1 t1 = new Thread1("AEIMQUY");
            Thread2 t2 = new Thread2("BFJNRVZ");
            Thread3 t3 = new Thread3("CGKOSW");
            ThreadD tD = new ThreadD("DHLPTX");
            Locks l = new Locks();

            Thread thread1 = new Thread(t1);
            Thread thread2 = new Thread(t2);
            Thread thread3 = new Thread(t3);
            Thread threadD = new Thread(tD);
            Thread lo = new Thread(l);

            thread1.start();
            thread2.start();
            thread3.start();
            threadD.start();
            lo.start();




        }catch(Throwable e){
            e.printStackTrace();
        }

    }
}

class Thread1 implements Runnable{
    Locks lock = new Locks();
    int charSize;
    char[] alph;
    Thread1(String a){
        alph = a.toCharArray();
        charSize = alph.length;
    }
    public void run() {
        int i = 0;
        while(i < charSize){
            lock.lock.lock();
            try {
                System.out.println("Waiting for the signal.");
                //lock.is1Print.awaitUninterruptibly();
                System.out.println("signal found.");
                System.out.println(alph[i]);
                i++;
                Thread.sleep(100);
            }catch (Throwable t){
                t.printStackTrace();
            }finally {
                lock.lock.unlock();
                lock.is2Print.signal();
            }
         }
    }
}
class Thread2 implements Runnable{
    Locks lock = new Locks();
    int charSize;
    char[] alph;
    Thread2(String a){
        alph = a.toCharArray();
        charSize = alph.length;
    }
    public void run() {
        int i = 0;
        while(i < charSize){
            lock.lock.lock();
            try {
                System.out.println("Waiting for the signal.");
                lock.is2Print.awaitUninterruptibly();
                System.out.println("signal found.");
                System.out.println(alph[i]);
                i++;
                Thread.sleep(100);
            }catch (Throwable t){
                t.printStackTrace();
            }finally {
                lock.lock.unlock();
                lock.is3Print.signal();
            }
        }
    }
}
class Thread3 implements Runnable{
    Locks lock = new Locks();
    int charSize;
    char[] alph;
    Thread3(String a){
        alph = a.toCharArray();
        charSize = alph.length;
    }
    public void run() {
        int i = 0;
        while(i < charSize){
            lock.lock.lock();
            try {
                System.out.println("Waiting for the signal.");
                lock.is3Print.awaitUninterruptibly();
                System.out.println("signal found.");
                System.out.println(alph[i]);
                i++;
                Thread.sleep(100);
            }catch (Throwable t){
                t.printStackTrace();
            }finally {
                lock.lock.unlock();
                lock.isDPrint.signal();
            }
        }
    }
}
class ThreadD implements Runnable{
    Locks lock = new Locks();
    int charSize;
    char[] alph;
    ThreadD(String a){
        alph = a.toCharArray();
        charSize = alph.length;
    }
    public void run() {
        int i = 0;
        while(i < charSize){
            lock.lock.lock();
            try {
                System.out.println("Waiting for the signal.");
                lock.isDPrint.awaitUninterruptibly();
                System.out.println("signal found.");
                System.out.println(alph[i]);
                i++;
                Thread.sleep(100);
            }catch (Throwable t){
                t.printStackTrace();
            }finally {
                lock.lock.unlock();
                lock.is1Print.signal();
            }
        }
    }
}

class Locks implements Runnable{
    public static final Lock lock = new ReentrantLock();
    public static final Condition is1Print = lock.newCondition();
    public static final Condition is2Print = lock.newCondition();
    public static final Condition is3Print = lock.newCondition();
    public static final Condition isDPrint = lock.newCondition();
    public static final Condition noPrint = lock.newCondition();

    public void run(){
        System.out.println("this is a test.");
        is1Print.signal();
    }
}
