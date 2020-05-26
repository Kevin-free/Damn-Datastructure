import java.util.HashMap;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/25
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        SegmentTree<Integer> st = new SegmentTree<>(nums, (a, b) -> a + b);
//        System.out.println(st);
        System.out.println(st.query(0, 2));
    }
}
