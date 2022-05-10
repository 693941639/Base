package Base.InterFace;

public interface InterfaceOne {
    default String say(String a) {
        return a;
    }

    void test();

    private void say() {
        System.out.println("hhhhh");
    }
}
