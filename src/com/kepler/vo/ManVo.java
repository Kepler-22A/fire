package com.kepler.vo;


import javax.persistence.*;
import java.util.Date;

@Table(name = "ManVo")
@Entity
public class ManVo { //被邀请人
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; //ID
    private String manName; //邀请人名字
    private String remark; //说明
    private Date insertDate; //录入时间
    private String menu; //菜单
    private String wishTime; //期望参加时间

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getWishTime() {
        return wishTime;
    }

    public void setWishTime(String wishTime) {
        this.wishTime = wishTime;
    }

    @Override
    public String toString() {
        return "ManVo{" +
                "ID=" + ID +
                ", manName='" + manName + '\'' +
                ", remark='" + remark + '\'' +
                ", insertDate=" + insertDate +
                ", menu='" + menu + '\'' +
                ", wishTime='" + wishTime + '\'' +
                '}';
    }
}
