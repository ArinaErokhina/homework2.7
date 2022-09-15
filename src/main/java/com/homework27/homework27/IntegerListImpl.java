package com.homework27.homework27;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private int size;
    private Integer[] integers;

    public IntegerListImpl(int arraySize) {
        integers = new Integer[arraySize];
    }

    public IntegerListImpl(Integer[] integersCopy) {
        integers = new Integer[2];
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemNullException();
        }
    }

    private void validateSize() {
        if (size == integers.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > integers.length) {
            throw new InvalidIndexException();
        }
    }

    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        integers[size++] = item;

        return item;
    }

    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            integers[size++] = item;
            return item;
        }
        System.arraycopy(integers, index, integers, index + 1, size - index);
        integers[index] = item;
        size++;
        return item;
    }

    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index == size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }

    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integers[index];
        if (index == size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integers[index] = item;
        return item;
    }

    public boolean contains(Integer item) {
        Integer[] integersCopy = Arrays.copyOf(integers, size);
        sort(integersCopy);
        return binarySearch(integersCopy, item);
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer a = integers[i];
            if (a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer a = integers[i];
            if (a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return integers[index];
    }


    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    private static void swapElements(Integer[] integers, int indexA, int indexB) {
        int tmp = integers[indexA];
        integers[indexA] = integers[indexB];
        integers[indexB] = tmp;
    }

    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }

    private static void sort(Integer[] integers) {
        quickSort(integers, 0, integers.length-1);
    }

    public static void quickSort(Integer[] integers, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(integers, begin, end);

            quickSort(integers, begin, partitionIndex - 1);
            quickSort(integers, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] integers, int begin, int end) {
        int pivot = integers[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (integers[j] <= pivot) {
                i++;

                swapElements(integers, i, j);
            }
        }

        swapElements(integers, i + 1, end);
        return i + 1;
    }

    private boolean binarySearch(Integer[] integers, Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == integers[mid]) {
                return true;
            }

            if (item < integers[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        integers = Arrays.copyOf(integers, size + size / 2);
    }
}
