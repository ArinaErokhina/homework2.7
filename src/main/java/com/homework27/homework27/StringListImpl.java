package com.homework27.homework27;

import java.util.Arrays;

public class StringListImpl implements StringList{

    private int size;
    private final String[] strings;

    public StringListImpl(int arraySize){
        strings = new String[arraySize];
    }

    public StringListImpl() {
        strings = new String[2];
    }

    private void validateItem(String item){
        if(item == null){
            throw new ItemNullException();
        }
    }

    private void validateSize(){
        if(size == strings.length){
            throw new StringsIsFullException();
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index > strings.length){
            throw new InvalidIndexException();
        }
    }

    public String add(String item){
        validateSize();
        validateItem(item);
        strings[size++] = item;

        return item;
    }

    public String add(int index, String item){
        validateSize();
        validateItem(item);
        validateIndex(index);
        if(index == size){
            strings[size++] = item;
            return item;
        }
        System.arraycopy(strings, index, strings, index + 1, size - index);
        strings[index] = item;
        size++;
        return item;
    }

    public String remove(String item){
        validateItem(item);
        int index = indexOf(item);
        if (index == -1){
            throw new ElementNotFoundException();
        }
        if (index==size){
            System.arraycopy(strings, index+1,strings, index, size - index);
        }
        size--;
        return item;
    }

    public String remove(int index){
        validateIndex(index);
        String item = strings[index];
        if (index==size){
            System.arraycopy(strings, index+1,strings, index, size - index);
        }
        size--;
        return item;
    }

    public String set(int index, String item){
        validateIndex(index);
        validateItem(item);
        strings[index] = item;
        return item;
    }

    public boolean contains(String item){
        return indexOf(item) != -1;
    }

    public int indexOf(String item){
        for (int i = 0; i < size; i++) {
            String a = strings[i];
            if(a.equals(item)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item){
        for (int i = size - 1; i >= 0; i--) {
            String a = strings[i];
            if(a.equals(item)){
                return i;
            }
        }
        return -1;
    }

    public String get(int index){
        validateIndex(index);
        return strings[index];
    }

    public boolean equals(StringList otherList){
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        size = 0;
    }

    public String[] toArray(){
        return Arrays.copyOf(strings, size);
    }
}
