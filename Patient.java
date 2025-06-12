import java.util.ArrayList;
import java.time.LocalDateTime;

public class Patient extends Person {
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

    public void printMedicalRecords() {
        System.out.println("Medical Records of " + patientID);
        for (MedicalRecord r : medicalRecords) {
            r.printDetails();
        }
    }
}
