package com.training.recyclerviewandcardview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Name implements Parcelable {

    private String firstname;
    private String lastname;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstname);
        dest.writeString(this.lastname);
    }

    public Name() {
    }

    protected Name(Parcel in) {
        this.firstname = in.readString();
        this.lastname = in.readString();
    }

    public static final Parcelable.Creator<Name> CREATOR = new Parcelable.Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel source) {
            return new Name(source);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };
}
