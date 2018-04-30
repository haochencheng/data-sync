package pers.doc.sync.model;

import com.github.crab2died.annotation.ExcelField;

import javax.persistence.*;

/**
 * 调度数据源
 */
@Entity
public class SchedulingDataSource {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //主键
    @ExcelField(title="机构")
    private String organization; //机构
    @ExcelField(title="配送中心")
    private String deliveryCenter; //配送中心
    @ExcelField(title="订单号")
    private String orderNo; //订单号
    @ExcelField(title="承运商")
    private String carrier; //承运商
    @ExcelField(title="路区")
    private Integer roadArea; //路区
    @ExcelField(title="预约人")
    private String appointmentPerson; //预约人
    @ExcelField(title="派车人")
    private String carOwners; //派车人
    @ExcelField(title="车辆名称")
    private String carName; //车辆名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDeliveryCenter() {
        return deliveryCenter;
    }

    public void setDeliveryCenter(String deliveryCenter) {
        this.deliveryCenter = deliveryCenter;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getRoadArea() {
        return roadArea;
    }

    public void setRoadArea(Integer roadArea) {
        this.roadArea = roadArea;
    }

    public String getAppointmentPerson() {
        return appointmentPerson;
    }

    public void setAppointmentPerson(String appointmentPerson) {
        this.appointmentPerson = appointmentPerson;
    }

    public String getCarOwners() {
        return carOwners;
    }

    public void setCarOwners(String carOwners) {
        this.carOwners = carOwners;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
