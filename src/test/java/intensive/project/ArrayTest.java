package intensive.project;

import intensive.project.collections.Array;
import intensive.project.collections.List;
import intensive.project.collections.algorithm.ActionForCollections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class ArrayTest {

    private Array array= new Array<Integer>();


    @BeforeEach
    public void setUp() throws Exception {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
    }

    @Test
    public void ShouldSortArray(){
        //
        // Given
        //
        List arrayTest= new Array<Integer>();
        arrayTest.add(3);
        arrayTest.add(1);
        arrayTest.add(4);
        arrayTest.add(5);
        arrayTest.add(6);
        arrayTest.add(2);


        //
        // When
        //
        arrayTest= ActionForCollections.quickSort(arrayTest, new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                if(c1<c2){
                    return -1;
                }else {
                    if (c1 > c2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }, 0, arrayTest.getSize()-1);



        //
        // Then
        //
        Assertions.assertArrayEquals(arrayTest.getAll(), array.getAll());
    }

    @Test
    public void ShouldAddElementByIndexArray(){
        //
        // Given
        //
        Array arrayTest= new Array<Integer>(5);
        arrayTest.add(1);
        arrayTest.add(2);
        arrayTest.add(4);
        arrayTest.add(5);
        arrayTest.add(6);

        //
        // When
        //
        arrayTest.add(3,2);


        //
        // Then
        //
        Assertions.assertArrayEquals(arrayTest.getAll(),array.getAll() );
    }



    @Test
    public void ShouldRemoveElementByIndexArray(){
        //
        // Given
        //
        Array arrayTest= new Array<Integer>();
        arrayTest.add(1);
        arrayTest.add(2);
        arrayTest.add(3);
        arrayTest.add(22);
        arrayTest.add(4);
        arrayTest.add(5);
        arrayTest.add(6);

        //
        // When
        //
        arrayTest.remove(3);


        //
        // Then
        //
        Assertions.assertArrayEquals(arrayTest.getAll(),array.getAll() );
    }
}