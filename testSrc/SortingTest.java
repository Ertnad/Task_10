import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.sc.tretyakov_d_s.Sorting;
import ru.vsu.sc.tretyakov_d_s.Utils.ListUtils;

public class SortingTest {

  Sorting sorting = new Sorting();

@Test
  public void testSortingFullNamesAndGroupAndCourse() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/test1.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answer1.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingFullNamesAndGroupAndOrderedCourse() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/test2.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/src/TestCases/answer2.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingFullNames() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/test3.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answer3.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingGroups() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/test4.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answer4.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingCourses() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/test5.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answer5.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }
}
