package parentsDelegate;

public class parentsDelegateTest {
    public static void main(String[] args){
        java.lang.String str = new java.lang.String();
        System.out.println("no custom String kinda message showing up, the String is not custom String");
        System.out.print(java.lang.String.class.getClassLoader());//null, cause BootStrapClassLoader cannot be got directly
    }
}


