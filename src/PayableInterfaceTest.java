/**
 * Part of Employ
 */

// Tests interface Payable.

public class PayableInterfaceTest {

  public static void main(String args[]) {

    // create Payable array
    Payable payableObjects[] = new Payable[6];

    // populate array with objects that implement Payable from Employee and Invoice
    payableObjects[0] = new Invoice("00001", "heli", 3, 321.00);
    payableObjects[1] = new Invoice("10000", "carrier", 6, 78.90);
    payableObjects[2] = new SalariedEmployee("Nick", "Fury", "111-11-1111", 888.00);
    payableObjects[3] = new HourlyEmployee("Phil", "Coulson", "777-77-7777", 200, 20);
    payableObjects[4] = new CommissionEmployee("Maria", "Hill", "666-666-666", 2000, .02);
    payableObjects[5] = new BasePlusCommissionEmployee("Erik", "Selvig", "999-999-999", 3000, .02, 100);

    System.out.println("Invoices and Employees processed polymorphically:\n");

    // generically process each element in array payableObjects
    for (Payable currentPayable : payableObjects) {

      // output currentPayable and its appropriate payment amount if invoice
      if (currentPayable instanceof Invoice) {
        System.out.printf("%s \n%s: $%,.2f\n\n",
                          currentPayable.toString(),
                          "payment due", currentPayable.getPaymentAmount());
      }
      // output currentPayable and its appropriate payment amount if employee
      else {
        System.out.println(currentPayable);
        // determine whether element is a BasePlusCommissionEmployee
        if (currentPayable instanceof BasePlusCommissionEmployee) {
          // downcast Employee reference to BasePlusCommissionEmployee reference
          BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;
          double oldBaseSalary = employee.getBaseSalary();
          employee.setBaseSalary(1.10 * oldBaseSalary);
          System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
                            employee.getBaseSalary());
        }
        System.out.printf("earned $%,.2f\n\n", currentPayable.getPaymentAmount());
      }

    }

    // get type name of each object in payable objects array
    for (int j = 0; j < payableObjects.length; j++) {
      System.out.printf(
          payableObjects[j] instanceof Invoice ? "Payable %d is an %s\n" :
          "Payable %d is a %s\n", j, payableObjects[j].getClass().getName());
    }

  }

}
