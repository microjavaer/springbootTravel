package com.bsm.entity;

import java.io.Serializable;

public class TProvince implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_province.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_province.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_province.tags
     *
     * @mbg.generated
     */
    private String tags;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_province.placecounts
     *
     * @mbg.generated
     */
    private Integer placecounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_province
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_province.id
     *
     * @return the value of t_province.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_province.id
     *
     * @param id the value for t_province.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_province.name
     *
     * @return the value of t_province.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_province.name
     *
     * @param name the value for t_province.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_province.tags
     *
     * @return the value of t_province.tags
     *
     * @mbg.generated
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_province.tags
     *
     * @param tags the value for t_province.tags
     *
     * @mbg.generated
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_province.placecounts
     *
     * @return the value of t_province.placecounts
     *
     * @mbg.generated
     */
    public Integer getPlacecounts() {
        return placecounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_province.placecounts
     *
     * @param placecounts the value for t_province.placecounts
     *
     * @mbg.generated
     */
    public void setPlacecounts(Integer placecounts) {
        this.placecounts = placecounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_province
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", tags=").append(tags);
        sb.append(", placecounts=").append(placecounts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}