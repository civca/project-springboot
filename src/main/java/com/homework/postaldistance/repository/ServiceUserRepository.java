package com.homework.postaldistance.repository;

import com.homework.postaldistance.model.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Milos
 */
public interface ServiceUserRepository extends JpaRepository<ServiceUser, Integer> {
    public ServiceUser findByUserName(String username);
    
}
