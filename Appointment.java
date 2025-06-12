import java.time.LocalDateTime;

public class Appointment {
    private String appointmentID;
    private String patientID;
    private Doctor doctor;
    private LocalDateTime dateTime;

    public Appointment(String appointmentID, String patientID, Doctor doctor, LocalDateTime dateTime) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public void cancel() {
        System.out.println("Appointment " + appointmentID + " has been cancelled.");
    }

    public void printDetails() {
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Doctor: " + doctor.getDoctorID());
        System.out.println("Date and Time: " + dateTime);
    }
}