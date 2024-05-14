import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class OknoWindow extends JFrame{
    private JPanel panel;
    private JTextField amount;
    private JButton deposit;
    private JButton all;
    private JLabel notifications;
    private JLabel inValue;
    private JLabel out;
    private JLabel outValue;
    private JLabel balance;
    private JLabel balanceValue;
    private JLabel in;
    private JButton choose;
    private JLabel notif;

    private double money;
    private double sumIn;
    private double sumOut;

    public static double parse(String s) {
        try {
            return ((double) Math.round(Double.parseDouble(s.replace(',', '.')) * 100.0d)) / 100.0d;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
    public static double round(double d){
        return (double)Math.round(d * 100.0d) / 100.0d;
    }
    public OknoWindow(){
        setContentPane(panel);
        setTitle("Okno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
        setResizable(false);


        deposit.addActionListener(e -> {
            if (amount.getText().isEmpty() || parse(amount.getText()) == 0) {
                JOptionPane.showMessageDialog(null, "Nie udało się zrealizować tej operacji");
                amount.setText("");
                return;
            }
            money += parse(amount.getText());
            money =  round(money);
            sumIn += parse(amount.getText());
            sumIn = round(sumIn);
            inValue.setText(sumIn + "zł");
            balanceValue.setText(money + "zł");
            notif.setText("Wpłacono " + parse(amount.getText()) + "zł");
            amount.setText("");
        });
        choose.addActionListener(e -> {
            if (amount.getText().isEmpty() || parse(amount.getText()) > money || parse(amount.getText()) == 0){
                JOptionPane.showMessageDialog(null, "Nie udało się zrealizować tej operacji");
                amount.setText("");
                return;
            }
            money -= parse(amount.getText());
            money = round(money);
            sumOut += parse(amount.getText());
            sumOut = round(sumOut);
            outValue.setText(sumOut + "zł");
            balanceValue.setText(money + "zł");
            notif.setText("Wypłacono " + parse(amount.getText()) + "zł");
            amount.setText("");
        });
        all.addActionListener(e -> {
            if(money == 0){
                JOptionPane.showMessageDialog(null, "Nie udało się zrealizować tej operacji");
                return;
            }
            sumOut += money;
            notif.setText("Wypłacono " + money + "zł");
            money = 0;
            outValue.setText(sumOut + "zł");
            balanceValue.setText(money + "zł");
        });
    }

    public static void main(String[] args) {
        OknoWindow okienko = new OknoWindow();
    }
}
