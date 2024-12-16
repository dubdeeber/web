package web.dub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dub.model.Store;
import web.dub.repository.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public String listStores(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        return "stores";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("store", new Store());
        return "store_form";
    }

    @PostMapping
    public String saveStore(@ModelAttribute Store store) {
        storeRepository.save(store);
        return "redirect:/stores";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Store store = storeRepository.findById(id).orElseThrow();
        model.addAttribute("store", store);
        return "store_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable Long id) {
        storeRepository.deleteById(id);
        return "redirect:/stores";
    }
}