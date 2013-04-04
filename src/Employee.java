/**
 * SMTI06, M Haidar Hanif, 54411850
 * Part of Employ
 */

// Employee abstract superclass.

public abstract class Employee {

  private String firstName;
  private String lastName;
  private String socialSecurityNumber;

  // three-argument constructor
  public Employee(String first, String last, String ssn) {
    firstName = first;
    lastName = last;
    socialSecurityNumber = ssn;
  }

  // set first name
  public void setFirstName(String first) {
    firstName = first;
  }

  // return first name
  public String getFirstName() {
    return firstName;
  }

  // set last name
  public void setLastName(String last) {
    lastName = last;
  }

  // return last name
  public String getLastName() {
    return lastName;
  }

  // set social security number
  public void setSocialSecurityNumber(String ssn) {
    socialSecurityNumber = ssn; // should validate
  }

  // return social security number
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  // return String representation of Employee object
  public String toString() {
    return String.format("%s %s\nsocial security number: %s",
                         getFirstName(), getLastName(), getSocialSecurityNumber());
  }

  // abstract method overridden by subclasses
  public abstract double earnings(); // no implementation here

}
