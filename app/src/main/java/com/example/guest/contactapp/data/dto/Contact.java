package com.example.guest.contactapp.data.dto;

/**
 * Created by Guest on 04.02.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("contactId")
    @Expose
    private String contactId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("address")
    @Expose
    private String address;

    /**
     * No args constructor for use in serialization
     *
     */
    public Contact() {
    }

    /**
     *
     * @param contactId
     * @param phoneNumber
     * @param address
     * @param email
     * @param description
     * @param fullName
     */
    public Contact(String contactId, String email, String fullName, String phoneNumber, String description, String address) {
        super();
        this.contactId = contactId;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
