package web.dub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dub.model.Customer;
import web.dub.repository.CustomerRepository;
import web.dub.repository.StoreRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final StoreRepository storeRepository;

    public CustomerController(CustomerRepository customerRepository, StoreRepository storeRepository) {
        this.customerRepository = customerRepository;
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("stores", storeRepository.findAll());
        return "customer_form";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        model.addAttribute("customer", customer);
        model.addAttribute("stores", storeRepository.findAll());
        return "customer_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }
}