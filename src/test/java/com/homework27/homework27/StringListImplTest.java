package com.homework27.homework27;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.homework27.homework27.Constans.*;

public class StringListImplTest {

    private final StringListImpl stringList = new StringListImpl();

    @Test
    public void addTest(){
        Assertions.assertEquals(ABC, stringList.add(ABC));
    }

    @Test
    public void addInIndexTest(){
        stringList.add(0, BDC);
        Assertions.assertEquals(0, stringList.indexOf(BDC));
    }

    @Test
    public void removeTest(){
        stringList.add(BDC);
        Assertions.assertEquals(BDC, stringList.remove(BDC));
    }


    @Test
    public void removeInIndexTest(){
        stringList.add(ABC);
        stringList.add(BDC);
        Assertions.assertEquals(BDC, stringList.remove(1));
    }

    @Test
    public void setTest(){
        Assertions.assertEquals(VGS, stringList.set(1, VGS));
    }

    @Test
    public void containsTest(){
        stringList.add(BDC);
        Assertions.assertTrue(stringList.contains(BDC));
    }

    @Test
    public void indexOfTest(){
        stringList.add(0,VGS);
        stringList.add(1,BDC);
        Assertions.assertEquals(1, stringList.indexOf(BDC));
    }

    @Test
    public void lastIndexOf(){
        stringList.add(0,VGS);
        stringList.add(1,BDC);
        Assertions.assertEquals(0, stringList.lastIndexOf(VGS));
    }

    @Test
    public void getTest(){
        stringList.add(0,VGS);
        stringList.add(1,BDC);
        Assertions.assertEquals(BDC, stringList.get(1));
    }

    @Test
    public void equalsTest(){
        stringList.add(BDC);
        stringList.add(ABC);
        Assertions.assertTrue(stringList.equals(stringList));
    }

    @Test
    public void sizeTest(){
        stringList.add(BDC);
        stringList.add(ABC);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void isEmptyTest(){
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void clearTest(){
        stringList.add(BDC);
        stringList.add(ABC);
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void toArrayTest(){
        String[] expected = {BDC, ABC};
        stringList.add(BDC);
        stringList.add(ABC);
        Assertions.assertArrayEquals(expected, stringList.toArray());
    }
}
