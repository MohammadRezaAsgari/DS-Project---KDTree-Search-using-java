package com.sbu;

public class Myarray<T> {
    private T[] array;
    int count;


    public Myarray(int size) {
        array= (T[]) new Object[size];
        count=0;
    }

    public void addElement(T t) {
        if (array.length == count) {
            T[] newarray = (T[]) new Object[2 * count];
            for(int i=0;i<count;i++)
                newarray[i] = array[i];
            array = newarray;
        }
        array[count++] = t;
    }
    public int getsize(){
        return array.length;
    }

    public T get(int indx){
        return array[indx];
    }

    public boolean isempty(){
        return count == 0;
    }

    public void removeElementAt(int index){
        if (count > 0){
            int i;
            for(i=index; i< count-1;i++)
                array[i] = array[i + 1];
            array[i]=null;
            count--;
        }

    }
}