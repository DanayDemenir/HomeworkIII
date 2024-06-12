import com.google.common.collect.Lists;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");
        System.out.println(names.get (1));
    }
}