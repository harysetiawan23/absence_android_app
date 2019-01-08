package com.example.harry.facialabsence.Model;

public class Pengajar {
    private String nama,image;

    public Pengajar(String nama, String image) {
        this.nama = nama;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
