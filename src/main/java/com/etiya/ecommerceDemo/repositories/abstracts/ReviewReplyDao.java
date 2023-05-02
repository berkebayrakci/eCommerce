package com.etiya.ecommerceDemo.repositories.abstracts;

import com.etiya.ecommerceDemo.entities.concretes.ReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewReplyDao extends JpaRepository<ReviewReply,Long> {
}
