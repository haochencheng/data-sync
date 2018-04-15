package pers.doc.sync.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class HalfYearDataStatistical {

    @Id
    @GeneratedValue
    private Long id;
    private Date StatisticalDate;
    private String area;
    private int totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatisticalDate() {
        return StatisticalDate;
    }

    public void setStatisticalDate(Date statisticalDate) {
        StatisticalDate = statisticalDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
