package me.ridog.valentine.result;

import java.util.Date;

/**
 * Created by Tate on 2016/7/28.
 */
public class UserResult {

    private Integer id;
    private String username;
    private String mail;
    private Date created;
    private Date activated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }
}
