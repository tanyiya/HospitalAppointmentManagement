import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added -> " + doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor added -> " + patient);
    }

    public Doctor findDoctorById(String id) {
        for (Doctor d : doctors){
            if (d.getDoctorID().equals(id)){
                return d;
            }
        }
        return null;
    }

    public Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void listDoctors(){
        System.out.print("--- Doctor List ---");
        for (Doctor d : doctors) 
            System.out.println(d);
    }

    public void listPatients() {
        System.out.println("--- Patient List ---");
        for (Patient p : patients)
            System.out.println(p);
    }
}
