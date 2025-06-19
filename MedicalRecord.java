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

    public String getRecordID() {
        return recordID;
    }

    public void addEntry(String entry) {
        details.add(entry);
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medical Record ID: ").append(recordID).append("\n");
        sb.append("Patient ID: ").append(patientID).append("\n");

        for (String entry : details) {
            sb.append("- ").append(entry).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patientID='" + patientID + '\'' +
                ", recordID='" + recordID + '\'' +
                ", details=" + details +
                '}';
    }
}