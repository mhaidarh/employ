/**
 * SMTI06, M Haidar Hanif, 54411850
 * Part of Employ
 */

// SalariedEmployee class extends Employee.

public class SalariedEmployee extends Employee {

  private double weeklySalary;

  // four-argument constructor
  public SalariedEmployee(String first, String last, String ssn,
                          double salary) {
    super(first, last, ssn); // pass to Employee constructor
    setWeeklySalary(salary); // validate and store salary
  }

  // set salary
  public void setWeeklySalary(double salary) {
    weeklySalary = salary <= 0 ? 0 : salary;
  }

  // return salary
  public double getWeeklySalary() {
    return weeklySalary;
  }

  // calculate earnings; override abstract method earnings in Employee
  public double earnings() {
    return getWeeklySalary();
  }

  // return String representation of SalariedEmployee object
  public String toString() {
    return String.format("salaried employee: %s\n%s: $%,.2f",
                         super.toString(), "weekly salary", getWeeklySalary());
  }

}
