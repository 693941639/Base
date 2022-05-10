package Base.Generics;

import java.lang.reflect.Field;

public class GenericClass<First, Second> {
    private First first;
    private Second second;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = GenericClass.class.getDeclaredField("first");
        System.out.println(field.getType());
    }

    public GenericClass(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    public <Another> Another getAnother(Object o) {
        return (Another) o;
    }
}
