package com.vedatech.pro.repository;

import com.vedatech.pro.model.user.UserLog;
import org.springframework.data.repository.CrudRepository;

public interface UserLogDao extends CrudRepository<UserLog, Long> {

    public UserLog findByUsername(String username);
}
