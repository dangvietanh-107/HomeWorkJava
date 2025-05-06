package Test;


import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mike extends JFrame {

    private JPanel contentPane;
    private JLabel lblSample;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mike frame = new mike();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public mike() {
        setTitle("Change Text Color");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());

        lblSample = new JLabel("Sample");
        lblSample.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblSample);

        // Tạo các RadioButton
        JRadioButton rdbtnRed = new JRadioButton("Red");
        JRadioButton rdbtnBlue = new JRadioButton("Blue");
        JRadioButton rdbtnGreen = new JRadioButton("Green");

        // Gộp chúng lại thành nhóm ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnRed);
        group.add(rdbtnBlue);
        group.add(rdbtnGreen);

        contentPane.add(rdbtnRed);
        contentPane.add(rdbtnBlue);
        contentPane.add(rdbtnGreen);

        // Gán ItemListener cho mỗi RadioButton
        rdbtnRed.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (rdbtnRed.isSelected()) {
                    lblSample.setForeground(Color.RED);
                }
            }
        });

        rdbtnBlue.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (rdbtnBlue.isSelected()) {
                    lblSample.setForeground(Color.BLUE);
                }
            }
        });

        rdbtnGreen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (rdbtnGreen.isSelected()) {
                    lblSample.setForeground(Color.GREEN);
                }
            }
        });
    }
}
