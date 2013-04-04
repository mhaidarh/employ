/**
 * SMTI06, M Haidar Hanif, 54411850
 * Part of Employ
 */

// CommissionPlusEmployee class extends CommissionEmployee.
// This class also has already extends the new version of class CommissionEmployee

public class CommissionPlusEmployee extends CommissionEmployee {

  private double baseSalary; // base salary per week

  // six-argument constructor
  public CommissionPlusEmployee(String first, String last,
                                String ssn, double sales, double rate, double salary) {
    super(first, last, ssn, sales, rate);
    setBaseSalary(salary); // validate and store base salary
  }

  // set base salary
  public void setBaseSalary(double salary) {
    baseSalary = (salary > 0) ? salary : 0; // non-negative
  }

  // return base salary
  public double getBaseSalary() {
    return baseSalary;
  }

  // calculate earnings; override method earnings in CommissionEmployee
  public double earnings() {
    return getBaseSalary() + super.earnings();
  }

  // return String representation of CommissionPlusEmployee object
  public String toString() {
    return String.format("%s %s; %s: $%,.2f",
                         "base-salaried", super.toString(),
                         "base salary", getBaseSalary());
  }
}
