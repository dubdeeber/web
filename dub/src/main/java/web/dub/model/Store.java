package web.dub.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String manager;
    private int employeeCount;
    private double estimatedRevenue;

    @OneToMany(mappedBy = "frequentStore")
    private List<Customer> customers;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getManager() { return manager; }
    public void setManager(String manager) { this.manager = manager; }
    public int getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(int employeeCount) { this.employeeCount = employeeCount; }
    public double getEstimatedRevenue() { return estimatedRevenue; }
    public void setEstimatedRevenue(double estimatedRevenue) { this.estimatedRevenue = estimatedRevenue; }
    public List<Customer> getCustomers() { return customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
}
