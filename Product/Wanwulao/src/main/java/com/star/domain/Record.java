package com.star.domain;

public class Record {
    private Integer id;

    private Integer uid;

    private Integer cid;

    private Integer status;

    private Double price;

    public Record() {
    }

    public Record(Integer id, Integer uid, Integer cid, Integer status, Double price) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
        this.status = status;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", uid=" + uid +
                ", cid=" + cid +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
