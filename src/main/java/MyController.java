import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyController {

    private MyGUI myGUI;
    public Polynomial poly1, poly2, poly3;

    public MyController(MyGUI GUI ) {
        this.myGUI = GUI;
        this.poly1 = new Polynomial();
        this.poly2 = new Polynomial();
        this.poly3 = new Polynomial();
        this.myGUI.setAddActionListener(new AdditionActionListener());
        this.myGUI.setSubActionListener(new SubtractActionListener());
        this.myGUI.setProdActionListener(new ProductActionListener());
        this.myGUI.setDerivativeActionListener(new DerivativeActionListener());
        this.myGUI.setIntegrationActionListener(new IntegrationActionListener());
    }

    class AdditionActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPoly = myGUI.gettFieldFirstPoly();
            String secondPoly = myGUI.gettFieldSecondPoly();
            poly1 = new Polynomial(firstPoly);
            poly2 = new Polynomial(secondPoly);
            poly3 = poly1.add(poly2);
            String result = poly3.toString();
            myGUI.settFieldResult(result);
        }
    }

    class SubtractActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPoly = myGUI.gettFieldFirstPoly();
            String secondPoly = myGUI.gettFieldSecondPoly();
            poly1 = new Polynomial(firstPoly);
            poly2 = new Polynomial(secondPoly);
            poly3 = poly1.subtract(poly2);
            String result = poly3.toString();
            myGUI.settFieldResult(result);
        }
    }

    class ProductActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPoly = myGUI.gettFieldFirstPoly();
            String secondPoly = myGUI.gettFieldSecondPoly();
            poly1 = new Polynomial(firstPoly);
            poly2 = new Polynomial(secondPoly);
            poly3 = poly1.product(poly2);
            String result = poly3.toString();
            myGUI.settFieldResult(result);
        }
    }

    class DerivativeActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPoly = myGUI.gettFieldFirstPoly();
            poly1 = new Polynomial(firstPoly);
            poly3 = poly1.derivative();
            String result = poly3.toString();
            myGUI.settFieldResult(result);
        }
    }

    class IntegrationActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstPoly = myGUI.gettFieldFirstPoly();
            poly1 = new Polynomial(firstPoly);
            poly3 = poly1.integration();
            String result = poly3.toString();
            myGUI.settFieldResult(result);
        }
    }

    public static void main(String[] args) {
        MyGUI GUI = new MyGUI();
        //Polynomial pModel = new Polynomial();
        MyController controller = new MyController(GUI);

    }
}
