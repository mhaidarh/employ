/**
 * Part of Employ
 */

// Employee hierarchy test program.

public class PayrollSystemTest {

  public static void main(String args[]) {

    // create subclass objects
    SalariedEmployee salariedEmployee =
        new SalariedEmployee("Steve", "Rogers", "111-11-1111", 500.00);
    HourlyEmployee hourlyEmployee =
        new HourlyEmployee("Bruce", "Banner", "222-22-2222", 200, 20);
    CommissionEmployee commissionEmployee =
        new CommissionEmployee("Clint", "Barton", "333-33-3333", 10000, .03);
    BasePlusCommissionEmployee basePlusCommissionEmployee =
        new BasePlusCommissionEmployee("Natasha", "Romanoff", "444-44-4444", 6000, .03, 200);
    PieceWorker pieceWorker =
        new PieceWorker("Tony", "Stark", "000-000-0000", 100, 200);

    System.out.println("Employees processed individually:\n");
    System.out.printf("%s\n%s: $%,.2f\n\n",
                      salariedEmployee, "earned", salariedEmployee.earnings());
    System.out.printf("%s\n%s: $%,.2f\n\n",
                      hourlyEmployee, "earned", hourlyEmployee.earnings());
    System.out.printf("%s\n%s: $%,.2f\n\n",
                      commissionEmployee, "earned", commissionEmployee.earnings());
    System.out.printf("%s\n%s: $%,.2f\n\n",
                      basePlusCommissionEmployee,
                      "earned", basePlusCommissionEmployee.earnings());
    System.out.printf("%s\n%s: $%,.2f\n\n",
                      pieceWorker, "earned", pieceWorker.earnings());

    // create Employee array
    Employee employees[] = new Employee[5];

    // initialize array with Employees
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;
    employees[4] = pieceWorker;

    System.out.println("Employees processed polymorphically:\n");

    // generically process each element in array employees
    for (Employee currentEmployee : employees) {
      System.out.println(currentEmployee); // invokes toString

      // determine whether element is a BasePlusCommissionEmployee
      if (currentEmployee instanceof BasePlusCommissionEmployee) {

        // downcast Employee reference to BasePlusCommissionEmployee reference
        BasePlusCommissionEmployee employee =
            (BasePlusCommissionEmployee) currentEmployee;
        double oldBaseSalary = employee.getBaseSalary();
        employee.setBaseSalary(1.10 * oldBaseSalary);
        System.out.printf(
            "new base salary with 10%% increase is: $%,.2f\n",
            employee.getBaseSalary());
      }

      System.out.printf(
          "earned $%,.2f\n\n", currentEmployee.earnings());
    }

    // get type name of each object in employees array
    for (int j = 0; j < employees.length; j++) {
      System.out.printf("Employee %d is a %s\n", j,
                        employees[j].getClass().getName());
    }

  }

}
