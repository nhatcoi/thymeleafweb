package org.example.mywebapp.repository;

import org.example.mywebapp.entity.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Integer>{
    public Long countById(Integer id);
//
}
