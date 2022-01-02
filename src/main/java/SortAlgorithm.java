import java.util.Comparator;

public class SortAlgorithm<E> {
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