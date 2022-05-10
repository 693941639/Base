package Base.DuoTai;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        People p = new People();
        Sporter s = new Sporter();
        Class<People> clazz = People.class;

        Field aField = clazz.getField("s");
        System.out.println(aField.get(p));

        Field staticField = clazz.getField("I");
        System.out.println(staticField.get(null));

        Field privateField = clazz.getDeclaredField("d");
        privateField.setAccessible(true);
        System.out.println(privateField.get(p));

        Method normalFuc = clazz.getMethod("say", String.class);
        Object rel = normalFuc.invoke(p, "sss");
        System.out.println(rel.toString());

        Method staticFuc = clazz.getMethod("desc", Sporter.class);
        Object staticRel = staticFuc.invoke(null, s);
        System.out.println(staticRel.toString());

        Method privateFuc = clazz.getDeclaredMethod("testPrivate", boolean.class);
        privateFuc.setAccessible(true);
        boolean privateRel = (boolean) privateFuc.invoke(p, false);
        System.out.println(privateRel ? "true" : "false");
    }
}
