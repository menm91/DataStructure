package me.qianlv.basic;

/**
 * 数组
 *
 * @author 小树
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 初始化数组容量
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认构造
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 向数组末尾添加元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向数组开始添加元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    public void add(int index, int e) {
        if (size >= data.length) {
            throw new IllegalArgumentException("Add failed! Array is full!");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed! Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed! Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 数组中是否包含元素
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素的索引,若是不包含则返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素,返回删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed! Index is illegal.");
        }

        int ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * 丛数组中删除第一个元素,返回删除的元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素,返回删除的元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e
     * @return
     */
    public boolean removeElement(int e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


class TestArray {
    public static void main(String[] args) {
        Array array = new Array();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.add(2, 5);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        System.out.println(array.get(3));
    }
}