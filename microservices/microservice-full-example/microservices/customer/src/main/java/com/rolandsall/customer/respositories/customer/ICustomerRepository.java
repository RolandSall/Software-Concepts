package com.rolandsall.customer.respositories.customer;

import com.rolandsall.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
}
