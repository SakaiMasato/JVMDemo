package java.lang;

public class String {

    static {
        System.out.println("Custom String cls, should print out once this cls loading");
    }

    //absolutely it is impossible main here, cause there is no main block in the cls loaded by BootStrapClassLoader-沙箱安全机制
    public static void main(String[] args){

        System.out.println("is there any issue involve main function here?");
    }
}