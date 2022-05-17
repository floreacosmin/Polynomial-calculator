import java.lang.Math; //import Math library
import java.util.Comparator;

public class Monome { //beginning of Term class

    public float coefficient; //initialize the coefficient and exponent variables
    public int exponent;

    public Monome(float coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monome() {
        this(0, 0);
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void addCoef(float x) {
        this.coefficient += x;
    }

    public static Comparator<Monome> getCompByPutere() {
        Comparator<Monome> comp = new Comparator<Monome>() {
            @Override
            public int compare(Monome s1, Monome s2) {

                return Integer.compare(s1.exponent, s2.exponent);
            }
        };
        return comp;
    }

    public Monome Product(Monome x) {
        Monome p = new Monome();
        p.coefficient = this.coefficient * x.coefficient;
        p.exponent = this.exponent + x.exponent;
        return p;
    }


    public Monome Derivative() {
        Monome p = new Monome();
        p.coefficient = this.coefficient * this.exponent;
        p.exponent = this.exponent - 1;
        return p;
    }

    public Monome Integration() {
        Monome p = new Monome();
        p.coefficient = this.coefficient / (this.exponent + 1);
        p.exponent = this.exponent + 1;
        return p;
    }

    public String getMonom() {
        if (exponent == 0) {
            if (coefficient == Math.round(coefficient))
                return String.format("%.0f", coefficient);
            else
                return String.format("%.1f", coefficient);
        } else {
            if (exponent == 1) {
                if (coefficient == Math.round(coefficient)) {
                    if (1 == Math.round(coefficient) || -1 == Math.round(coefficient)) {
                        if (1 == Math.round(coefficient))
                            return "x";
                        else return "-x";
                    } else
                        return String.format("%.0f", coefficient) + "x";
                } else
                    return String.format("%.1f", coefficient) + "x";
            } else {

                if (coefficient == Math.round(coefficient)) {
                    if (1 == Math.round(coefficient) || -1 == Math.round(coefficient))
                        if (1 == Math.round(coefficient))
                            return "x^" + exponent;
                        else return "-x^" + exponent;

                    else
                        return String.format("%.0f", coefficient) + "x^" + exponent;
                } else
                    return String.format("%.1f", coefficient) + "x^" + exponent;

            }
        }
    }

    @Override
    public String toString() {
        return coefficient +
                "*x^" + exponent;
    }
}
