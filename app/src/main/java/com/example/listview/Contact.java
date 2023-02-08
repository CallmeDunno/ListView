package com.example.listview;

import java.util.Comparator;

public class Contact {
    private String name;
    private String lastName;
    private String phone;
    private int avt;

    public Contact(String name, String phone, int avt) {
        String[] str = name.split("\\s+");
        this.name = name;
        this.lastName = str[str.length-1];
        this.phone = phone;
        this.avt = avt;
    }

    public Contact(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public static class NameOrder implements Comparator<Contact> {

        @Override
        public int compare(Contact a, Contact b) {
            return a.lastName.compareTo(b.lastName);
        }
    }

    public static class PhoneOrder implements Comparator<Contact>{

        @Override
        public int compare(Contact a, Contact b) {
            return a.phone.compareTo(b.phone);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", avt=" + avt +
                '}';
    }
}
