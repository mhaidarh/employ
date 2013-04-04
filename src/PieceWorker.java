/**
 * SMTI06, M Haidar Hanif, 54411850
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
    pieces = piecesProduced > 0 ? piecesProduced : 0;
  }

  // return pieces
  public double getNumberOfPieces() {
    return pieces;
  }

  // set wage
  public void setWagePerPiece(double wagePerPiece) {
    wage = wagePerPiece > 0 ? wagePerPiece : 0;
  }

  // return wage
  public double getWage() {
    return wage;
  }

  // calculate earnings; override abstract method earnings in Employee
  public double earnings() {
    return getNumberOfPieces() > 0 ? getNumberOfPieces() * getWage() : 0;
  }

  // return String representation of SalariedEmployee object
  public String toString() {
    return String.format("piece worker employee: %s\n%s: $%,.2f; %s: %,.2f",
                         super.toString(), "piece wage", getWage(),
                         "number of pieces", getNumberOfPieces());
  }

}
