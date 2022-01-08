package intensive.project.collections;


import intensive.project.exception.ElementArrayException;
import intensive.project.exception.SizeArrayException;

import java.util.*;

/**
*@author Kirill
 * Class for implementation intensive.project.collections.Array with used sortAlgorithm
 */
public class Array<E > implements List<E> {

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
     *method added element in intensive.project.collections.Array
     *@throws RuntimeException if your input format is invalid
     */
    @Override
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
     *  @param index  - position for added element in intensive.project.collections.Array
     *  @throws RuntimeException if your input format is invalid
     *method added element in intensive.project.collections.Array
     */
    @Override
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
     *method get length intensive.project.collections.Array
     */
    @Override
    public int getSize(){
        return this.size;
    }


    /**
     * @NotNULL @param index - for returning an element
     *method returns an array element
     *@throws RuntimeException if your input format is invalid
     */
    @Override
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
    @Override
    public E[] getAll(){
        return array;
    }






    /**
     * @param index - position in intensive.project.collections.Array for added element
     *@throws RuntimeException if your input format is invalid
     */
    @Override
    public void set(E element, int index) {
        Optional.ofNullable(element).orElseThrow(()-> new SizeArrayException("parameter element = NULL, element can not be null"));

        if( index>=MIN_SIZE && index <= this.size) {
            this.array[index] = element;
        }else
        {
            throw new SizeArrayException("index = "  + index + " , index must not exceed the size of the array ");
        }
    }

    /**
     * @param index - position in intensive.project.collections.Array for delete element
     *@throws RuntimeException if your input format is invalid
     */
    @Override
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
     * method implements QuickSort for intensive.project.collections.Array
     * @param array for sorted
     * @param sort - Compares its two arguments for order
     * @param start - value of the beginning array
     * @param end - value of the end array
     */


}
