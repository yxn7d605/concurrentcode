package com.home.yx.ch6;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("hello");
        System.out.println(myArrayList.toString());
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.remove("1");
        System.out.println(myArrayList.toString());
    }

    private static class MyArrayList<T> {
        private static final int DEFAULT_CAPACITY = 10;

        protected transient int modCount = 0;

        Object[] array = {};

        int size = 0;

        MyArrayList() {}

        void add(T obj) {
            ensureCapacityInternal(size + 1);
            Object[] newArray = Arrays.copyOf(array, size + 1);
            newArray[size] = obj;
            array = newArray;
            this.size++;
        }

        private void ensureCapacityInternal(int i) {
            ensureExplicitCapacity(calculateCapacity(array, i));
        }

        private void ensureExplicitCapacity(int minCapacity) {
            modCount++;

            // overflow-conscious code
            if (minCapacity - array.length > 0) {
                grow(minCapacity);
            }
        }

        private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

        private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = array.length;
            // 扩容两倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            array = Arrays.copyOf(array, newCapacity);
        }

        private static int hugeCapacity(int minCapacity) {
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return (minCapacity > MAX_ARRAY_SIZE) ?
                    Integer.MAX_VALUE :
                    MAX_ARRAY_SIZE;
        }

        private static int calculateCapacity(Object[] elementData, int minCapacity) {
            if (elementData.length == 0) {
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            }

            return minCapacity;
        }

        void remove(Object obj) {
            int n = 0;
            for (int i = 0; i < size; i++) {
                if (array[i].equals(obj)) {
                    n = i;
                    break;
                }
            }
            System.arraycopy(array, n + 1, array, n, size - (n + 1));
            array[--size] = null;
        }

        int size() {
            return size;
        }

        @Override
        public String toString() {
            return "MyArrayList{" +
                    "array=" + Arrays.toString(array) +
                    ", size=" + size +
                    '}';
        }
    }
}
