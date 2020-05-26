/**
 * 栈 接口
 * @param <E>
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e); //插入元素到栈顶
    E pop(); //取出栈顶元素
    E peek(); //查看栈顶元素
}
