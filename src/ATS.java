import java.util.concurrent.ArrayBlockingQueue;

public class ATS {

    private static final int LIMIT_ATS = 100;
    private static final int CALL_GENERATION = 2000;
    private static final int CALLS_PER_SECOND = 5;

    private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(LIMIT_ATS, true);
    private int clientNumber = 1;

    public void addCalls() throws InterruptedException {
        System.out.println("Включение АТС");
        System.out.println("Начало поступления звонков...");
        while (true) {
            if (arrayBlockingQueue.size() < LIMIT_ATS - CALLS_PER_SECOND) {
                Thread.sleep(CALL_GENERATION);
                for (int i = 0; i < CALLS_PER_SECOND; i++) {
                    arrayBlockingQueue.add(clientNumber);
                    clientNumber++;

                }
            }
            System.out.println("Звонков в очереди: " + arrayBlockingQueue.size());
        }
    }

    public ArrayBlockingQueue<Integer> getArrayBlockingQueue() {
        return arrayBlockingQueue;
    }
}