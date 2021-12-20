package ru.vsu.sc.tretyakov_d_s;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ru.vsu.sc.tretyakov_d_s.Utils.ListUtils;


public class Sorting {

  public List<List<String>> sortList(List<List<String>> list) {

    List<StudentCase> studentsList = toStudentsList(list);
    studentsList.sort(Comparator.comparing(StudentCase::getCourse)
        .thenComparing(StudentCase::getGroup).thenComparing(StudentCase::getFullName));


    List<List<String>> sortedList = new ArrayList<>();

    for (StudentCase studentCase : studentsList) {
      List<String> count = studentsToStringList(studentCase);
      sortedList.add(count);
    }
    return sortedList;
  }

  private List<String> studentsToStringList(StudentCase students) {
    String str = students.toString();
    return ListUtils.toList(str);
  }

  private List<StudentCase> toStudentsList(List<List<String>> list) {
    List<StudentCase> newList = new ArrayList<>(list.size());

    for (int i = 0; i < list.size(); i++) {
      newList.add(i, new StudentCase(list.get(i)));
    }
    return newList;
  }

}
