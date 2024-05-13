import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private int money;

    public OknoWindow(){
        setContentPane(panel);
        setTitle("Okno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);

        deposit.addActionListener(e -> {
            money += Integer.parseInt(amount.getText());
            inValue.setText(money + "zł");
            balanceValue.setText("" + money);
            notif.setText(notif.getText() + "Wpłacono " + money + "zł");
            amount.setText("");
        });
    }

    public static void main(String[] args) {
        OknoWindow okienko = new OknoWindow();
    }
}
