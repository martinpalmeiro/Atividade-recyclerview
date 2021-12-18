package com.example.atividade3.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class PlaceholderAlbum implements Parcelable {

    private int id;
    private int user_id;
    private String title;

    public PlaceholderAlbum(int id, int user_id, String title) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
    }

    public PlaceholderAlbum(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.user_id = json.getInt("userId");
            this.title = json.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected PlaceholderAlbum(Parcel in) {
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
    }

    public static final Parcelable.Creator<PlaceholderAlbum> CREATOR = new Parcelable.Creator<PlaceholderAlbum>() {
        @Override
        public PlaceholderAlbum createFromParcel(Parcel in) {
            return new PlaceholderAlbum(in);
        }

        @Override
        public PlaceholderAlbum[] newArray(int size) {
            return new PlaceholderAlbum[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int post_id) {
        this.user_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceholderAlbum placeholder = (PlaceholderAlbum) o;
        return id == placeholder.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.user_id);
        parcel.writeString(this.title);
    }
}

