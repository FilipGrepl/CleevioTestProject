package com.app.database.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Watch {
    private @Id @GeneratedValue long id;

    @NotBlank
    private String title, description;

    @Min(1)
    private int price;

    private byte[] fountain;

    public Watch() {}

    public Watch(String title, String description, int price, byte[] fountain) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.fountain = fountain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getFountain() {
        return fountain;
    }

    public void setFountain(byte[] fountain) {
        this.fountain = fountain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Watch)) return false;
        Watch watch = (Watch) o;
        return id == watch.id && price == watch.price && Objects.equals(title, watch.title) && Objects.equals(description, watch.description) && Arrays.equals(fountain, watch.fountain);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, description, price);
        result = 31 * result + Arrays.hashCode(fountain);
        return result;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", fountain=" + Arrays.toString(fountain) +
                '}';
    }
}
