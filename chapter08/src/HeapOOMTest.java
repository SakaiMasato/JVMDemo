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
 *
 * notes: basically evey new object is created in Eden, once Eden is full, trigger the Minor GC.
 *        Minor GC will check the object is being occupied or not, if not release it, if yes move the object to Survivor.
 *        then add 1 to the age calculator.
 *
 *        if the Eden is full again, move the occupied object and copy all the object from Survivor1 (From Area)
 *        to the other free Survivor2 (To Area).
 *
 *        Minor GC will release the memory in Eden and Survivoe, but only the fullness of Eden will trigger MinorGC
 *
 *        the default behavior is the age calculator more then 15, will move the object to the Tenure generation
 *
 *        we can use "-XX:MaxTenuringThreshold=<n>"to modify the top value of the GC times(age calculator)
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
