package me.ridog.valentine.pojo.auto;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.mail
     *
     * @mbggenerated
     */
    private String mail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.created
     *
     * @mbggenerated
     */
    private Long created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column valentine_users.activated
     *
     * @mbggenerated
     */
    private Long activated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.uid
     *
     * @return the value of valentine_users.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.uid
     *
     * @param uid the value for valentine_users.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.name
     *
     * @return the value of valentine_users.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.name
     *
     * @param name the value for valentine_users.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.password
     *
     * @return the value of valentine_users.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.password
     *
     * @param password the value for valentine_users.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.mail
     *
     * @return the value of valentine_users.mail
     *
     * @mbggenerated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.mail
     *
     * @param mail the value for valentine_users.mail
     *
     * @mbggenerated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.created
     *
     * @return the value of valentine_users.created
     *
     * @mbggenerated
     */
    public Long getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.created
     *
     * @param created the value for valentine_users.created
     *
     * @mbggenerated
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column valentine_users.activated
     *
     * @return the value of valentine_users.activated
     *
     * @mbggenerated
     */
    public Long getActivated() {
        return activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column valentine_users.activated
     *
     * @param activated the value for valentine_users.activated
     *
     * @mbggenerated
     */
    public void setActivated(Long activated) {
        this.activated = activated;
    }
}