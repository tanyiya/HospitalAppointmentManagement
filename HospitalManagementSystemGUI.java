import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HospitalManagementSystemGUI {
    private Hospital hospital;
    private JFrame frame;
    private JTextArea outputArea;

    public HospitalManagementSystemGUI() {
        hospital = new Hospital();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("Program");
        JMenu doctorMenu = new JMenu("Doctors");
        JMenu patientMenu = new JMenu("Patients");
        JMenu appointmentMenu = new JMenu("Appointments");
        JMenu medicalRecordMenu = new JMenu("Medical Records");

        // Create menu items
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        JMenuItem addPatientItem = new JMenuItem("Add Patient");
        JMenuItem scheduleAppointmentItem = new JMenuItem("Schedule Appointment");
        JMenuItem viewDoctorAppointmentsItem = new JMenuItem("View Doctor's Appointments");
        JMenuItem listDoctorsItem = new JMenuItem("List Doctors");
        JMenuItem listPatientsItem = new JMenuItem("List Patients");
        JMenuItem addMedicalRecordItem = new JMenuItem("Add Medical Record");
        JMenuItem addMedicalEntryItem = new JMenuItem("Add Medical Record Entry");
        JMenuItem printMedicalRecordItem = new JMenuItem("Print Medical Record");

        // Add items to menus
        fileMenu.add(exitItem);
        doctorMenu.add(addDoctorItem);
        doctorMenu.add(listDoctorsItem);
        patientMenu.add(addPatientItem);
        patientMenu.add(listPatientsItem);
        appointmentMenu.add(scheduleAppointmentItem);
        appointmentMenu.add(viewDoctorAppointmentsItem);
        medicalRecordMenu.add(addMedicalRecordItem);
        medicalRecordMenu.add(addMedicalEntryItem);
        medicalRecordMenu.add(printMedicalRecordItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(doctorMenu);
        menuBar.add(patientMenu);
        menuBar.add(appointmentMenu);
        menuBar.add(medicalRecordMenu);

        frame.setJMenuBar(menuBar);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add action listeners
        exitItem.addActionListener(e -> System.exit(0));

        addDoctorItem.addActionListener(e -> addDoctor());
        addPatientItem.addActionListener(e -> addPatient());
        scheduleAppointmentItem.addActionListener(e -> scheduleAppointment());
        viewDoctorAppointmentsItem.addActionListener(e -> viewDoctorAppointments());
        listDoctorsItem.addActionListener(e -> listDoctors());
        listPatientsItem.addActionListener(e -> listPatients());
        addMedicalRecordItem.addActionListener(e -> addMedicalRecord());
        addMedicalEntryItem.addActionListener(e -> addMedicalRecordEntry());
        printMedicalRecordItem.addActionListener(e -> printMedicalRecord());

        frame.setVisible(true);
    }

    private void addDoctor() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField nameField = new JTextField();
        String[] genders = { "Male", "Female" };
        JComboBox<String> genderBox = new JComboBox<>(genders);
        JTextField ageField = new JTextField();
        JTextField doctorIdField = new JTextField();
        JTextField specializationField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderBox);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Doctor ID:"));
        panel.add(doctorIdField);
        panel.add(new JLabel("Specialization:"));
        panel.add(specializationField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Doctor",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String gender = (String) genderBox.getSelectedItem();
                int age = Integer.parseInt(ageField.getText());
                String doctorId = doctorIdField.getText();
                String specialization = specializationField.getText();

                Doctor doctor = new Doctor(name, gender, age, doctorId, specialization);
                hospital.addDoctor(doctor);
                outputArea.append("Doctor added successfully:\n");
                outputArea
                        .append("Name: " + name + ", ID: " + doctorId + ", Specialization: " + specialization + "\n\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addPatient() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        String[] genders = { "Male", "Female" };
        JComboBox<String> genderBox = new JComboBox<>(genders);
        JTextField ageField = new JTextField();
        JTextField patientIdField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderBox);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Patient ID:"));
        panel.add(patientIdField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Patient",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String gender = (String) genderBox.getSelectedItem();
                int age = Integer.parseInt(ageField.getText());
                String patientId = patientIdField.getText();

                Patient patient = new Patient(name, gender, age, patientId);
                hospital.addPatient(patient);
                outputArea.append("Patient added successfully:\n");
                outputArea.append("Name: " + name + ", ID: " + patientId + "\n\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void scheduleAppointment() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField patientIdField = new JTextField();
        JTextField doctorIdField = new JTextField();

        // Spinner for date & time
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateTimeSpinner = new JSpinner(dateModel);
        dateTimeSpinner.setEditor(new JSpinner.DateEditor(dateTimeSpinner, "yyyy-MM-dd HH:mm"));

        JTextField appointmentIdField = new JTextField();

        panel.add(new JLabel("Patient ID:"));
        panel.add(patientIdField);
        panel.add(new JLabel("Doctor ID:"));
        panel.add(doctorIdField);
        panel.add(new JLabel("Date & Time:"));
        panel.add(dateTimeSpinner);
        panel.add(new JLabel("Appointment ID:"));
        panel.add(appointmentIdField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Schedule Appointment",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String patientId = patientIdField.getText();
                String doctorId = doctorIdField.getText();
                String appointmentId = appointmentIdField.getText();

                Patient patient = hospital.findPatientById(patientId);
                Doctor doctor = hospital.findDoctorById(doctorId);

                if (patient == null || doctor == null) {
                    throw new InvalidAppointmentException("Patient or Doctor not found");
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.ofInstant(
                        ((java.util.Date) dateTimeSpinner.getValue()).toInstant(),
                        java.time.ZoneId.systemDefault());

                patient.bookAppointment(doctor, dateTime, appointmentId);
                outputArea.append("Appointment scheduled successfully:\n");
                outputArea.append("Appointment ID: " + appointmentId + "\n");
                outputArea.append("Patient ID: " + patientId + "\n");
                outputArea.append("Doctor ID: " + doctorId + "\n");
                outputArea.append("Date & Time: " + dateTime.format(formatter) + "\n\n");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error scheduling appointment: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void viewDoctorAppointments() {
        String doctorId = JOptionPane.showInputDialog(frame, "Enter Doctor ID:");
        if (doctorId != null && !doctorId.trim().isEmpty()) {
            Doctor doctor = hospital.findDoctorById(doctorId);
            if (doctor != null) {
                outputArea.append(doctor.viewAppointments());
                outputArea.append("\n");
            } else {
                JOptionPane.showMessageDialog(frame, "Doctor not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void listDoctors() {
        outputArea.append(hospital.listDoctors());
        outputArea.append("\n");
    }

    private void listPatients() {
        outputArea.append(hospital.listPatients());
        outputArea.append("\n");
    }

    private void addMedicalRecord() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField patientIdField = new JTextField();
        JTextField recordIdField = new JTextField();

        panel.add(new JLabel("Patient ID:"));
        panel.add(patientIdField);
        panel.add(new JLabel("Record ID:"));
        panel.add(recordIdField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Medical Record",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String patientId = patientIdField.getText();
            String recordId = recordIdField.getText();

            Patient patient = hospital.findPatientById(patientId);
            if (patient != null) {
                MedicalRecord record = new MedicalRecord(patientId, recordId);
                patient.addMedicalRecord(record);
                outputArea.append("Medical record created successfully:\n");
                outputArea.append("Patient ID: " + patientId + "\n");
                outputArea.append("Record ID: " + recordId + "\n\n");
            } else {
                JOptionPane.showMessageDialog(frame, "Patient not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addMedicalRecordEntry() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JTextField patientIdField = new JTextField();
        JTextField recordIdField = new JTextField();
        JTextField entryField = new JTextField();

        panel.add(new JLabel("Patient ID:"));
        panel.add(patientIdField);
        panel.add(new JLabel("Record ID:"));
        panel.add(recordIdField);
        panel.add(new JLabel("Entry:"));
        panel.add(entryField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Medical Record Entry",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String patientId = patientIdField.getText();
            String recordId = recordIdField.getText();
            String entry = entryField.getText();

            Patient patient = hospital.findPatientById(patientId);
            if (patient != null) {
                MedicalRecord record = patient.getMedicalRecords().stream()
                        .filter(r -> r.getRecordID().equals(recordId))
                        .findFirst()
                        .orElse(null);
                if (record != null) {
                    record.addEntry(entry);
                    outputArea.append("Medical record entry added successfully:\n");
                    outputArea.append(record.getDetails());
                } else {
                    JOptionPane.showMessageDialog(frame, "No medical records found for this patient",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Patient not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void printMedicalRecord() {
        String patientId = JOptionPane.showInputDialog(frame, "Enter Patient ID:");
        if (patientId != null && !patientId.trim().isEmpty()) {
            Patient patient = hospital.findPatientById(patientId);
            if (patient != null) {
                outputArea.append(patient.printMedicalRecords());
                outputArea.append("\n");
            } else {
                JOptionPane.showMessageDialog(frame, "Patient not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementSystemGUI());
    }
}