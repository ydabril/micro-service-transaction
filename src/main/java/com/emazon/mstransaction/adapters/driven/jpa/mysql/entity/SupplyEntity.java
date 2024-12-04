package com.emazon.mstransaction.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "supply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long articleId;
    private Long quantity;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
    @Column(name = "estimated_next_restock_date", nullable = false)
    private LocalDate estimatedRestockDate;
}
