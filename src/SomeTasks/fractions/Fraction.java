package SomeTasks.fractions;

/**
 * Created by Oksana on 18.12.2016.
 */
public class Fraction {
    private int p;
    private int q;

    public Fraction(int p, int q) {
        this.p = p;
        this.q = q;
    }

    public Fraction(String str) {
        try {
            this.p = FractionHelper.getPAndQFromString(str)[0];
            this.q = FractionHelper.getPAndQFromString(str)[1];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("String is invalid as fraction");
        }
    }


    @Override
    public String toString() {
        return p+"/"+q;
    }

    public Fraction divide(Fraction fraction) {
        return new Fraction(this.p*fraction.q, this.q*fraction.p).reduce();
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.p*fraction.p, this.q*fraction.q).reduce();
    }

    public Fraction sum(Fraction fraction) {
        return new Fraction(this.p*fraction.q+fraction.p*this.q, this.q*fraction.q).reduce();
    }

    public Fraction substract(Fraction fraction) {
        return new Fraction(this.p*fraction.q-fraction.p*this.q, this.q*fraction.q).reduce();
    }

    public Fraction  reduce() {
        int nod = FractionHelper.NOD(this.p, this.q);
        if(nod!=1) {
            this.p=this.p/nod;
            this.q=this.q/nod;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;
        Fraction thisReduced = this.reduce();
        Fraction oReduced = fraction.reduce();

        if (thisReduced.p != oReduced.p) return false;
        return thisReduced.q == oReduced.q;

    }

    @Override
    public int hashCode() {
        int result = p;
        result = 31 * result + q;
        return result;
    }

    public static void main(String[] args) {
       //System.out.println(new Fraction(9,29).divide(new Fraction(13,3)));
       //System.out.println(new Fraction("9/29").divide(new Fraction("13hk/3yhh")));

        System.out.println(new Fraction("9/15").equals(new Fraction("6/10")));
    }
}
