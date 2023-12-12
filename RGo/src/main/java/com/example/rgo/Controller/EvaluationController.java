package com.example.rgo.Controller;

import com.example.rgo.Model.Evaluation;
import com.example.rgo.Model.Order;
import com.example.rgo.Service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/eval")
public class EvaluationController {
    private final EvaluationService evaluationService;
    @GetMapping("/get")
    public List<Evaluation> getAllEvaluation(){
        return evaluationService.getAllEval();
    }
    @PostMapping("/add")
    public ResponseEntity addEvaluation(@RequestBody @Valid Evaluation evaluation, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        evaluationService.addEval(evaluation);
        return ResponseEntity.status(HttpStatus.OK).body("add Evaluation");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateEvaluation(@PathVariable Integer id, @RequestBody @Valid Evaluation evaluation, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        evaluationService.updateEvaluation(id, evaluation);
        return ResponseEntity.status(HttpStatus.OK).body("Update Evaluation");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvaluation(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(evaluationService.deleteEvaluation(id));
    } @GetMapping("/evalu/{num}")
    public ResponseEntity evalu(@PathVariable Integer num){
        List<Evaluation> evaluations =evaluationService.EvaluationGood(num);
        return ResponseEntity.status(HttpStatus.OK).body(evaluations);
    }
@GetMapping("/check/{num}")
public ResponseEntity checkEvalu(@PathVariable Integer num){
    List<Evaluation> evaluations =evaluationService.EvaluationCommend(num);
    return ResponseEntity.status(HttpStatus.OK).body(evaluations);
}

}
