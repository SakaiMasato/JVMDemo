/**
 * @author ：Bob
 * @date ：Created in 2021/4/25 20:21
 * @description：
 *      -XX:+PrintFlagsInitial : check all parameters with default value
 *          jps : the running process
 *          jinfo -flag <param> <processId> : the default value of the specific param
 *      -XX:+PrintFlagsFinal : check all parameter with final value
 *      -Xms : initial memory of the heap
 *      -Xmx : max memory of the heap
 *      -Xmn : young generation size
 *      -XX:NewRatio : Young : old
 *      -XX:SurvivorRatio : Eden : S0/S1 in the Young generation
 *      -XX:MaxTenuringThreshold : the latest age of young generation
 *      -XX:PrintGCDetails: GC Details
 *      -XX:PrintGC & -verbose:gc : short GC info
 *      -XX:HandlePromotionFailure : 空间分配担保(当老年代的连续内存大小大于新生代的大小或者大于历次晋升的平均大小则启动minor GC, 反之FUll GC)
 * @modified By：
 * @version: $
 */
public class HeapArgsTest {
}
