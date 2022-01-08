package intensive.project.collections.algorithm;

import intensive.project.collections.Array;
import intensive.project.collections.List;
import intensive.project.exception.ElementArrayException;
import intensive.project.exception.SizeArrayException;

import java.util.Comparator;
import java.util.Optional;

public class ActionForCollections<E> {

    public static <E> List<E> quickSort(List<E> array, Comparator<E> sort, int  start, int end){
        Optional.ofNullable(array).orElseThrow(()-> new ElementArrayException("parameter array = NULL, array can not be null"));
        Optional.ofNullable(sort).orElseThrow(()-> new ElementArrayException("parameter sort = NULL, sort can not be null"));

        if(start>=0 && start<=array.getSize() && end>=0 && end<=array.getSize()){
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
                    array.set(array.get(j),i);
                    array.set(temp,j);
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
