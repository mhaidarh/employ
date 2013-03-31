/**
 * SMTI06, M Haidar Hanif, 54411850
 * Task Three
 */

// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.
// This class also has already extends the new version of class CommissionEmployee

public class BasePlusCommissionEmployee extends CommissionEmployee {

  private double baseSalary; // base salary per week

  // six-argument constructor
  public BasePlusCommissionEmployee(String first, String last,
                                    String ssn, double sales, double rate, double salary) {
    super(first, last, ssn, sales, rate);
    setBaseSalary(salary); // validate and store base salary
  }

  // set base salary
  public void setBaseSalary(double salary) {
    baseSalary = (salary < 0.0) ? 0.0 : salary; // non-negative
  }

  // return base salary
  public double getBaseSalary() {
    return baseSalary;
  }

  // calculate earnings; override method earnings in CommissionEmployee
  public double earnings() {
    return getBaseSalary() + super.earnings();
  }

  // get payment amount; override method earnings in CommissionEmployee
  // this acts in the Payable hierarchy as extended subclass
  // though it's basically the same with earnings
  public double getPaymentAmount() {
    return getBaseSalary() + super.earnings();
  }

  // return String representation of BasePlusCommissionEmployee object
  public String toString() {
    return String.format("%s %s; %s: $%,.2f",
                         "base-salaried", super.toString(),
                         "base salary", getBaseSalary());
  }
}
