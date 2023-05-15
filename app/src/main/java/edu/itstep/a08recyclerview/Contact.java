package edu.itstep.a08recyclerview;

import android.os.Parcelable;
import android.os.Parcel;


class Contact implements Parcelable {
    private String name;
    private  String lastName;
    private String phone;

    Contact(String name ,String  lastName ){
        this.name = name;
        this.lastName = lastName;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return name + "\n" + lastName;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(phone);
    }
}
