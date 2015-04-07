package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public static class AgeComparator implements Comparator<Person> {
 
     @Override
     public int compare(Person p1, Person p2) {
 
          return p1.getAge() - p2.getAge();
     }

  }
  
  public int compareTo(Person other) {
   return - (int)(salary - other.salary);
  }
  
  public String toString() {
      return "[Person name:" + name + " age:" + age + " salary:"+ salary+"]";
  }
  
  @Override
  public boolean equals(Object other) {
      if (other instanceof Person) {
          Person p = (Person)other;
          return p.age == this.age && p.name == this.name;
      }
      return false;
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
    ssn = "";
  }

  public int getAge() {

      return age;
  }
  
 public void setAge(int a) {
     if(a < 0) {
         throw new IllegalArgumentException();
     }

     age = a;
 }
  
  public String getName() {

      return name;
  }
  
  public void setName(String n) {
      if(n == null) {
          throw new IllegalArgumentException();
      }

      name = n;
  }
  
  public double getSalary() {

      return salary;
  }
  
  public void setSalary(double s) {

      salary = s;
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