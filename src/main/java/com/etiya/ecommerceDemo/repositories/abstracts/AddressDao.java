package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository<Address,Long> {
    @Query(value = "SELECT a.* FROM addresses a INNER JOIN users u ON u.id = a.user_id", nativeQuery = true)
    List<Address> getAddressByUserId();
}
