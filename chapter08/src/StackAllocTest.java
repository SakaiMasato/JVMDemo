/**
 * @author ：Bob
 * @date ：Created in 2021/4/25 23:18
 * @description：the testing of escape analysis
 * @modified By：
 * @version: 1$
 * @additionalFields: -Xms256M -Xmx256M -XX:-DoEscapeAnalysis -XX:+PrintGCDetails (takes 47 ms and 2 MinorGC without EscapeAnalysis open)
 *                    -Xms256M -Xmx256M -XX:+DoEscapeAnalysis -XX:+PrintGCDetails (takes 8 ms and no any GC with EscapeAnalysis open)
 *      actually no implement for escapeAnalysis in Oracle JDK, escapeAnalysis is still the theory not proven very well
 */
public class StackAllocTest {
    public static void main(String[] args) throws InterruptedException {
        StackAllocTest sat = new StackAllocTest();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sat.alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end-start) +" ms");
        Thread.sleep(100000);
    }

    private void alloc(){
        User u = new User();
    }
}

class User{
    String name;
    int id;
}
