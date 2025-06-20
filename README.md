
<center>
<h4> SECJ2154 Object Oriented Programming
<h4> Section 3
<h4>Hospital Appointment Management System
<h4> Lecturer: Dr. Muhammad Khatibsyarbini
</center>

##### Team Double Tea

| Student Name  | Matric No.|
| :-----------: | :---------------: |
| Tan Yi Ya  | A23CS0187 |
|Teh Ru Qian | A23CS0191 |


#### Table of Content
1. [Project Description](#project-desc)
2. [Implementation of Concepts](#imp-concept)
    - [Implementation of ArrayList](#arr-list)
    - [Implementation of Class Relationship](#imp-classrel)
3. [Sample Output + Screenshots of Program](#output-sc)
4. [UML Class Diagram](#uml-dia)

#### Project Description {#project-desc}
The Hospital Appointment Management System is a Java-based desktop application developed to help hospital administrators efficiently manage patient information, doctor records, appoinment and medical records.

This system features a user-friendly Java Swing GUI, allowing administrators to: 
>- Add new doctors and patients
>- Schedule and cancel appointments
>- View doctor-specific appoinment schedules
>- Create and update medical records for patients

This system improves workflow, minimizes human error in scheduling and ensures organized data management in a clinical setting. 

#### Implementation of Concepts {#imp-concept}

###### Implementation of ArrayList {#arr-list}
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

The usage of ArrayList allows effecient addition, removal, retrieval and iteration of elements stored, using the built in methods alone. Examples of built in methods implemented are ```add()``` and ```remove()```, implemented in adding doctor and patient, adding medical record of patient, adding detail entry in medical record and add or remove appointments.

###### Implementation of Class Relationship {#imp-classrel}
1. Association

2. Aggregation

3. Composition

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

#### Sample Output + Screenshots of Program {#output-sc}

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
<figcaption>Enter Appointment ID to cancel appointment.</figcaption>
    <img src="/img/cancelApp.png">
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

This is the output of program given the following process are carried out:
1. add two doctors D001, D002 and a patient P001
2. schedule appointment for patient P001 with doctor D001 which has code A001
3. cancel the appointment A001, view appointment of D001
4. reschedule an appointment for patient P001 with doctor D002, view appointment of D002
5. create Medical Record MR001 for patient P001 and record two entries: fever and cough
6. print the list of Medical Record for patient P001
7. print the list of Doctors and Patient
```
Doctor added successfully:
Name: Khatib, ID: D001, Specialization: Pediatrics

Doctor added successfully:
Name: Yong Yi Ling, ID: D002, Specialization: Internal Medicine

Patient added successfully:
Name: Tan Ya Ya, ID: P001

Appointment scheduled successfully:
Appointment ID: A001
Patient ID: P001
Doctor ID: D001
Date & Time: 2025-06-21 09:30

Appointment cancelled successfully:
Appointment ID: A001

Appointments of D001:

Appointment scheduled successfully:
Appointment ID: A002
Patient ID: P001
Doctor ID: D002
Date & Time: 2025-06-20 15:09

Appointments of D002:
Appointment ID: A002, DateTime: 2025-06-20 T15:09, Patient: P001

Medical record created successfully:
Patient ID: P001
Record ID: MR001

Medical record entry added successfully:
Medical Record ID: MR001
Patient ID: P001
- Fever

Medical record entry added successfully:
Medical Record ID: MR001
Patient ID: P001
- Fever
- Cough

List of Medical Records of P001:
Medical Record ID: MR001
Patient ID: P001
- Fever
- Cough


--- Doctor List ---
Doctor ID: D001, Name: Dr. Khatib, Specialization: Pediatrics
Doctor ID: D002, Name: Dr. Yong Yi Ling, Specialization: Internal Medicine

--- Patient List ---
Patient ID: P001, Name: Tan Ya Ya, Age: 1, Gender: Female
```

#### UML Class Diagram {#uml-dia}
<figure>
<figcaption>Class Diagram for Hospital Appointment Management System<figcaption>
    <img src="/img/ClassDiagram.png">
</figure>
