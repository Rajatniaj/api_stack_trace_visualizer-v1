package com.tgt.api.repository

import com.tgt.api.dto.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

import java.sql.Timestamp

/**
 * Created by z001t7s on 1/27/18.
 */
@Repository
interface UserRepository extends JpaRepository<User,Long>{

    List<User>  getUserByAppId(String appId)

    @Query("SELECT u FROM User u WHERE appId =:appId AND timestamp BETWEEN :oldTimestamp AND :currentTimestamp")
    List<User>  getHourBasedStacks(@Param("appId") String appId, @Param("oldTimestamp") Timestamp oldTimestamp, @Param("currentTimestamp") Timestamp currentTimestamp)

}