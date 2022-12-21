package com.example.tiendadeportivaversion4.entidades;
import java.util.UUID;

public class Producto {
    private String id;
    private String name;
    private String description;
    private long price;
    private String image;
    private String latitud;
    private String longitud;

    public Producto(String id, String name, String description, long price, String image, String latitud, String longitud) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Producto(String name, String description, long price, String image, String latitud, String longitud) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
