import java.util.ArrayList;
import java.time.LocalDateTime;

public class Patient extends Person {
    private String patientID;
    private ArrayList<MedicalRecord> medicalRecords;

    public Patient(String name, String gender, int age, String patientID) {
        super(name, age, gender);
        this.patientID = patientID;
        this.medicalRecords = new ArrayList<>();
    }

    public String getPatientID() {
        return patientID;
    }

    public void bookAppointment(Doctor doctor, LocalDateTime dateTime, String appointmentID) {
        Appointment appointment = new Appointment(appointmentID, this.getPatientID(), doctor, dateTime);
        doctor.addAppointment(appointment);
        System.out.println("Appointment booked with Doctor " + doctor + " on " + dateTime);
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public String printMedicalRecords() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of Medical Records of ").append(patientID).append(":\n");

        if (medicalRecords.isEmpty()) {
            sb.append("No records available.\n");
        } else {
            for (MedicalRecord r : medicalRecords) {
                sb.append(r.getDetails()).append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }

}
