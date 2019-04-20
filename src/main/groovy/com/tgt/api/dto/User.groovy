package com.tgt.api.dto

/**
 * Created by z001t7s on 2/20/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.mapping.Column

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table
import java.sql.Clob
import java.sql.Timestamp


@Table(name = 'User')
@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id

    @javax.persistence.Column
    private String userId

    @javax.persistence.Column
    private String appId

    @javax.persistence.Column
    private Date date


    @javax.persistence.Column
    private Timestamp timestamp


    @javax.persistence.Column
    @Lob
    private String stackTrace


    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getUserID() {
        return userId
    }

    void setUserID(String userID) {
        this.userId = userID
    }

    Timestamp getTimestamp() {
        return timestamp
    }

    void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp
    }

    String getAppId() {
        return appId
    }

    void setAppId(String appId) {
        this.appId = appId
    }

    String getStackTrace() {
        return stackTrace
    }

    void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }
}
