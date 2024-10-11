package org.example.mywebapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.mywebapp.dto.StaffDTO;
import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.exception.StaffNotFoundException;
import org.example.mywebapp.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
    private final ModelMapper modelMapper;

    // Read
    @GetMapping("/staffs/show")
    public String showStaffList(Model model) {
        List<Staff> listStaffs = staffService.listAll();
        List<StaffDTO> listStaffDTOs = new ArrayList<>();
        for (Staff staff : listStaffs) {
            StaffDTO staffDTO = modelMapper.map(staff, StaffDTO.class);
            listStaffDTOs.add(staffDTO);
        }
        model.addAttribute("listStaffs", listStaffDTOs);
        return "staffs";
    }


    // Create
    @GetMapping("/staffs/new")
    public String showNewForm(Model model) {
        model.addAttribute("staff", new StaffDTO());
        model.addAttribute("pageTitle", "Create New Staff");
        return "staff_form";
    }

    // Update
    @GetMapping("/staffs/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Staff staff = staffService.get(id);
            StaffDTO staffDTO = modelMapper.map(staff, StaffDTO.class);

            model.addAttribute("staff", staffDTO);
            model.addAttribute("pageTitle", "Edit Staff (ID: " + id + ")");
            return "staff_form";
        } catch (StaffNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/staffs/show";
        }
    }

    // Delete
    @GetMapping("/staffs/delete/{id}")
    public String deleteStaff(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            staffService.delete(id);
            ra.addFlashAttribute("message", "The staffs ID " + id + " has been deleted successfully.");
        } catch (StaffNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/staffs/show";
    }


    // Save
    @PostMapping("/staffs/save")
    public String saveStaff(StaffDTO staffDTO, RedirectAttributes ra) {
        staffService.save(staffDTO);
        ra.addFlashAttribute("message", "The staff has been saved successfully.");
        return "redirect:/staffs/show";
    }
}
