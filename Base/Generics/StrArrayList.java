package Base.Generics;

import java.util.ArrayList;
import java.util.List;

public class StrArrayList {
    public static void main(String[] args) {
        StrArrayList sa = new StrArrayList();
        sa.useStrArrList();
    }

    public void useStrArrList() {
        List<String> ret = this.create();

        for (String s : ret) {
            System.out.println(s);
        }
    }

    public List<String> create() {
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ret.add("str" + i);
        }

        return ret;
    }
}
