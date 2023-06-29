package com.analista.desarrollo.infrastructure.adapter.persistence.repository;

import com.analista.desarrollo.infrastructure.adapter.persistence.entity.AssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, String> {
}
