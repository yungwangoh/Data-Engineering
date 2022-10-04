package org.example.homework1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements List<E> {

    // 데이터 추상화
    private Object[] data;

    public MyArrayList() {
        data = new Object[0];
    }

    @Override
    public String toString() {
        String result = "[";
        for(Object val : data) {
            result += " " + val + " ";
        }
        result += "]";
        return result;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for(Object val : data) {
            if(val.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<E>(data);
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < data.length) {
            a = (T[]) Array.newInstance(a.getClass().componentType(), data.length);
        }
        for(int i = 0; i < data.length; i++) {
            a[i] = (T) data[i];
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        // 1. 현재보다 크기가 한개 더 큰 배열 생성 newData
        Object[] newData = new Object[data.length + 1];

        // 2. 현재의 데이터 복사
        for(int i =0 ; i < data.length; i++) {
            newData[i] = data[i];
        }

        // 3. newData[index] = element
        newData[newData.length - 1] = e;

        // 4. newData가 data가 되게 참조.
        data = newData;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int ri = indexOf(o);
        if(ri == -1) return false;
        // ri가 지워야할 index
        // 1. 크기가 하나 작은 Object[] newData
        Object[] newData = new Object[data.length - 1];
        // 2. 복사 : ri 이전까지의 데이터를 복사 + ri 이후의 데이터를 복사
        for(int i = 0; i < data.length; i++) {
            if(i == ri) break;
            newData[i] = data[i];
        }
        for(int i = ri + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }

        // 3. 새로운 newData가 data
        data = newData;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        data = new Object[0];
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for length " + data.length);
        }
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for length " + data.length);
        }

        E previous = (E) data[index];
        data[index] = element;

        return previous;
    }

    @Override
    public void add(int index, E element) {
        if(index > data.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 1. 크기가 한개 더큰 object[] 생성 newData
        Object[] newData = new Object[data.length + 1];

        // 2. 기존의 data를 index 전 까지 newData 복사
        for(int i =0 ; i < data.length; i++) {
            if(i == index) break;
            newData[i] = data[i];
        }

        // 3. newData[index] = element
        newData[index] = element;

        // 4. 나머지 data를 index 이후 부터 복사
        for(int i = index; i < data.length; i++) {
            newData[i + 1] = data[i];
        }

        // data = newData
        data = newData;
    }

    @Override
    public E remove(int index) {
        if(index > data.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E previous = (E) data[index];

        Object[] newData = new Object[data.length - 1];

        for(int i = 0; i < data.length; i++) {
            if(i == index) break;
            newData[i] = data[i];
        }

        for(int i = index + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }
        data = newData;

        return previous;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < data.length; i++) {
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = data.length - 1; i >= 0; i--) {
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyArrayListIterator<E>(data, 0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyArrayListIterator<E>(data, index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
