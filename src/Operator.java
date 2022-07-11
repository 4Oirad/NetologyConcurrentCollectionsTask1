public class Operator {

    private static final int CALL_PROCESSING = 3000;

    public void keepCall(ATS ats) throws InterruptedException {
        while (!ats.getArrayBlockingQueue().isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " обрабатывает звонок от клиента " + ats.getArrayBlockingQueue().poll());
            Thread.sleep(CALL_PROCESSING);
        }

    }
}
