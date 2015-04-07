package com.tedneward.example;

import java.beans.*;
import java.util.*;


public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int countInstances = 0;

  public class AgeComparator implements Comparator<Person>{
  	 
	 @Override
    public int compare(Person p1, Person p2) {
      return p2.getAge() - p1.getAge();
    }
  }
  
  @Override
  public int compareTo(Person p2) {
  		if (this.getSalary() < p2.getSalary()) {
			return -1;
		} else if (this.getSalary() == p2.getSalary()) {
			return 0;
		} else {
			return 1;
		}
  }
  
  public static ArrayList<Person> getNewardFamily() {
  		Person Ted = new Person("Ted", 41, 250000);
		Person Charlotte = new Person("Charlotte", 43, 150000);
		Person Michael = new Person("Michael", 22, 10000);
		Person Matthew = new Person("Matthew", 15, 0);
		
		ArrayList<Person> family = new ArrayList<Person>();
		
		family.add(Ted);
		family.add(Charlotte);
		family.add(Michael);
		family.add(Matthew);
		
		return family;
  }
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    countInstances++;
  }

  public int count() {
    return countInstances;
  }

  public int getAge() {
    return age;
  }
  public void setAge(int value) {
    if(value < 0) {
      throw new IllegalArgumentException();
    }
    int old = age;
    age = value;

    this.pcs.firePropertyChange("age", old, value);
    propertyChangeFired = true;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String value) {
    if(value == null) {
      throw new IllegalArgumentException();
    }
    String old = name;
    name = value;

    this.pcs.firePropertyChange("name", old, value);
    propertyChangeFired = true;
  }
  
  public double getSalary() {
    return salary;
  }
  public void setSalary(int value) {
    double old = salary;
    salary = value;

    this.pcs.firePropertyChange("salary", old, value);
  }

  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Person other) {
    return (this.name.equals(other.name) && this.age == other.age);
  }

  public String tostring() {
    return "{{FIXME}}";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
