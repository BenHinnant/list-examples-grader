import static org.junit.Assert.*;
import org.junit.*;

public class TestListExamples {
  // Write your grading tests here!
  @Test 
	public void testFilter1() {
        ArrayList<String> input1 = new ArrayList<>();
        StringChecker sc = new ShortString();
        input1.add(0, "apple");
        input1.add(1, "banana");
        input1.add(2, "citrus");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "apple");
        assertEquals(expected, ListExamples.filter(input1, sc));
  }
  @Test 
	public void testFilter2() {
        ArrayList<String> input1 = new ArrayList<>();
        StringChecker sc = new ShortString();
        input1.add(0, "aloeverajelly");
        input1.add(1, "blop");
        input1.add(2, "wall");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "blop");
        expected.add(1, "wall");
        assertEquals(expected, ListExamples.filter(input1, sc));
  }
  @Test 
	public void testMerge1() {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("a");
        list1.add("c");
        list1.add("e");
        list2.add("b");
        list2.add("d");
        list2.add("f");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        assertEquals(expected, ListExamples.filter(list1, list2));
  }
}

class ShortString implements StringChecker {
  public boolean checkString(String s) { return s.length() < 6; }
}

