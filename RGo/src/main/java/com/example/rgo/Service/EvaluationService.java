package com.example.rgo.Service;

import com.example.rgo.ApiException.ApiException;
import com.example.rgo.Model.*;
import com.example.rgo.Repository.EvaluationRepository;
import com.example.rgo.Repository.OrderRepository;
import com.example.rgo.Repository.RestaurantRepository;
import com.example.rgo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final EvaluationRepository evaluationRepository;
     public List<Evaluation> getAllEval(){
         return evaluationRepository.findAll();
     }
     public Evaluation addEval(Evaluation evaluation){
         MyUser user = userRepository.findMyUserById(evaluation.getUserId());
         if (user == null) {
             throw new ApiException("The user not Found");
         }
         Restaurant restaurant = restaurantRepository.findRestaurantById(evaluation.getRestaurantId());
         if (restaurant == null) {
             throw new ApiException("The Restaurant not Found");
         }
         Order order =orderRepository.findOrderById(evaluation.getOrderID());
         if (order == null) {
             throw new ApiException("The Order not Found");

         }
         evaluationRepository.save(evaluation);
         return evaluation;
     }
     public Evaluation updateEvaluation(Integer id ,Evaluation evaluation){
        Evaluation oldEval =evaluationRepository.find(id);
         if (oldEval == null) {
             throw new ApiException("The Order not Found");
         }
         oldEval.setEvan(evaluation.getEvan());
         oldEval.setComment(evaluation.getComment());
         evaluationRepository.save(oldEval);
         return oldEval;
     }
    public Evaluation deleteEvaluation(Integer id ) {
        Evaluation oldEval = evaluationRepository.find(id);
        if (oldEval == null) {
            throw new ApiException("The Order not Found");
        }
        evaluationRepository.delete(oldEval);
        return oldEval;
    }
    public List<Evaluation> EvaluationGood(Integer number){
        List<Evaluation> evaluations =evaluationRepository.findEvaluationByEvan(number);
        if (evaluations == null) {
            throw new ApiException("he does not own you number");
        }
        return evaluations;
    }
    public List<Evaluation> EvaluationCommend(Integer number ){
        List<Evaluation> evaluations =evaluationRepository.findAll();
        if (evaluations == null) {
            throw new ApiException("does not commend");
        }
        ArrayList<Evaluation> ob = new ArrayList<>();
        for (Evaluation e: evaluations) {
            if (e.getComment().length()>=number){
             ob.add(e);
            }
        }


        return ob;
    }
    //وقفت هنا
    public List<Evaluation> totalEvaluation(Integer num){
        List<Evaluation> evaluations =evaluationRepository.findAll();
        float total =0;
        int nu =0;
        for (int i = 0; i <evaluations.size() ; i++) {
            total += evaluations.get(i).getEvan();
            nu += i;

        }
        float nm = total/evaluations.size();


        for (Evaluation e:evaluations) {
            total+=  e.getEvan();
            nu ++;
//            e.setTotal( total+=e.getTotal());
        }
       return evaluations;
    }
}
