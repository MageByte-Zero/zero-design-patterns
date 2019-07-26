/**
 * @author jianqing.li
 * @date 2018/7/23
 */
public class HolderContext {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static int getValue() {
        return threadLocal.get();
    }

    public static void setValue(int value) {
        threadLocal.set(value);
    }
}
