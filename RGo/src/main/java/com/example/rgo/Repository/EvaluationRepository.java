package com.example.rgo.Repository;

import com.example.rgo.Model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {


    List<Evaluation> findEvaluationById(Integer id);
    List<Evaluation> findEvaluationByEvan(Integer number);

    List<Evaluation> findEvaluationByComment(String message);
  @Query("select e from  Evaluation  e where e.id=?1")
    Evaluation find(Integer id);
    @Query("select sum(e.evan) from Evaluation e ")
    Integer findOrderByProductId(Integer id);

}
