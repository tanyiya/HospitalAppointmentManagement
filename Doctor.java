import java.util.ArrayList;

public class Doctor extends Person {
    private String doctorID;
    private String specialization;
    private ArrayList<Appointment> appointments;

    public Doctor(String name, String gender, int age, String doctorID, String specialization) {
        super(name, age, gender);
        this.doctorID = doctorID;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String viewAppointments() {
        StringBuilder sb = new StringBuilder();
        sb.append("Appointments of ").append(doctorID).append(":\n");

        for (Appointment a : appointments) {
            sb.append(a.getDetails()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorID + ", Name: Dr. " + name + ", Specialization: " + specialization;
    }

}