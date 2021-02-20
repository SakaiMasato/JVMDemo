public class OperandStackTest {
    private void test1(){

        int i0 = 10;
        int i1 = 10;
        i0++;
        ++i1;
    }

    /**
     *  0 bipush 10
        2 istore_1
        3 bipush 10
        5 istore_2
        6 iload_1
        7 iinc 1 by 1
        10 istore_3
        11 iinc 2 by 1
        14 iload_2
        15 istore 4
        17 return
     */
    private void test2(){

        int i0 = 10;
        int i1 = 10;
        int i2 = i0++;  //先load, 然后执行++, 但是load的值并没有经过++
        int i3 = ++i1;  //先++, 后load, load的值执行了++
        // guess i2 = 10, i3 = 11
        System.out.println("i2 : " + i2 +" "+"i3 : " + i3);

    }

    /**
     *  0 bipush 10
        2 istore_1
        3 bipush 10
        5 istore_2
        6 iload_1
        7 iinc 1 by 1
        10 istore_1
        11 iinc 2 by 1
        14 iload_2
        15 istore_2
        16 return
     */
    private void test3(){

        int i0 = 10;
        int i1 = 10;
        i0 = i0++;  //先load,后++,load的值没有经过++
        i1 = ++i1;  //先++,后load,load的值经过了++
        //guess i0 = 11, i1 = 11
        System.out.println("i0 : " + i0 +" "+"i1 : " + i1);

    }

    /**
     *  0 bipush 10
        2 istore_1
        3 bipush 10
        5 istore_2
        6 iload_1
        7 iinc 1 by 1
        10 iinc 2 by 1
        13 iload_2
        14 iadd
        15 istore_3
        16 return

     */
    private void test4(){

        int i0 = 10;
        int i1 = 10;
        int i2 = i0++ + ++i1;   //1 load后++, load的值没有经过++. 2 ++后load 2的值经过了++, 所以用来计算add时1加载的值是10，2加载的是11
        //guess i2 = 21
        System.out.println("i2 : " + i2);
    }
    public static void main(String[] args){
        OperandStackTest ost  = new OperandStackTest();
        ost.test1();
        ost.test2();
        ost.test3();
        ost.test4();
    }
}
