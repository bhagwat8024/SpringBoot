package com.bhagwat.SpringBootWebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bhagwat.SpringBootWebApp.Model.*;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
