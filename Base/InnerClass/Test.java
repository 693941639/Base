package Base.InnerClass;

public class Test {
    public static void main(String[] args) {
        InnerClass.StaticInnerClass sic = new InnerClass.StaticInnerClass();

        InnerClass ic = new InnerClass();
        InnerClass.NormalInnerClass nic = ic.new NormalInnerClass("aaa");
    }
}


