/**
 * Part of Employ
 */

// PieceWorker class extends Employee.
// for Payroll System Modification

public class PieceWorker extends Employee {

  private double wage; // wage per piece
  private double pieces; // number of pieces of merchandise produced

  public PieceWorker(String first, String last, String ssn,
                     int npmp, double wp) {
    super(first, last, ssn);
    setNumberOfPieces(npmp); // validate number of pieces
    setWagePerPiece(wp); // validate wage per piece
  }

  // set pieces
  public void setNumberOfPieces(int piecesProduced) {
    pieces = piecesProduced < 0 ? 0 : piecesProduced;
  }

  public double getNumberOfPieces() {
    return pieces;
  }

  // set wage
  public void setWagePerPiece(double wagePerPiece) {
    wage = wagePerPiece < 0 ? 0 : wagePerPiece;
  }

  // return wage
  public double getWage() {
    return wage;
  }

  // calculate earnings; override abstract method earnings in Employee
  public double earnings() {
    if (getNumberOfPieces() <= 0) // no zero work
      return 0.0;
    else
      return getNumberOfPieces() * getWage();
  }

  // get payment amount; override abstract method getPaymentAmount in Employee
  // this acts in the Payable hierarchy as subclass
  // although it's basically the same with earnings
  public double getPaymentAmount() {
    if (getNumberOfPieces() <= 0) // no zero work
      return 0.0;
    else
      return getNumberOfPieces() * getWage();
  }

  // return String representation of SalariedEmployee object
  public String toString() {
    return String.format("piece worker employee: %s\n%s: $%,.2f; %s: %,.2f",
                         super.toString(), "piece wage", getWage(),
                         "number of pieces", getNumberOfPieces());
  }

}
