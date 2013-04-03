/**
 * Part of Employ
 */

// HourlyEmployee class extends Employee.

public class HourlyEmployee extends Employee {

  private double wage; // wage per hour
  private double hours; // hours worked for week

  // five-argument constructor
  public HourlyEmployee(String first, String last, String ssn,
                        double hourlyWage, double hoursWorked) {
    super(first, last, ssn);
    setWage(hourlyWage); // validate hourly wage
    setHours(hoursWorked); // validate hours worked
  }

  // set wage
  public void setWage(double hourlyWage) {
    wage = (hourlyWage < 0.0) ? 0.0 : hourlyWage;
  }

  // return wage
  public double getWage() {
    return wage;
  }

  // set hours worked
  public void setHours(double hoursWorked) {
    hours = ((hoursWorked >= 0.0) && (hoursWorked <= 168.0)) ?
            hoursWorked : 0.0;
  }

  // return hours worked
  public double getHours() {
    return hours;
  }

  // calculate earnings; override abstract method earnings in Employee
  public double earnings() {
    return getHours() <= 40 ? getWage() * getHours()
                            : 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
  }

  // return String representation of HourlyEmployee object
  public String toString() {
    return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
                         super.toString(), "hourly wage", getWage(),
                         "hours worked", getHours());
  }

}
