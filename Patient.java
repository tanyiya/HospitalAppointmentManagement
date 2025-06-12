import java.util.ArrayList;
import java.time.LocalDateTime;

public class Patient {
    private String patientID;
    private Doctor doctor;
    private ArrayList<MedicalRecord> medicalRecords;

    public Patient(String patientID) {
        this.patientID = patientID;
        this.doctor = null; // Initially no doctor assigned
        this.medicalRecords = new ArrayList<>();
    }

    public String getPatientID() {
        return patientID;
    }

    public void bookAppointment(Doctor doctor, LocalDateTime dateTime, String appointmentID) {
        Appointment appointment = new Appointment(appointmentID, this.getPatientID(), doctor, dateTime);
        doctor.addAppointment(appointment);
        this.doctor = doctor;
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.cancel();
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public MedicalRecord getMedicalRecord(String recordID) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordID().equals(recordID)) {
                return record;
            }
        }
        System.out.println("Medical Record not found.");
        return null;
    }

    public void printMedicalRecords() {
        System.out.println("Medical Records of " + patientID);
        for (MedicalRecord r : medicalRecords) {
            System.out.println(r);
        }
    }
}
