package com.example.guest.contactapp.presentation.contactlist.viewmodels;

/**
 * Created by Guest on 29.01.2018.
 */

public class ContactViewModel {
    private String name;
    private String email;

    @Override
    public String toString() {
        return "ContactViewModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactViewModel(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public ContactViewModel() {

    }
}
