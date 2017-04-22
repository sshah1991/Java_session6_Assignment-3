public class Assignment6_3 implements Runnable{

    Account acc = new Account();

    public static void main(String[] args) {
        Assignment6_3 ts = new Assignment6_3();
        Thread t1 = new Thread(ts, "person 1");
        Thread t2 = new Thread(ts, "person 2");
        Thread t3 = new Thread(ts, "person 3");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            makeWithdraw(100);
            if (acc.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            deposit(200);
        }
    }


    private synchronized void makeWithdraw(int bal){
        if (acc.getBal()>=bal) {
            System.out.println(Thread.currentThread().getName()+" "+ "is try to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            acc.withdraw(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "is complete the withdraw");
        }else{        
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for withdraw ");
        }
    }

    private synchronized void deposit(int bal){
        if (bal>0) {
            System.out.println(Thread.currentThread().getName()+" "+ " is try to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            acc.deposit(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "is complete the deposit");
        }else{        
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for deposit");
        }
    }
}