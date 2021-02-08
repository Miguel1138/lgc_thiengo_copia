package com.miguel_santos.com.example.lgc_thiengo_copia.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Comercio implements Parcelable{

    public static final String COMERCIO_SELECIONADO_KEY = "comercion_selecionado";

    private int imagem;
    private String nomeFantasia;
    private String localizacao;
    private double avaliacaoPontos;
    private int avaliacaoQtd;
    private List<Comentario> comentarios;

    public Comercio(int imagem, String nomeFantasia, String localizacao, double avaliacaoPontos, int avaliacaoQtd, List<Comentario> comentarios) {
        this.imagem = imagem;
        this.nomeFantasia = nomeFantasia;
        this.localizacao = localizacao;
        this.avaliacaoPontos = avaliacaoPontos;
        this.avaliacaoQtd = avaliacaoQtd;
        this.comentarios = comentarios;
    }


    //Apagar construtor posteriormente

    public Comercio(int imagem, String nomeFantasia, String localizacao, double avaliacaoPontos, int avaliacaoQtd) {
        this.imagem = imagem;
        this.nomeFantasia = nomeFantasia;
        this.localizacao =localizacao;
        this.avaliacaoPontos = avaliacaoPontos;
        this.avaliacaoQtd = avaliacaoQtd;
        comentarios = new ArrayList<>();
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getAvaliacaoPontos() {
        return avaliacaoPontos;
    }

    public void setAvaliacaoPontos(double avaliacaoPontos) {
        this.avaliacaoPontos = avaliacaoPontos;
    }

    public int getAvaliacaoQtd() {
        return avaliacaoQtd;
    }

    public void setAvaliacaoQtd(int avaliacaoQtd) {
        this.avaliacaoQtd = avaliacaoQtd;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imagem);
        dest.writeString(this.nomeFantasia);
        dest.writeString(this.localizacao);
        dest.writeDouble(this.avaliacaoPontos);
        dest.writeInt(this.avaliacaoQtd);
        dest.writeList(this.comentarios);
    }

    protected Comercio(Parcel in) {
        imagem = in.readInt();
        nomeFantasia = in.readString();
        localizacao = in.readString();
        avaliacaoPontos = in.readDouble();
        avaliacaoQtd = in.readInt();
        comentarios = in.createTypedArrayList(Comentario.CREATOR);
    }

    public static final Creator<Comercio> CREATOR = new Creator<Comercio>() {
        @Override
        public Comercio createFromParcel(Parcel in) {
            return new Comercio(in);
        }

        @Override
        public Comercio[] newArray(int size) {
            return new Comercio[size];
        }
    };

}
