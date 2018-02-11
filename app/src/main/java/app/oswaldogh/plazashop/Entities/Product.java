package app.oswaldogh.plazashop.Entities;

import java.io.File;
import java.util.List;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public class Product {
    private int id;
    private String nombre;
    private float precio;
    private int local;
    private String descripcion;
    private String url;
    private int categoria;
    private int views;
    private List<File> image;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<File> getImage() {
        return image;
    }

    public File getImageFile(int position){
        return image.get(position);
    }

    public void setImage(List<File> image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Product() {
    }

    public Product(int id, String descripcion, float price, int local, int views, String url) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = price;
        this.local = local;
        this.views = views;
        this.url = url;
    }

}
