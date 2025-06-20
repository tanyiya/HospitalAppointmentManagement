## Hospital Appointment Management System

#### Team Double Tea
1. Tan Yi Ya A23CS0187
2. Teh Ru Qian A23CS0191

#### Project Description
The Hospital Appointment Management System is a Java-based desktop application developed to help hospital administrators efficiently manage patient information, doctor records, appoinment and medical records.

This system features a user-friendly Java Swing GUI, allowing administrators to: 
>- Add new doctors and patients
>- Schedule and cancel appointments
>- View doctor-specific appoinment schedules
>- Create and update medical records for patients

This system improves workflow, minimizes human error in scheduling and ensures organized data management in a clinical setting. 

#### Implementation of Concepts

##### ArrayList
In this project, ArrayList is used to manage dynamic collections of object. To use ArrayList, we import the ```java.util.ArrayList``` package on each class. Below are the classes that implements ArrayList:
>1. Hospital
>- ```private List<Doctor> doctors;``` : Records list of Doctor in a Hospital
>- ```private List<Patient> patients;``` : Records list of Patient in a Hospital
>2. Patient
>- ```private ArrayList<MedicalRecord> medicalRecords;``` : Records list of Medical Record Histories of a Patient
>3. Doctor
>- ```private ArrayList<Appointment> appointments;``` : Records list of Appointments of a doctor
>4. Medical Record
>- ```private ArrayList<String> details;``` : Records list of details entry of a Patient's Medical Record

The usage of ArrayList allows effecient addition, removal, retrieval and iteration of elements stored, using the built in methods alone. Examples of built in methods implemented are ```add()``` and ```remove()```.

##### Class Relationship

##### Inheritance
The system uses inheritance to reduce code redundancy. A base class ```Person``` contains common attributes such as ```name```, ```age``` and ```gender```. Both ```Doctor``` and ```Patient``` classes extend ```Person``` and inherit these properties. 
``` java
public class Person {
    protected String name;
    protected int age;
    protected String gender;
}

public class Doctor extends Person {
    // doctor-specific attributes
    private String doctorID;
    private String specialization;
    private ArrayList<Appointment> appointments;
}

public class Patient extends Person {
    // patient-specific attributes
    private String patientID;
    private ArrayList<MedicalRecord> medicalRecords;
}
```
This hierarchical relationship produces cleaner and more maintainable code through a structured class inheritance tree. 

##### Polymorphism
Polymorphism is achieved through method overriding. For example, the ```toString()``` method is overridden in multiple classes to display specific details depending on the object type. 
```java
@Override
public String toString() {
    return "Doctor ID: " + doctorID + ", Name: Dr. " + name;
}
```
This allows flexible object handling, especially when displaying information in the GUI.


##### Exception Handling
A custom exception class named ```InvalidAppoinmentException``` is implemented to handle appointment-related errors.
```java
public class InvalidAppointmentException extends Exception {
    public InvalidAppointmentException(String message) {
        super("Invalid appointment: " + message);
    }
}
```
It is used when a doctor or patient is not found:
>- The system gets the patient ID, doctor ID and appointment ID from the form.
>- It checks if the doctor or patient exists.
>- If either is missing, it throws a custom exception:```InvalidAppointmentException```.
>- The error is caught and shown to the user using a pop-up message.

```java
try {
    // If patient and doctor is null, throw an exception
    if (patient == null || doctor == null) {
        throw new InvalidAppointmentException("Patient or Doctor not found");
    }

} catch (Exception e) {
        JOptionPane.showMessageDialog(frame, "Error scheduling appointment: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
}
```
This makes sure the system shows helpful messages to the user if anything goes wrong, like missing IDs or wrong input. 

#### Sample Output + Screenshots of Program

<figure>
<figcaption>Header of Output Program</figcaption>
    <img src="/img/header_menu.gif">
    
</figure>

<figure>
<figcaption>Interface for adding a doctor.</figcaption>
    <img src="/img/addDoc1.png"> 
</figure>

<figure>
<figcaption>Interface for adding a patient.</figcaption>
    <img src="/img/addPatient.png">
</figure>

<figure>
<figcaption>Interface of Booking Appointment.</figcaption>
    <img src="/img/bookApp.png">
</figure>

<figure>
<figcaption>Enter Doctor ID to View Appointment of the doctor.</figcaption>
    <img src="/img/viewDocApp.png">
</figure>

<figure>
 <figcaption>Add a medical record for patient.</figcaption>
    <img src="/img/addMedRec.png">
</figure>

<figure>
<figcaption>Add entry of medical condition in Patient's medical record.</figcaption>
    <img src="/img/addEntry.png">
</figure>

<figure>
<figcaption>Enter Patient ID to view all medical records of the patient.</figcaption>
</figure>
    <img src="/img/printMedRecord.png">

<figure>
<figcaption>Full output of the process carried out above.</figcaption>
    <img src="/img/out1.png">
</figure>

<figure>
<figcaption>Additionally, the output of doctor list and patient list.<figcaption>
    <img src="/img/out2.png">
</figure>

#### UML Class Diagram
<figure>
<figcaption>Class Diagram for Hospital Appointment Management System<figcaption>
    <img src="/img/ClassDiagram.png">
</figure>