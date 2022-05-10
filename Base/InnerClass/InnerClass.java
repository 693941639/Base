package Base.InnerClass;

public class InnerClass {
    double d = 0.0;

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
    }

    public InnerClass() {
        double a = 0.0;
    }

    public static class StaticInnerClass {

    }

    public class NormalInnerClass {
        private String desc;

        public NormalInnerClass(String desc) {
            this.desc = desc;
        }

        public double getD() {
            return InnerClass.this.d;
        }
    }
}
