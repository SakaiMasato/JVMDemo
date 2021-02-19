/**
 * VMS(Virtual Machine Stack) is generated in main thread, stackFrameA is created for methodA and stackFrameB for methodB
 * save the variables like i,j,k,l
 * instance vst is stored in the Heap but its address will be saved in the VMS
 */
public class VirtualStackTest {

    private void methodA(){

        int i = 10;
        int j = 20;
        methodB();
    }


    private void methodB(){

        int k = 30;
        int l = 40;
    }

    public static void main(String[] args){
        VirtualStackTest vst = new VirtualStackTest();
        vst.methodA();
    }
}
