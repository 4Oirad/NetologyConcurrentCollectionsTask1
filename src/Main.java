public class Main {

    private static final int WAIT_CALLS = 2000;

    public static void main(String[] args) throws InterruptedException {

        ATS ats = new ATS();
        Thread threadATS = new Thread(()-> {
            try {
                ats.addCalls();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Operator operator = new Operator();
        Thread threadOperator1 = new Thread(() -> {
            try {
                operator.keepCall(ats);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Оператора 1");

        Thread threadOperator2 = new Thread(() -> {
            try {
                operator.keepCall(ats);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Оператор 2");
        Thread threadOperator3 = new Thread(() -> {
            try {
                operator.keepCall(ats);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "оператор 3");

        Thread threadOperator4 = new Thread(() -> {
                    try {
                        operator.keepCall(ats);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, "оператор 4");

        Thread threadOperator5 = new Thread(() -> {
                    try {
                        operator.keepCall(ats);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, "оператор 5");

        threadATS.start();
        Thread.sleep(WAIT_CALLS);
        threadOperator1.start();
        threadOperator2.start();
        threadOperator3.start();
        threadOperator4.start();
        threadOperator5.start();

        threadATS.join();
        threadOperator1.join();
        threadOperator2.join();
        threadOperator3.join();
        threadOperator4.join();
        threadOperator5.join();
    }
}
