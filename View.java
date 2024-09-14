import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JFrame f;
    private JTextField inputZ;
    private JTextArea result;

    public View() {
        //ตอนแรกขึ้นภาษาเอเลี่ยน เลยไปหาฟอนต์ที่รองรับภาษาไทย 
        Font thaiFont = new Font("TH SarabunPSK", Font.PLAIN, 16);

        f= new JFrame("คาวแควคู");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);  
        f.setLocationRelativeTo(null);

        JLabel label = new JLabel("กรอกรหัสวัว (8 หลัก):");
        label.setFont(thaiFont); // กำหนดฟอนต์ให้ตัวLabel
        inputZ=new JTextField(20);
        inputZ.setFont(thaiFont); // กำหนดฟอนต์ให้ส่วนInput Field

        JButton submitBtn = new JButton("ตรวจสอบรหัส");
        submitBtn.setFont(thaiFont); // กำหนดฟอนต์ให้ปุ่มซับมิท
        result =new JTextArea(10, 30);
        result.setEditable(false);
        result.setFont(thaiFont); // กำหนดฟอนต์ให้ส่วนพิมข้อความ

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputZ);
        panel.add(submitBtn);
        panel.add(result);
        f.add(panel);
        f.setVisible(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowID = inputZ.getText();
                result.setText("");  // เคลียร์ข้อความเก่า

                if(cowID.length() == 8 && cowID.matches("\\d+") && !cowID.startsWith("0")) {
                    Controller controller = new Controller(View.this);
                    controller.checkCowID(cowID);
                } 
                else {
                    result.setText("รหัสวัวไม่ถูกต้อง! กรุณากรอกใหม่.");
                }
            }
        });
    }
    public void displayResult(String res) {
        result.setText(res);
    }

    public static void main(String[] args) {
        new View();
    }
}
