package com.task.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.loan.model.CreditInfoModel;


@Repository
public interface LoancheckRepository extends JpaRepository<CreditInfoModel, String> {

}
