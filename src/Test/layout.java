package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class layout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					layout frame = new layout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public layout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button1");
		centerPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button2");
		centerPanel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button3");
		centerPanel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("New button4");
		centerPanel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button5");
		centerPanel.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton("New button6");
		centerPanel.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button7");
		centerPanel.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("New button8");
		centerPanel.add(btnNewButton_7);
		
		JButton btnNewButton_9 = new JButton("New button9");
		centerPanel.add(btnNewButton_9);
		
		JButton btnReset = new JButton("reset");
		for (int i = 0; i < centerPanel.getComponents().length; i++) {
		    if (centerPanel.getComponents()[i] instanceof JButton) {
		        final JButton btn = (JButton) centerPanel.getComponents()[i];
		        final int buttonIndex = i + 1;
		        
		        btn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                btn.setText("Clicked " + buttonIndex);
		            }
		        });
		    }
		}
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  // Reset tất cả các nút trong panel trở về text ban đầu
			    for (int i = 0; i < centerPanel.getComponents().length; i++) {
			        if (centerPanel.getComponents()[i] instanceof JButton) {
			            JButton btn = (JButton) centerPanel.getComponents()[i];
			            btn.setText("Button " + (i + 1));
			        }
			    }
			}
		});
		centerPanel.add(btnReset);
	}

}
