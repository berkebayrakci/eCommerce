package com.etiya.ecommerceDemo.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review_replies")
public class ReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reply_date")
    private Date replyDate;

    @Column(name = "reply_text")
    private String replyText;

    @ManyToOne()
    @JoinColumn(name = "user_id")
     private User user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private ProductReview productReview;



}