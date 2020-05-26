/**
 * @description: 线段树（基于数组实现）
 * @author: Kevin
 * @createDate: 2020/2/25
 * @version: 1.0
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            data[i] = arr[i];
//        }
        System.arraycopy(arr,0,data,0,arr.length);
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 在 treeIndex 的位置创建表示区间 [l,r] 的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
//        int mid = l + ((r - l) >> 1);
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return data[index];
    }

    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild(int index){
        return 2 * index + 2;
    }

    // 返回区间 [l,r] 的值
    public E query(int ql,int qr){
        if (ql < 0 || ql >= data.length || qr < 0 || qr >= data.length || ql > qr) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return query(0, 0, data.length - 1, ql, qr);
    }

    // 在以treeIndex为根的线段树中[l,r]的范围里，搜索区间[ql,qr]的值
    private E query(int treeIndex, int l, int r, int ql, int qr) {
        if (l == ql && r == qr) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int lTreeIndex = leftChild(treeIndex);
        int rTreeIndex = rightChild(treeIndex);

        if (ql >= mid + 1) {
            return query(rTreeIndex, mid + 1, r, ql, qr);
        } else if (qr <= mid) {
            return query(lTreeIndex, l, mid, ql, qr);
        }

        E leftResult = query(lTreeIndex, l, mid, ql, qr);
        E rightResult = query(rTreeIndex, mid + 1, r, ql, qr);
        return merger.merge(leftResult, rightResult);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else{
                res.append("null");
            }

            if (i != tree.length -1){
                res.append(",");
            }else{
                res.append("]");
            }
        }
        return res.toString();
    }
}
