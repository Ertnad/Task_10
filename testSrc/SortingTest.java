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
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/testSortingFullNamesAndGroupAndCourse.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answerTestSortingFullNamesAndGroupAndCourse.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingFullNamesAndGroupAndOrderedCourse() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/testSortingFullNamesAndGroupAndOrderedCourse.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/src/TestCases/answerTestSortingFullNamesAndGroupAndOrderedCourse.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingFullNames() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/testSortingFullNames.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answerTestSortingFullNames.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingGroups() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/testSortingGroups.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answerTestSortingGroups.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }

  @Test
  public void testSortingCourses() throws FileNotFoundException {
    List<List<String>> input = ListUtils.loadStringList2FromFile("testSrc/TestCases/testSortingCourses.txt");
    List<List<String>> output = ListUtils.loadStringList2FromFile("testSrc/TestCases/answerTestSortingCourses.txt");

    List<List<String>> testResult = sorting.sortList(input);

    Assert.assertEquals(output, testResult);
  }
}
