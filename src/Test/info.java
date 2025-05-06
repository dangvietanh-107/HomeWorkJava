package Test;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class info extends JFrame {
    private JTextField textField;    // Dữ liệu chữ
    private JTextField textField_1;  // Ngày tháng (dd/MM/yy)
    private JTextField textField_2;  // Dữ liệu chữ
    private JButton btnSubmit;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public info() {
        initComponents();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Nhập dữ liệu");
        setSize(600, 400);
        getContentPane().setLayout(new BorderLayout());
        
        // Panel cho các trường nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Họ và tên"));
        textField = new JTextField();
        inputPanel.add(textField);
        
        inputPanel.add(new JLabel("Ngày tháng (dd/MM/yy):"));
        textField_1 = new JTextField();
        inputPanel.add(textField_1);
        
        inputPanel.add(new JLabel("Quê quán"));
        textField_2 = new JTextField();
        inputPanel.add(textField_2);
        
        inputPanel.add(new JLabel("")); // Ô trống
        btnSubmit = new JButton("Submit");
        inputPanel.add(btnSubmit);
        
        // Thêm panel nhập liệu vào phía Bắc
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        
        // Thiết lập JTable
        String[] columnNames = {"Họ và tên", "Ngày tháng", "Quê quán"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        // Thêm JTable vào JScrollPane và đặt vào phía Trung tâm
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        // Thêm ActionListener cho nút Submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitData();
            }
        });
    }
    
    private void submitData() {
        // Lấy dữ liệu từ các TextField
        String data1 = textField.getText().trim();
        String dateStr = textField_1.getText().trim();
        String data2 = textField_2.getText().trim();
        
        // Kiểm tra dữ liệu
        if (data1.isEmpty() || dateStr.isEmpty() || data2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Kiểm tra textField_1 có định dạng dd/MM/yy
        if (!isValidDateFormat(dateStr)) {
            JOptionPane.showMessageDialog(this, 
                    "Ngày tháng phải có định dạng dd/MM/yy!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            textField_1.requestFocus();
            return;
        }
        
        // Thêm dữ liệu vào bảng
        tableModel.addRow(new Object[]{data1, dateStr, data2});
        
        // Xóa nội dung trong các TextField để nhập mới
        clearTextFields();
    }
    
    // Phương thức kiểm tra định dạng ngày tháng dd/MM/yy
    private boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false); // Không linh hoạt với ngày tháng sai
        
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    // Phương thức xóa nội dung trong các TextField
    private void clearTextFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField.requestFocus(); // Di chuyển focus về textField đầu tiên
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new info().setVisible(true);
            }
        });
    }
}