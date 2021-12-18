package com.example.atividade3.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class PlaceholderPost implements Parcelable {

    private int id;
    private int user_id;
    private String title;
    private String body;

    public PlaceholderPost(int id, int user_id, String title, String body) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public PlaceholderPost(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.user_id = json.getInt("userId");
            this.title = json.getString("title");
            this.body = json.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected PlaceholderPost(Parcel in) {
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Parcelable.Creator<PlaceholderPost> CREATOR = new Parcelable.Creator<PlaceholderPost>() {
        @Override
        public PlaceholderPost createFromParcel(Parcel in) {
            return new PlaceholderPost(in);
        }

        @Override
        public PlaceholderPost[] newArray(int size) {
            return new PlaceholderPost[size];
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

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceholderPost placeholder = (PlaceholderPost) o;
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
        parcel.writeString(this.body);
    }
}

