package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import project3.DoublyLinkedList;
import project3.Location;



// assertTrue(statement) checks if the statement if true, if it is false the test fails
// assertFalse(statement) checks if the statement if false, if it is true the test fails
// assertEquals(object1,object2) checks if object1.equals(object2) is true, if that is false, the test fails

public class SubTest {


    @Test
    public void addObjectOnly(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        assertFalse(strings.add(null));
        assertTrue(strings.add("a"));
        assertEquals(strings.size(), 1);
        assertTrue(strings.add("b"));
        assertTrue(strings.add("c"));
        assertEquals(strings.size(), 3);
        assertTrue(strings.contains("a"));
        assertTrue(strings.contains("b"));
        assertTrue(strings.contains("c"));
        assertEquals(strings.indexOf("a"), 0);
        assertEquals(strings.indexOf("b"), 1);
        assertEquals(strings.indexOf("c"), 2);
        assertEquals(strings.get(0),"a");
        assertEquals(strings.get(1),"b");
        assertEquals(strings.get(2),"c");
    }


    @Test
    public void addWithIndex(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));
        assertTrue(strings.add("a"));

        assertFalse(strings.add(null,1));
        assertFalse(strings.add(null,2));
        assertFalse(strings.add(null,3));
        assertFalse(strings.add(null, strings.size() - 1));

        assertTrue(strings.add("1",0));
        assertEquals(strings.get(0),"1");
        assertEquals(strings.indexOf("1"),0);
        assertEquals(strings.size(),10);

        assertTrue(strings.add("2",5));
        assertEquals(strings.get(5),"2");
        assertEquals(strings.indexOf("2"),5);
        assertEquals(strings.size(),11);

        assertTrue(strings.add("3", strings.size()));
        assertEquals(strings.get(strings.size()-1),"3");
        assertEquals(strings.indexOf("3"),strings.size()-1);
        assertEquals(strings.size(),12);


    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addWithIndexException1(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a",-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addWithIndexException2(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a",69);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addWithIndexException3(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a",strings.size() + 1);
    }

    @Test
    public void clear1(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("c",1);
        strings.clear();
        assertEquals(strings.size(),0);
        assertTrue(strings.isEmpty());

    }

    @Test
    public void clear2(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        assertEquals(strings.size(),0);
        assertTrue(strings.isEmpty());

    }

    @Test
    public void contains1(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        assertTrue(strings.contains("a"));
        assertTrue(strings.contains("b"));
        assertTrue(strings.contains("c"));
        assertTrue(strings.contains("d"));
        assertTrue(strings.contains("e"));
        assertFalse(strings.contains("h"));
        assertFalse(strings.contains(null));
        assertFalse(strings.contains('a'));
        assertFalse(strings.contains(1.23));
        assertFalse(strings.contains(1));

    }

    @Test
    public void contains2(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();

        assertFalse(strings.contains("h"));
        assertFalse(strings.contains(null));
        assertFalse(strings.contains('a'));
        assertFalse(strings.contains(1.23));
        assertFalse(strings.contains(1));

    }

    @Test
    public void equals1(){

        DoublyLinkedList<String> strings1 = new DoublyLinkedList<>();
        DoublyLinkedList<String> strings2 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();

        //@TODO check if this is correct implementation
        assertEquals(strings1,integers);
        assertEquals(strings1,strings2);

        integers.add(1);
        strings1.add("a");
        strings2.add("b");

        assertNotEquals(integers,strings1);
        assertNotEquals(strings1,strings2);

        strings1.add("b");
        strings2.add("a",0);
        assertEquals(strings1,strings2);

        strings1.add("c");
        strings2.add("c",0);
        assertNotEquals(strings1,strings2);

        assertNotEquals(strings1,2332);

    }

    @Test
    public void getMethod(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        assertNull(strings.get(0));
        assertNull(strings.get(1));
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        assertEquals(strings.get(0),"a");
        assertEquals(strings.get(7),"h");
        assertNull(strings.get(8));
        assertNull(strings.get(-1));
        assertNull(strings.get(8000));
    }
    @Test
    public void emptyList(){
        DoublyLinkedList<Location> locations = new DoublyLinkedList<>();
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        assertTrue(strings.isEmpty());
        assertTrue(integers.isEmpty());
        assertTrue(locations.isEmpty());
        assertEquals(strings.size(), 0);
        assertEquals(integers.size(), 0);
        assertEquals(locations.size(), 0);

        strings.add("a");
        assertFalse(  strings.isEmpty());
        strings.clear();
        assertTrue(strings.isEmpty());
    }

    @Test
    public void indexOfMethod(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        assertEquals(strings.indexOf("a"),0);
        assertEquals(strings.indexOf("c"),2);
        assertEquals(strings.indexOf("e"),4);
        System.out.println(strings.indexOf("f"));

        assertEquals(strings.indexOf(1),-1);
        assertEquals(strings.indexOf(null),-1);
        assertEquals("a",strings.get(0));
        assertEquals("e",strings.get(4));
        assertEquals("c",strings.get(2));

    }

    @Test
    public void removeObjectMethod1(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        assertTrue(strings.remove("a") );
        assertTrue(strings.remove("b") );
        assertEquals(strings.size(),3);
        assertEquals(strings.get(0),"c");
        assertEquals(strings.get(2),"e");

    }

    @Test (expected = NullPointerException.class)
    public void removeObjectMethod2(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.remove(null);
    }

    @Test (expected = ClassCastException.class)
    public void removeObjectMethod3(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.remove( 1.0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIndexMethod1(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.remove( 1);
        assertEquals(strings.size(),4);
        assertFalse(strings.contains("b"));
        assertEquals(strings.get(0), "a");
        assertEquals(strings.get(1), "c");
        assertEquals(strings.get(3), "e");

        strings.remove( 0);
        assertEquals(strings.get(0), "c");
        assertEquals(strings.size(),3);
        assertEquals(strings.get(2), "e");

        strings.remove(2);
        assertEquals(strings.get(0), "c");
        assertEquals(strings.size(),2);
        assertEquals(strings.get(1), "d");


    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIndexMethod2(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.remove( 1);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIndexMethod3(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.remove( 3215);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void removeIndexMethod4(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.remove( -1);
    }


    @Test
    public void sizeMethod(){
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        assertEquals(strings.size(),0);
        strings.add("a");
        strings.add("a");
        assertEquals(strings.size(),2);
        assertEquals( strings.remove(1),"a");
        assertEquals(strings.size(),0);
    }

    @Test
    public void x()
    {
        
    }
}