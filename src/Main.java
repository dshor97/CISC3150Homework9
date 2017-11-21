import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        Lock L = new ReentrantLock();
    try{
        Condition T1 = L.newCondition();
        Condition T2 = L.newCondition();
        Condition T3 = L.newCondition();
        Condition T4 = L.newCondition();

        Thread1 t1 = new Thread1("AEIMQUY");
        Thread2 t2 = new Thread2("BFJNRVZ");
        Thread3 t3 = new Thread3("CGKOSW");
        ThreadD tD = new ThreadD("DHLPTX");

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread threadD = new Thread(tD);

        thread1.start();
        thread2.start();
        thread3.start();
        threadD.start();

        thread1.join();
        thread2.join();
        thread3.join();
        threadD.join();
    }catch(Throwable e){
        e.printStackTrace();
    }

    }
}

class Thread1 implements Runnable{
    char[] alph;
    Thread1(String a){
        alph = a.toCharArray();
    }
    public void run() {
        for(int i = 0; i<alph.length;i++){
            System.out.println(alph[i]);
        }
    }
}

class Thread2 implements Runnable{
    char[] alph;
    Thread2(String a){
        alph = a.toCharArray();
    }
    public void run() {
        for(int i = 0; i<alph.length;i++){
            System.out.println(alph[i]);
        }
    }
}

class Thread3 implements Runnable{
    char[] alph;
    Thread3(String a){
        alph = a.toCharArray();
    }
    public void run() {
        for(int i = 0; i<alph.length;i++){
            System.out.println(alph[i]);
        }
    }
}

class ThreadD implements Runnable{
    char[] alph;
    ThreadD(String a){
        alph = a.toCharArray();
    }
    public void run() {
        for(int i = 0; i<alph.length;i++){
            System.out.println(alph[i]);
        }
    }
}
