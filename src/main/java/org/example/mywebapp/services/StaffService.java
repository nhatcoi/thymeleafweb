package org.example.mywebapp.services;

import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.exception.StaffNotFoundException;

import java.util.List;

public interface StaffService {
    List<Staff> listAll();
    void save(Staff staff);
    void delete(Integer id) throws StaffNotFoundException;
    Staff get(Integer id) throws StaffNotFoundException;
}