package com.medical.entity;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.io.Serializable;

    import java.util.Date;



    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户表
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;


    private String username;

    private String password;

            /**
            * 姓名
            */
    private String name;

            /**
            * 出生日期
            */
    private LocalDate brithday;

            /**
            * 年龄
            */
    private Integer age;

            /**
            * 性别
            */
    private String sex;

            /**
            * 联系方式
            */
    private Integer tel;

            /**
            * 身份证
            */
    private String idcard;

            /**
            * 注册时间
            */
    private LocalDateTime enrollDate;

            /**
            * 医生外键
            */
    private Integer doid;

            /**
            * 封号状态
            */
    private String uState;
    /**
     * vip外键
     */
    private Integer vipId;

    /**
     * 用户收货地址
     */
    private String harvestAddress;


    private String harvestAddress;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getuState() {
        return uState;
    }

    public void setuState(String uState) {
        this.uState = uState;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", brithday=" + brithday +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", tel=" + tel +
                ", idcard='" + idcard + '\'' +
                ", enrollDate=" + enrollDate +
                ", doid=" + doid +
                ", uState='" + uState + '\'' +
                ", harvest_address='"  +
                '}';
    }

    public void setEnrollDate(Date date) {
    }
}
