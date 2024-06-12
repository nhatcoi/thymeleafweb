package org.example.mywebapp.services;

import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.exception.StaffNotFoundException;
import org.example.mywebapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repo;

    public List<Staff> listAll() {
        return (List<Staff>) repo.findAll();
    }

    public void save(Staff staff) {
        repo.save(staff);
    }

    public void delete(Integer id) throws StaffNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new StaffNotFoundException("Could not find any user with ID " + id);
        }
        repo.deleteById(id);
    }

    public Staff get(Integer id) throws StaffNotFoundException {
        Optional<Staff> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new StaffNotFoundException("Could not find any user with ID " + id);
    }
}
