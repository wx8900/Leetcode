package mock.mutilThread;

/**
 * 多线程交替打印0-100的奇偶数
 */
public class PrintSD {

    //定义打印的方法
    public synchronized void print(String str){
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //定义打印奇数的线程类
    class A implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<100;i+=2){
                print("A"+i);
            }
        }
    }

    //定义打印偶数的线程类
    class B implements Runnable{
        @Override
        public void run() {
            for(int i=2;i<=100;i+=2){
                print("B"+i);
            }
        }
    }

    public static void main(String[] args) {
        PrintSD p = new PrintSD();
        A a = p.new A();
        B b = p.new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}

