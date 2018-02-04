package com.example.guest.contactapp.data.dto;

/**
 * Created by Guest on 04.02.2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactArr {

    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ContactArr() {
    }

    /**
     *
     * @param contacts
     */
    public ContactArr(List<Contact> contacts) {
        super();
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
