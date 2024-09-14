public class Cow {
    private String cowID;
    private String breed;
    private double age;//อายุเป็นปี.เดือน

    public Cow(String cowID, String breed, double age) {
        this.cowID = cowID;
        this.breed = breed;
        this.age = age;
    }

    public String getCowID() {
        return cowID;
    }

    public String getBreed() {
        return breed;
    }

    public double getAge() {
        return age;
    }
    // Methodคำนวณนมจืด(White)
    public int calPlainMilk() {
        int ageInMonths = (int) (age * 12);//แปลงอายุเป็นเดือน
        int plainMilk = 120 - ageInMonths;
        return Math.max(plainMilk, 0); //นมต้องไม่น้อยกว่า0 l
    }
    // Methodคำนวณนมช็อกโกแลต(Brown)
    public int calChocoMilk() {
        int ageFull = (int) age;  // อายุปีเต็ม
        int chocoMilk = 40 - ageFull;
        return Math.max(chocoMilk, 0); 
    }
    // Methodคำนวณนมสตรอว์เบอร์รี่(Pink)
    public int calStrawberryMilk() {
        int monthRemain = (int) ((age - (int) age) * 12);//เศษเดือน
        int strawberryMilk = 30 - monthRemain;
        return Math.max(strawberryMilk, 0); 
    }
}
