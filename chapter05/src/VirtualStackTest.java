/**
 * VMS(Virtual Machine Stack) is generated in main thread, stackFrameA is created for methodA and stackFrameB for methodB
 * save the variables like i,j,k,l
 * instance vst is stored in the Heap but its address will be saved in the VMS
 */

/**
 * classification of variables
 *
 * by the type of data: 1. basic dataType 2. reference data type
 *
 * by where variables is defined in the class:
 * 1. member variables
 *      before using, the default value will be set in the prepare of linking stage and the initialize stage will set the value explicitly
 * 2. instance variable
 *      will allocate the space in heap and set the default value while created
 *
 * a. local variables
 *      have to give the value before using it
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

    private void methodC(){
        int a = 0;
        {
            int b = 1;
            b = a + 1;
        }
        //c will use the slot which was created for b
        //reuse the slot
        int c = 2;
    }

    public static void main(String[] args){
        VirtualStackTest vst = new VirtualStackTest();
        vst.methodA();
    }
}
