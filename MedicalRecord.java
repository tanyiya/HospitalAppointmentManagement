import java.util.ArrayList;

public class MedicalRecord {
    private String recordID;
    private ArrayList<String> details;

    public MedicalRecord(String recordID) {
        this.recordID = recordID;
        this.details = new ArrayList<>();
    }

    public String getRecordID() {
        return recordID;
    }

    public void addEntry(String entry) {
        details.add(entry);
    }

    public void printDetails() {
        System.out.println("Medical Record ID: " + recordID);
        for (String entry : details) {
            System.out.println(entry);
        }
    }
}