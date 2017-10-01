package cn.hellomiao.www.cxsj.main.entity;

/**
 * Created by liwenban on 2017/9/30.
 */

public class User {

    private String userId;

    private String password;

    private Integer userType;

    private String phone;

    private String name;

    private Integer companyId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public User(){}

    public User(String userId, String password, Integer userType, String phone, String name, Integer companyId) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.phone = phone;
        this.name = name;
        this.companyId = companyId;
    }

}
