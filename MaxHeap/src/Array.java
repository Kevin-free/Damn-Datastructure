/**
 * 动态数组 Array
 * 时间复杂度分析：
 * 增：O(n)
 * 删：O(n)
 * 改：已知索引 O(1); 未知索引 O(n)
 * 查：已知索引 O(1); 未知索引 O(n)
 * @param <E>
 */
public class Array<E> {
    //成员变量
    private E[] data;
    private int size;

    //构造函数,传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity]; //不能直接new 自定义类型的对象，间接new Object在转型
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在所有元素后添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    //在所有元素前添加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在指定位置index添加一个元素
    public void add(int index, E e) {
        // 如果插入的index不符合条件
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Require index >= 0 and index <= size");
        // 如果数组Array已满
        if (size == data.length)
            resize(2 * data.length);
        // 先将index后面的元素分别向后移动一位，从后往前开始
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e; //将index位置重新赋值
        size++; //数组元素个数++
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否包含元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i] == e);
            return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i] == e);
            return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --; //维护size
        data[size] = null; //to let GC do its work

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    // 删除数组中指定的元素e
    public boolean removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public void swap(int i,int j){
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) { //
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++ ){
            newData[i] = data[i];
        }
        data = newData;
    }

}
