/**
 * @description: 基于数组实现的最大堆
 * @author: Kevin
 * @createDate: 2020/2/21
 * @version: 1.0
 */
public class MaxHeap<E extends Comparable<E>> {
    // 成员变量 data  注：这里我使用的自己实现的动态数组！使用java的数组也可以
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 传入数组的构造函数
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //    返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 does not have parent.");
        return (index - 1) / 2;
    }

    //    返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //    返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //    向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //    元素上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 找到最大元素
    public E findMax() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Can not find from an empty heap!");
        return data.get(0);
    }

    // 移除最大元素
    public E extractMax() {
        E e = findMax();
        // 交换最大值和最后一个
        data.swap(0, data.getSize() - 1);
        // 移除最后一个即最大值
        data.removeLast();
        // 下沉操作，维护顺序
        siftDown(0);
        return e;
    }

    // 元素下沉
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(j, k);
            k = j;
        }
    }

}
