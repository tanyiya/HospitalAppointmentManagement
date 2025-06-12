import java.util.ArrayList;

public class MedicalRecord {
    private String patientID;
    private String recordID;
    private ArrayList<String> details;

    public MedicalRecord(String patientID, String recordID) {
        this.patientID = patientID;
        this.recordID = recordID;
        this.details = new ArrayList<>();
    }

    public void addEntry(String entry) {
        details.add(entry);
    }

    public void printDetails() {
        System.out.println("Medical Record ID: " + recordID);
        System.out.println("Patient ID: " + patientID);
        for (String entry : details) {
            System.out.println(entry);
        }
    }
}