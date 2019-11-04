package com.Dodon.Gatea.Saas.repository;

import com.Dodon.Gatea.Saas.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
