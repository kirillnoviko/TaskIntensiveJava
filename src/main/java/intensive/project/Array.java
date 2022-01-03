package intensive.project;


import intensive.project.exception.ElementArrayException;
import intensive.project.exception.SizeArrayException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
*@author Kirill
 * Class for implementation intensive.project.Array with used sortAlgorithm
 */
public class Array<E > {

    /**
     *static param for create array no parameters
     */
    private static final int DEFAULT_SIZE=10;
    private static final int MAX_SIZE = 2147483639;
    private static final int MIN_SIZE = 0;

    /**
     *variable storing size array
     */
    private int size;
    private E[] array;
    private  int lengthForCreateArray;

    /**
     *constructor without parameters create array with default size
     */
    public Array(){
        this.array = (E[]) new Object[0];
        this.lengthForCreateArray = DEFAULT_SIZE;
    }

    /**

     * @param size - array length value
     *constructor with  parameter
     *@throws RuntimeException if your input format is invalid
     */
    public Array(int size){
        if(size>=MIN_SIZE && size<=MAX_SIZE)
        {
            this.array = (E[]) new Object[0];
            this.lengthForCreateArray = size;
        }else
        {
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        }
    }


    /**
     * @param element - value for added array
     *method added element in intensive.project.Array
     *@throws RuntimeException if your input format is invalid
     */
    public void add( E element){
        Optional.ofNullable(element).orElseThrow(()-> new ElementArrayException("parameter element = NULL, element can not be null"));

        if(this.array.length==0){
            this.array = (E[]) new Object[lengthForCreateArray];
        }
        if(size==this.array.length){
            ensureCapacity(this.size+1);
        }
        this.array[this.size]=element;
        this.size++;

    }


    /**
     *  @param element - value for added array
     *  @param index  - position for added element in intensive.project.Array
     *  @throws RuntimeException if your input format is invalid
     *method added element in intensive.project.Array
     */
    public void add(E element, int index){
        Optional.ofNullable(element).orElseThrow(()-> new ElementArrayException("parameter element = NULL, element can not be null"));

        if( index>=MIN_SIZE && index <= this.size)
        {
            if(this.array.length==0){
                this.array = (E[]) new Object[lengthForCreateArray];
            }
            if(size==this.array.length){
                ensureCapacity(this.size+1);
            }
            System.arraycopy(this.array, index, this.array, index + 1, size - index);
            this.array[index]=element;
            this.size++;
        }else
        {
            throw new SizeArrayException("index = " + index + " , index must not exceed the size of the array ");
        }

    }


    /**
     *method get length intensive.project.Array
     */
    public int getSize(){
        return this.size;
    }


    /**
     * @NotNULL @param index - for returning an element
     *method returns an array element
     *@throws RuntimeException if your input format is invalid
     */
    public  E get(int index){
        if( index>=MIN_SIZE && index <= this.size) {
            return this.array[index];
        }
        else{
            throw new SizeArrayException("index = "  + index + " , index must not exceed the size of the array ");
        }
    }

    /**
     * @return AllElements
     * method used for testCase
     */
    public E[] getAll(){
        return array;
    }


    /**
     * @param index - position in intensive.project.Array for added element
     *@throws RuntimeException if your input format is invalid
     */
    public void set(int index,E element){
        Optional.ofNullable(element).orElseThrow(()-> new SizeArrayException("parameter element = NULL, element can not be null"));

        if( index>=MIN_SIZE && index <= this.size) {
            this.array[index] = element;
        }else
        {
            throw new SizeArrayException("index = "  + index + " , index must not exceed the size of the array ");
        }
    }

    /**
     * @param index - position in intensive.project.Array for delete element
     *@throws RuntimeException if your input format is invalid
     */
    public void remove(int index){
        if( index>=MIN_SIZE && index <= this.size) {

            int numMoved = size - index - 1;
            System.arraycopy(this.array, index + 1, this.array, index, numMoved);
            this.array[--this.size] = null;

        }else
        {
            throw new SizeArrayException("index = "  + index + " , index must not exceed the size of the array ");
        }

    }


    private void ensureCapacity(int minCapacity){
        if(minCapacity>this.array.length) {
            this.array = Arrays.copyOf(this.array, calculateNewCapacityOfArray(minCapacity));
            //System.arraycopy(this.array,0,this.array,0,minCapacity);
        }
    }

    private int calculateNewCapacityOfArray(int oldCapacity){
        return (oldCapacity*3/2)+1;
    }

    /**
     * method implements QuickSort for intensive.project.Array
     * @param array for sorted
     * @param sort - Compares its two arguments for order
     * @param start - value of the beginning array
     * @param end - value of the end array
     */
    public  Array<E> quickSort(Array<E> array, Comparator<E> sort, int  start, int end){
        Optional.ofNullable(array).orElseThrow(()-> new ElementArrayException("parameter array = NULL, array can not be null"));
        Optional.ofNullable(sort).orElseThrow(()-> new ElementArrayException("parameter sort = NULL, sort can not be null"));

        if(start>=0 && start<=this.size && end>=0 && end<=this.size){
            E middleElement = array.get((start+end)/2);
            int i = start, j = end;

            while (i <= j) {

                while (sort.compare(array.get(i),middleElement) < 0) {
                    i++;
                }
                while (sort.compare(array.get(j),middleElement) > 0) {
                    j--;
                }

                if (i <= j) {
                    E temp = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
                    i++;
                    j--;
                }
            }

            if (start < j)
                quickSort(array,sort, start, j);
            if (end > i)
                quickSort(array,sort, i, end);

            return array;
        }else{
            throw new SizeArrayException("parameters start and end must not exceed the size of the array ");
        }
    }

}
