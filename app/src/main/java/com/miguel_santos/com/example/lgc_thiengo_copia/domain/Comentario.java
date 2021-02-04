package com.miguel_santos.com.example.lgc_thiengo_copia.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Comentario implements Parcelable {

    private User user;
    private String mensagem;

    public Comentario(User user, String mensagem) {
        this.user = user;
        this.mensagem = mensagem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeString(this.mensagem);
    }

    protected Comentario(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        mensagem = in.readString();
    }

    public static final Creator<Comentario> CREATOR = new Creator<Comentario>() {
        @Override
        public Comentario createFromParcel(Parcel in) {
            return new Comentario(in);
        }

        @Override
        public Comentario[] newArray(int size) {
            return new Comentario[size];
        }
    };

}
