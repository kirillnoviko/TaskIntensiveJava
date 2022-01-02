import java.util.*;

public class Array<E > {

    private static final int DEFAULT_SIZE=10;
    private int size;
    private E[] array;

    public Array(){
        this.array = (E[]) new Object[DEFAULT_SIZE];
    }

    public Array(int size){
        this.array = (E[]) new Object[size];
    }

    public void add(E element){
        if(size==this.array.length){
            ensureCapacity(this.size+1);
        }
        this.array[this.size]=element;
        this.size++;

    }

    public void add(E element, int index){
        if(size==this.array.length){
            ensureCapacity(this.size+1);
        }
        System.arraycopy(this.array, index, this.array, index + 1, size - index);
        this.array[this.size]=element;
        this.size++;
    }

    public int getSize(){
        return this.size;
    }

    public  E get(int index){
        return this.array[index];
    }

    public void set(int index,E element){
         this.array[index]=element;
    }

    public void remove(int index){
        int numMoved = size - index - 1;

        System.arraycopy(this.array, index + 1, this.array, index, numMoved);
        this.array[--this.size] = null;
    }


    public void ensureCapacity(int minCapacity){
        if(minCapacity>this.array.length) {
            this.array = Arrays.copyOf(this.array, calculateNewCapacityOfArray(minCapacity));
            //System.arraycopy(this.array,0,this.array,0,minCapacity);
        }
    }

    public int calculateNewCapacityOfArray(int oldCapacity){
        return (oldCapacity*3/2)+1;
    }


}
