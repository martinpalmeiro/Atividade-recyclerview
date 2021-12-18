package com.example.atividade3.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class PlaceholderComment implements Parcelable {

    private int id;
    private int post_id;
    private String name;
    private String body;

    public PlaceholderComment(int id, int post_id, String name, String body) {
        this.id = id;
        this.post_id = post_id;
        this.name = name;
        this.body = body;
    }

    public PlaceholderComment(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.post_id = json.getInt("postId");
            this.name = json.getString("name");
            this.body = json.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected PlaceholderComment(Parcel in) {
        id = in.readInt();
        post_id = in.readInt();
        name = in.readString();
        body = in.readString();
    }

    public static final Parcelable.Creator<PlaceholderComment> CREATOR = new Parcelable.Creator<PlaceholderComment>() {
        @Override
        public PlaceholderComment createFromParcel(Parcel in) {
            return new PlaceholderComment(in);
        }

        @Override
        public PlaceholderComment[] newArray(int size) {
            return new PlaceholderComment[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        PlaceholderComment placeholder = (PlaceholderComment) o;
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
        parcel.writeInt(this.post_id);
        parcel.writeString(this.name);
        parcel.writeString(this.body);
    }
}