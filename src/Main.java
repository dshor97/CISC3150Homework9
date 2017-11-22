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
    int charSize;
    char[] alph;
    Threads(String a){
        alph = a.toCharArray();
        charSize = alph.length;
    }
    public void run() {
        int i = 0;
        while(i < charSize){
            try {
                System.out.println(alph[i]);
                i++;
            }catch (Throwable t){
                t.printStackTrace();
            }
         }
    }
}
