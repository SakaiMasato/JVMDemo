/**
 * @author ：Bob
 * @date ：Created in 2021/4/25 23:47
 * @description：the testing of scalar replace
 * @modified By：
 * @version: 1$
 * @additionalFields: -Xms256M -Xmx256M -XX:+PrintGCDetails -XX:-EliminateAllocations (takes 98 ms and 3 MinorGC without EscapeAnalysis open)
 *                    -Xms256M -Xmx256M -XX:+PrintGCDetails -XX:+EliminateAllocations(takes 7 ms and no any GC with EscapeAnalysis open)
 */
public class ScalarReplaceTest {
    public static void main(String[] args) throws InterruptedException {
        ScalarReplaceTest srt = new ScalarReplaceTest();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            srt.alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end-start) +" ms");
        Thread.sleep(100000);
    }

    private void alloc(){
        User u = new User();
        u.name = "name";
        u.id = 1;
    }
}

