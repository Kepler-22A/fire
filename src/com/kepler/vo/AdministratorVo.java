package com.kepler.vo;

import javax.persistence.*;

@Table(name = "AdministratorVo")
@Entity
public class AdministratorVo { //系统管理员表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID; //id
    private String administratorName; //管理员名字
    private String password; //密码
    private String remark; //说明

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AdministratorVo{" +
                "ID=" + ID +
                ", administratorName='" + administratorName + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
