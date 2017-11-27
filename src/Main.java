import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Alphabet a = new Alphabet();

        Thread1 t1 = new Thread1("AEIMQUY",a);
        Thread2 t2 = new Thread2("BFJNRVZ",a);
        Thread3 t3 = new Thread3("CGKOSW",a);
        ThreadD td = new ThreadD("DHLPTX",a);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread threadD = new Thread(td);

        thread1.start();
        thread2.start();
        thread3.start();
        threadD.start();

        a.startProc();
    }
}

class Alphabet{

    private final Lock lock;
    private String alphabet;
    Condition c1;
    Condition c2;
    Condition c3;
    Condition cD;


    Alphabet(){
        lock = new ReentrantLock();
        c1 = lock.newCondition();
        c2 = lock.newCondition();
        c3 = lock.newCondition();
        cD = lock.newCondition();
        alphabet = new String();
    }
    Lock getLock(){return lock;}

    void startProc(){
        try {
            lock.lock();
            Thread.sleep(1500);
            c1.signal();
        }catch (Throwable t){

        }finally{
            lock.unlock();
        }

    }

    void getChar(char c, int i){
        lock.lock();
        try{
            alphabet += c;
            if(i == 1){
                c2.signal();
            }else if(i == 2){
                c3.signal();
            }else if(i == 3){
                cD.signal();
            }else if(i == 4){
                c1.signal();
            }
        }catch (Throwable t){
            t.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class Thread1 implements Runnable{
    private final Lock lock;
    private final Alphabet alphabet;
    private char[] alph;
    private int alphSize;
    int pos;

    Thread1(String s, Alphabet A){
        alph = s.toCharArray();
        alphSize = alph.length;
        alphabet = A;
        lock = A.getLock();
        pos = 1;
    }
    public void run(){
        int i = 0;
        while(i < alphSize) {
            alphabet.getLock().lock();
            try {
                alphabet.c1.await();
                alphabet.getChar(alph[i],pos);
                System.out.print(alph[i] + " ");
                i++;
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                alphabet.getLock().unlock();
            }
        }
    }
}

class Thread2 implements Runnable{
    private final Lock lock;
    private final Alphabet alphabet;
    private char[] alph;
    private int alphSize;
    int pos;

    Thread2(String s, Alphabet A){
        alph = s.toCharArray();
        alphSize = alph.length;
        alphabet = A;
        lock = A.getLock();
        pos = 2;
    }
    public void run(){
        int i = 0;
        while(i < alphSize) {
            alphabet.getLock().lock();
            try {
                alphabet.c2.await();
                alphabet.getChar(alph[i],pos);
                System.out.print(alph[i] + " ");
                i++;
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                alphabet.getLock().unlock();
            }
        }
    }
}

class Thread3 implements Runnable{
    private final Lock lock;
    private final Alphabet alphabet;
    private char[] alph;
    private int alphSize;
    int pos;

    Thread3(String s, Alphabet A){
        alph = s.toCharArray();
        alphSize = alph.length;
        alphabet = A;
        lock = A.getLock();
        pos = 3;
    }
    public void run(){
        int i = 0;
        while(i < alphSize) {
            alphabet.getLock().lock();
            try {
                alphabet.c3.await();
                alphabet.getChar(alph[i],pos);
                System.out.print(alph[i] + " ");
                i++;
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                alphabet.getLock().unlock();
            }
        }
    }
}

class ThreadD implements Runnable{
    private final Lock lock;
    private final Alphabet alphabet;
    private char[] alph;
    private int alphSize;
    int pos;

    ThreadD(String s, Alphabet A){
        alph = s.toCharArray();
        alphSize = alph.length;
        alphabet = A;
        lock = A.getLock();
        pos = 4;
    }
    public void run(){
        int i = 0;
        while(i < alphSize) {
            alphabet.getLock().lock();
            try {
                alphabet.cD.await();
                alphabet.getChar(alph[i],pos);
                System.out.print(alph[i] + " ");
                i++;
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                alphabet.getLock().unlock();
            }
        }
    }
}