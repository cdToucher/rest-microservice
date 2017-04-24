package me.myProjects.microservice.core.bean.orm;

/**
 * Created by chendong on 2017/4/24.
 *
 * orm bean
 */
public class UserInfo {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private long id;

    private String name;

    private String email;

    private String phone;

    private String description;
}
