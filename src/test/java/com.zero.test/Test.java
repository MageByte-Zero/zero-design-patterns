import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        Test test = new Test();
//
//        String formula = "1=100000000-150000000;2=60000000-100000000;2=60000000-100000000";
//        final String pattern = "(\\d+=\\d+-\\d+;)*\\d+=\\d+-\\d+";
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//        Matcher matcher = r.matcher(formula);
//        boolean matches = matcher.matches();
//        System.out.println(matches);
//        List<String> monkeyBusiness = Arrays.asList("Chimp", "eat", "sleep", "", null, "banana",
//                "throw banana peel", null, "smile", "run");
//        Comparator<? super String> comparator = (a, b) -> a.compareTo(b);
//        monkeyBusiness.stream().sorted(Comparator.nullsFirst(comparator))
//                .forEach(x -> System.out.print("[" + x + "] "));
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        List b = null;
//        b.add(1);
        Collection subtract = CollectionUtils.subtract(a, b);
        System.out.println(subtract);
    }
}
