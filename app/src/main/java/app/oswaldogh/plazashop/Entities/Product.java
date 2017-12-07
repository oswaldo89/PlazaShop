package app.oswaldogh.plazashop.Entities;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public class Product {
    private int id;
    private String description;
    private String url;
    private float price;
    private int local;
    private int views;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product(int id, String description, float price, int local, int views,String url) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.local = local;
        this.views = views;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
