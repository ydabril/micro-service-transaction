package com.emazon.mstransaction.adapters.driven.jpa.mysql.repository;

import com.emazon.mstransaction.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.emazon.mstransaction.domain.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
    Optional<SupplyEntity> findTopByArticleIdOrderByRegistrationDateDesc(Long articleId);
}
