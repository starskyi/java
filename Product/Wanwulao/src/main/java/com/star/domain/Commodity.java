package com.star.domain;

/**
 * id 商品编号
 * image 图片路径
 * tittle 商品标题
 * price 商品价格
 * count 总销量
 */
public class Commodity {
    private Integer id;

    private String image;

    private String title;

    private Double price;

    private Integer count;

    private Integer repertory;

    private String shop;

    private Integer kind;

    public Commodity() {
    }

    public Commodity(Integer id, String image, String title, Double price, Integer count, Integer repertory, String shop, Integer kind) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.count = count;
        this.repertory = repertory;
        this.shop = shop;
        this.kind = kind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", repertory=" + repertory +
                ", shop='" + shop + '\'' +
                ", kind=" + kind +
                '}';
    }
}
