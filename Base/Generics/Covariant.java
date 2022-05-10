package Base.Generics;

import Base.DuoTai.People;
import Base.Oop.Children;
import Base.Oop.GrandParent;
import Base.Oop.Parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Covariant {
    public static void main(String[] args) {
        List<Parent> parent = new ArrayList<Parent>();
        parent.add(new Parent());
        parent.add(new Children());

        List<Children> children = new ArrayList<Children>();

        testOne(parent);
        testTwo(parent);
        testThree(children);

        List<? extends Parent> child = new ArrayList<Children>(){};
    }

    public static void testOne(List<? extends GrandParent> obj) {

    }

    public static void testTwo(List<? super Parent> obj) {

    }

    public static void testThree(List<? extends Children> obj) {

    }
}
