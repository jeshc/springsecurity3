package com.jeshc.carssec.controller;

import com.jeshc.carssec.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/all")
    public String getAllVehicles(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "vehicles";
    }

    @GetMapping("/{id}")
    public String getVehicleById(Model model, @PathVariable int id) {
        model.addAttribute("vehicle", vehicleRepository.findById(id).get());
        return "vehicle";
    }


}
