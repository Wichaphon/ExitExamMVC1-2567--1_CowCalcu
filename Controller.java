import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }
    // ฟังก์ชันไว้ตรวจรหัสวัวในไฟล์ CSV
    public void checkCowID(String cowID) {
        String csvFile="cow_data.csv";
        String line;
        boolean cowFound= false;
        //อ่านไฟล์
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] cowData = line.split(",");
                if (cowData[0].equals(cowID)) {
                    //ถ้าเจอวัวในไฟล์ CSV
                    Cow cow = new Cow(cowData[0],cowData[1],Double.parseDouble(cowData[2])); //แยกเป็นคอลัมใน csv  
                    calcuMilk(cow);
                    cowFound = true;
                    break;
                }
            }

            if (!cowFound) {
                // ถ้าไม่เจอรหัสวัว
                view.displayResult("ไม่พบรหัสวัวในระบบ กรุณากรอกใหม่.");
            }

        } catch (IOException e) {
            view.displayResult("เกิดข้อผิดพลาดในการอ่านข้อมูลจากไฟล์ CSV.");
        }
    }

    //คำนวณปริมาณน้ำนมตามชนิดของวัว
    private void calcuMilk(Cow cow) { //ไว้แสดงในกล่อง textfield
        String res = "วัวสายพันธุ์: "+cow.getBreed()+"\n"+"อายุ: "+cow.getAge()+ " ปี\n";

        switch (cow.getBreed()) {
            case "White":
                //ใช้methodคำนวณนมจืด
                int plainMilk = cow.calPlainMilk();
                res += "นมจืด: " + plainMilk + " ลิตร\n";
                break;

            case "Brown":
                //ใช้methodคำนวณนมช็อกโกแลต
                int chocoMilk = cow.calChocoMilk();
                res += "นมช็อกโกแลต: " + chocoMilk + " ลิตร\n";
                break;

            case "Pink":
                //ใช้methodคำนวณนมสตรอว์เบอร์รี่
                int strawberryMilk = cow.calStrawberryMilk();
                res += "นมสตรอว์เบอร์รี่: " + strawberryMilk + " ลิตร\n";
                break;

            default: //ไว้กันไม่เจอข้อมูล breed ใน csv หรือข้อมูลผิดเลยให้เป็นส่วน defult
                res += "ไม่พบชนิดวัวที่ถูกต้อง\n";
                break;
        }
    view.displayResult(res);
    }
}
