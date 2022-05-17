import javax.management.loading.MLet;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;


public class Polynomial {
    String[] monomeStr;
    ArrayList<Monome> mList = new ArrayList<Monome>();

    public Polynomial(String polynomial) {
        //https://stackoverflow.com/questions/34946528/decode-polynomial-from-string-with-pattern-and-matcher?fbclid=IwAR0lUM9x8nvf_fGU5m-bdPkBV_AgIJnGneRT49TU7NYX0ZebfIrUKR6Rikg


        String monomialFormat = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";

        Pattern p1 = Pattern.compile(monomialFormat);
        Matcher m1 = p1.matcher(polynomial);

        while (!m1.hitEnd()) {
            m1.find();
            Pattern p2 = Pattern.compile(monomialPartsFormat);
            Matcher m2 = p2.matcher(m1.group());

            if (m2.find()) {

                float coefficient;
                try {
                    String coef = m2.group(1);
                    if (isNumeric(coef)) {
                        coefficient = Float.valueOf(coef);
                    } else {
                        coefficient = Float.valueOf(coef + "1");
                    }
                } catch (IllegalStateException e) {
                    coefficient = 0.0F;
                }

                int exponent;
                try {
                    String exp = m2.group(3);
                    if (isNumeric(exp)) {
                        exponent = Integer.valueOf(exp);
                    } else {
                        if(m2.group(2).equals("x"))
                            exponent = 1;
                        else
                            exponent = 0;
                    }
                } catch (IllegalStateException e) {
                    exponent = 0;
                }

                mList.add(new Monome(coefficient, exponent));
            }
        }

    }

    public Polynomial() {
    }

    private Polynomial(Polynomial x) {
        this.mList = x.mList;
    }

    public static boolean isNumeric(String str) {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }

    public String toString() {
        String display_pol = new String("");
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).coefficient < 0) {
                display_pol += mList.get(i).getMonom();
            } else {
                display_pol += (0 == i) ? mList.get(i).getMonom() : "+" + mList.get(i).getMonom();
            }
        }
        return display_pol;
    }


    public Polynomial add(Polynomial pol) {
        Polynomial pol1 = new Polynomial();
        for (int i = 0; i < this.mList.size(); i++) {
            int p1 = this.mList.get(i).getExponent();
            float c1 = this.mList.get(i).getCoefficient();

            int i_pow = pol.getIndexPutere(p1);
            if (i_pow == -1) {
                // Nu am gasit deci adaugam un nou monom
                pol1.mList.add(new Monome(c1, p1));
            } else {
                // sumama deoarece am gasit ceva in polinomul 2
                int p3 = pol.mList.get(i_pow).getExponent();
                float c3 = pol.mList.get(i_pow).getCoefficient();
                pol1.mList.add(new Monome(c1 + c3, p3));
                // Eliminam ce am adaugat deja
                pol.mList.remove(i_pow);
            }
        }
        //adaugam ce a ramas in pol 2
        for (int j = 0; j < pol.mList.size(); j++) {
            int p2 = pol.mList.get(j).getExponent();
            float c2 = pol.mList.get(j).getCoefficient();
            pol1.mList.add(new Monome(c2, p2));
        }
        pol1.sortM();
        return pol1;
    }

    public Polynomial product(Polynomial pol) {
        Polynomial pol1 = new Polynomial();
        for (Monome m1: this.mList) {
            for (Monome m2 : pol.mList) {
                Monome m3 = m1.Product(m2);

                pol1.mList.add(m3);
            }
        }
        pol1.sortM();
        return pol1;
    }

    public Polynomial subtract(Polynomial pol) {
        Polynomial pol1;
        for (Monome temp : pol.mList) {
            temp.coefficient = temp.coefficient * (-1);
        }
        pol1 = this.add(pol);
        for (int i = 0; i < pol1.mList.size(); i++) {
            if (pol1.mList.get(i).coefficient == 0) pol1.mList.remove(i);
        }
        return pol1;
    }

    public Polynomial derivative() {
        Polynomial pol1 = new Polynomial();
        for (Monome temp: this.mList) {
            if(temp.exponent > 0)
                pol1.mList.add(temp.Derivative());
        }
        return pol1;
    }

    public Polynomial integration() {
        Polynomial pol1 = new Polynomial();
        for (Monome temp : this.mList) {
            pol1.mList.add(temp.Integration());
        }
        return pol1;
    }

    private void sortM() {
        for (int i = 0; i < mList.size(); i++) {
            int power = mList.get(i).getExponent();
            for (int j = i + 1; j < mList.size(); j++) {
                int power_temp = mList.get(j).getExponent();
                if (power == power_temp) {
                    mList.get(i).addCoef(mList.get(j).getCoefficient());
                    this.mList.remove(j);
                }
            }
        }
        Collections.sort(this.mList, Monome.getCompByPutere().reversed());
    }


    private int getIndexPutere(int Power) {
        for (int i = 0; i < mList.size(); i++) {
            Monome mon = mList.get(i);
            if (Power == mon.getExponent())
                return i;
        }
        return -1;
    }


}
