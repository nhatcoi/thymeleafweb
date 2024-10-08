package org.example.mywebapp.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.exception.StaffNotFoundException;
import org.example.mywebapp.repository.StaffRepository;
import org.example.mywebapp.services.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository repo;

    @Override
    public List<Staff> listAll() {
        return (List<Staff>) repo.findAll();
    }

    @Override
    public void save(Staff staff) {
        repo.save(staff);
    }

    @Override
    public void delete(Integer id) throws StaffNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new StaffNotFoundException("Could not find any user with ID " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public Staff get(Integer id) throws StaffNotFoundException {
        Optional<Staff> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new StaffNotFoundException("Could not find any user with ID " + id);
    }
}
