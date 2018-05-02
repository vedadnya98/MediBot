package bytecamp3v.com.medibot;

/**
 * Created by hp on 18-02-2018.
 */

public class Medicine {

    String medicineName;
    int taking;

    public Medicine() {
        super();
    }
    public Medicine(String medicineName, int taking) {
        this.medicineName = medicineName;
        this.taking = taking;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getTaking() {
        return taking;
    }

    public void setTaking(int taking) {
        this.taking = taking;
    }
}
