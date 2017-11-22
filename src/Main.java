import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args){

        try{
            Threads t1 = new Threads("AEIMQUY");
            Threads t2 = new Threads("BFJNRVZ");
            Threads t3 = new Threads("CGKOSW");
            Threads tD = new Threads("DHLPTX");

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

class Threads implements Runnable{
    char[] alph;
    Threads(String a){
        alph = a.toCharArray();
    }
    public void run() {
        for(int i = 0; i<alph.length;i++){
            System.out.println(alph[i]);
        }
    }
}