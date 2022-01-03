package intensive.project;


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

    /**
     *variable storing size array
     */
    private int size;
    private E[] array;
    private  int lengthForCreateArray;

    /**
     * @return AllElements
     * method used for testCase
     */
    public E[] getAll(){
        return array;
    }

    /**
     *constructor without parameters create array with default size
     */
    public Array(){
        //this.array = (E[]) new Object[DEFAULT_SIZE];
        this.lengthForCreateArray = DEFAULT_SIZE;
    }

    /**
     * @param size - array length value
     *constructor with  parameter
     */
    public Array(int size){
        //this.array = (E[]) new Object[size];
        this.lengthForCreateArray = size;
    }


    /**
     * @param element - value for added array
     *method added element in intensive.project.Array
     */
    public void add(E element){
        if(this.lengthForCreateArray!=-1){
            this.array = (E[]) new Object[lengthForCreateArray];
            this.lengthForCreateArray=-1;
        }
        if(size==this.array.length){
            ensureCapacity(this.size+1);
        }
        this.array[this.size]=element;
        this.size++;

    }


    /**
     * @param element - value for added array
     * @param index  - position for added element in intensive.project.Array
     *method added element in intensive.project.Array
     */
    public void add(E element, int index){
        if( this.array.length==0){
            this.array = (E[]) new Object[lengthForCreateArray];
            this.lengthForCreateArray=-1;
        }
        if(size==this.array.length){
            ensureCapacity(this.size+1);
        }
        System.arraycopy(this.array, index, this.array, index + 1, size - index);
        this.array[index]=element;
        this.size++;
    }


    /**
     *method get length intensive.project.Array
     */
    public int getSize(){
        return this.size;
    }


    /**
     * @param index - for returning an element
     *method returns an array element
     */
    public  E get(int index){
        return this.array[index];
    }


    /**
     * @param index - position in intensive.project.Array for added element
     */
    public void set(int index,E element){
         this.array[index]=element;
    }

    /**
     * @param index - position in intensive.project.Array for delete element
     */
    public void remove(int index){
        int numMoved = size - index - 1;

        System.arraycopy(this.array, index + 1, this.array, index, numMoved);
        this.array[--this.size] = null;
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
    }

}
