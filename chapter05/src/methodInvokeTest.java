public class methodInvokeTest {
    public static void main(String[] args){
        Son s =new Son();
        s.info();
    }
}

class Father {

    public Father(){
        System.out.println("This is Father`s init method");
    }

    public static void showStatic(){
        System.out.println("This is Father`s static method");
    }

    public final void showFinal(){
        System.out.println("this is Father`s final method");
    }

    private void showPrivate(){
        System.out.println("this is Father`s private method");
    }

    public void showCommonPublic(){
        System.out.println("this is Father`s common public method");
    }
}

class Son extends Father{
    public Son(){
        super();
    }

    public Son(String s){
        System.out.println("Son`s init method with one parameter");
    }

    private void showPrivate(){
        System.out.println("this is Son`s private method");
    }
    public void info(){
        //invokestatic调用的是父类的showStatic方法，因为static方法不能被重写
        showStatic();
        //invokespecial
        new Son("Son");
        //invokespecial
        new Son();
        //invokespecial
        super.showCommonPublic();
        //invokespecial
        showPrivate();
        //invokevirtual Final方法也被认为和虚方法同样的静态方法调用，但不是虚方法
        showFinal();
        //invokevirtual 因为子类可能重写showCommonPublic方法，先检查有没有重写，这里没有重写实际上父类的方法被执行
        showCommonPublic();

        IFace iface = new IFace() {
            @Override
            public void methodA() {
                System.out.println("This is Son`s implemented interface");
            }
        };
        //invokeInterface
        iface.methodA();
    }
}

interface IFace{
    public void methodA();
}
