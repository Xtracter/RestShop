package com.crazedout.restshop.controller;

import com.crazedout.restshop.model.ShopModel;
import com.crazedout.restshop.service.RESTService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/restshop")
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    private final RESTService service;

    private final String modelID = "model";
    private final String pageID = "restshop"; // templates/restshop.html
    private final String formID = "restshop-form"; // templates/restshop-form.html

    public PageController(RESTService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute(modelID, service.findAll());
        return pageID;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute(modelID, new ShopModel());
        return formID;
    }

    @PostMapping("/create")
    public String createSubmit(
            @Valid @ModelAttribute(pageID) ShopModel model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return formID;
        }
        service.save(model);
        return "redirect:/" + pageID;
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        var restshop = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Rest Shop not found"));
        model.addAttribute(modelID, restshop);
        return formID;
    }

    @PostMapping("/edit/{id}")
    public String editSubmit(
            @PathVariable Long id,
            @Valid @ModelAttribute(pageID) ShopModel model,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return formID;
        }

        model.setId(id);
        service.save(model);
        return "redirect:/" + pageID;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/" + pageID;
    }
}
