package other.CS570.hw4;

public class PairInt {
  private int x;
  private int y;

  public PairInt(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public boolean equals(PairInt p) {
    if (p.getX() == x && p.getY() == y)
      return true;
    return false;
  }

  public String toString() {
    return '(' + String.valueOf(x) + ','+ String.valueOf(y) + ')';
  }

  // return a new copy of a PairInt
  public PairInt copy() {
    PairInt p = new PairInt(x, y);
    return p;
  }
}
