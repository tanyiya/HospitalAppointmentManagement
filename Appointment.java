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

    public String getAppointmentID() {
        return appointmentID;
    }

    public void cancelAppointment(Appointment appointment) {
        if (appointment != null) {
            appointment.doctor.cancelAppointment(appointment);
        } else {
            System.out.println("No appointment found to cancel.");
        }
    }

    public String getDetails() {
        return "Appointment ID: " + appointmentID + ", DateTime: " + dateTime + ", Patient: " + patientID;
    }

}