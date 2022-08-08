package model;


import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private long id;
    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private double totalPrice;

    public Order(long id, String email, double totalPrice) {
        this.id = id;
        this.email = email;
        this.totalPrice = totalPrice;
    }
    public Order() {
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
