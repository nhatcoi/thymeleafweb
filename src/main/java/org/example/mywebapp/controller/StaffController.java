package org.example.mywebapp.controller;

import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.exception.StaffNotFoundException;
import org.example.mywebapp.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StaffController {
    @Autowired private StaffService service;

    @GetMapping("/staffs")
    public String showStaffList(Model model) {
        List<Staff> listStaffs = service.listAll();
        model.addAttribute("listStaffs", listStaffs);
        return "staffs";
    }

    @GetMapping("/staffs/new")
    public String showNewForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("pageTitle", "Create New Staff");
        return "staff_form";
    }

    @PostMapping("/staffs/save")
    public String saveStaff(Staff staff, RedirectAttributes ra) {
        service.save(staff);
        ra.addFlashAttribute("message", "The staff has been saved successfully.");
        return "redirect:/staffs";
    }

    @GetMapping("/staffs/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Staff staff = service.get(id);
            model.addAttribute("staff", staff);
            model.addAttribute("pageTitle", "Edit Staff (ID: " + id + ")");
            return "staff_form";
        } catch (StaffNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/staffs";
        }
    }

    @GetMapping("/staffs/delete/{id}")
    public String deleteStaff(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The staffs ID " + id + " has been deleted successfully.");
        } catch (StaffNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/staffs";
    }

 }
