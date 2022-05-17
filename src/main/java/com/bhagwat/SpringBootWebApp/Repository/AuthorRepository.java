package com.bhagwat.SpringBootWebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhagwat.SpringBootWebApp.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
}
