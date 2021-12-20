package ru.vsu.sc.tretyakov_d_s;

import java.util.List;

public class StudentCase {

  private final String fullName;
  private final int group;
  private final int course;


  public StudentCase(List<String> list) {
    this.fullName = list.get(0);
    this.group = Integer.parseInt(list.get(1));
    this.course = Integer.parseInt(list.get(2));
  }

  public String getFullName() {
    return fullName;
  }

  public int getGroup() {
    return group;
  }

  public int getCourse() {
    return course;
  }

  public String toString() {
    return String.format("%s %s %s", fullName, group, course);
  }

}