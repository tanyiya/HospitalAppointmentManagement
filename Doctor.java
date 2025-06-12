import java.util.ArrayList;

public class Doctor {
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

    public void createMedicalRecord(Patient patient, String recordID) {
        MedicalRecord record = new MedicalRecord(recordID);
        patient.addMedicalRecord(record);
    }

    public void addMedicalRecordEntry(Patient patient, String recordID, String entry) {
        MedicalRecord record = patient.getMedicalRecord(recordID);
        if (record != null) {
            record.addEntry(entry);
        } else {
            System.out.println("Medical Record not found.");
        }
    }

    public void viewAppointments() {
        System.out.println("Appointments of  " + doctorID);
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }

}