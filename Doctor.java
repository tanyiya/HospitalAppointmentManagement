import java.util.ArrayList;

public class Doctor extends Person {
    private String doctorID;
    private String specialization;
    private ArrayList<Appointment> appointments;

    public Doctor(String doctorID, String specialization) {
        this.doctorID = doctorID;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void viewAppointments() {
        System.out.println("Appointments of  " + doctorID);
        for (Appointment a : appointments) {
            a.printDetails();
        }
    }

}