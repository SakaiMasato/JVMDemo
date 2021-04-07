import java.util.ArrayList;
import java.util.Random;

/**
 * @author ：Bob
 * @date ：Created in 2021/4/7 14:47
 * @description：the OOM Error Testing of heap
 * @modified By：
 * @version: $
 */

/**
 * -XX:NewRatio=2: to set the YoungGen:OldGen = 2:1
 * -XX:-useAdaptiveSizePolicy: to close the adaptive size policy
 *
 * -XX:SurvivorRatio=8: to set the Eden:S0:S1 = 8:1:1
 *
 * -Xmn300m: to set the size of YoungGen(usually default one)
 */
public class HeapOOMTest {
    public static void main(String[] args){
        ArrayList<Picture> list = new ArrayList<>();
        int index = 0;
        while (true){
            try{
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024*1024)));
            index ++;
        }
    }
}

class Picture {
    private byte[] pixels;

    public Picture(int length){
        this.pixels = new byte[length];
    }
}
