package com.masters.coding.garage;

import com.masters.coding.garage.model.Garage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/garages")
@RequiredArgsConstructor
public class GarageController {

    private final GarageService garageService;

    @GetMapping
    public String getGarageList(Model model) {
        model.addAttribute("garages", garageService.findAll());
        return "garage/list";
    }

    @GetMapping("/create")
    public String getGarageCreateForm(Model model) {
        model.addAttribute("garage", new Garage());
        return "garage/form";
    }

    @PostMapping("/create")
    public String createGarage(Garage garage) {
        garageService.save(garage);
        return "redirect:/garages";
    }

    @GetMapping("/{id}")
    public String getGarageDetails(int id, Model model) {
        Garage garage = garageService.getGarageById(id);
        model.addAttribute("garage", garage);
        model.addAttribute("cars", garage.getCars());
        return "garage/details";
    }

    @DeleteMapping("/{id}")
    public void deleteGarage(int id) {
        garageService.deleteById(id);
    }


}
