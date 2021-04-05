/***
 * 1. the params to set the size of heap space
 *  -Xms: to set the initial size of heap space(Eden + Old)
 *        -X the param set in run time
 *        ms memory start
 *
 *  -Xmx: to set the max size of heap space(Eden + Old)
 *
 *  2. the default space size
 *      initial size: PC Memory / 64
 *      max size    : PC Memory / 4
 *
 *  3. common practice
 *      usually -Xms set the same value as -Xmx in case the perf issue which extension and release memory bring.
 *
 *  4. to review the JVM params set
 *     a: jps: to check the JVM process
 *        jstate -gc +"procId": to check the details of heap space
 *     b: -XX:+PrintGCDetails
 *
 *  5. we only use one of both survivor area one time, move all the things from one to the other
 */

public class HeapSpaceInitial {
    public static void main(String[] args){
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms: " + initialMemory + "Mb");
        System.out.println("-Xmx: " + maxMemory + "Mb");

        System.out.println("PC Memory: " + initialMemory * 64 / 1024 + "Gb");
        System.out.println("PC Memory: " + maxMemory * 4 / 1024 + "Gb");
    }
}
