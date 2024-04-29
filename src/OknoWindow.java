import javax.swing.*;

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

    public OknoWindow(){
        setContentPane(panel);
        setTitle("Okno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        OknoWindow okienko = new OknoWindow();
    }
}
