package org.cognizant.disastermanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.cognizant.disastermanagement.Enum.Gender;
import org.cognizant.disastermanagement.Enum.CitizenStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CitizenID")
    private int citizenId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "DOB")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Address", length = 500)
    private String address;

    @Column(name = "ContactInfo")
    private String contactInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private CitizenStatus status;

    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;
//
//    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonBackReference // Breaks the infinite loop
//    private List<CitizenDocument> documents;


//    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("citizen")


    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CitizenDocument> documents;






    public Citizen() {}

    // Getters and Setters
    public int getCitizenId() { return citizenId; }
    public void setCitizenId(int citizenId) { this.citizenId = citizenId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public CitizenStatus getStatus() { return status; }
    public void setStatus(CitizenStatus status) { this.status = status; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<CitizenDocument> getDocuments() { return documents; }
    public void setDocuments(List<CitizenDocument> documents) { this.documents = documents; }
}