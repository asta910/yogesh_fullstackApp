package com.Embarko1.Challange.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallangeService {
   // private List<Challange> challanges = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    ChallangeRepository challangeRepository;
    public ChallangeService(){}

    public List<Challange> getAllChallanges() {
        return challangeRepository.findAll();
    }

    public boolean addChallange(Challange challange) {
        if (challange != null) {
            challange.setId(nextId++);
            challangeRepository.save(challange);
            return true;
        } else {
            return false;
        }
    }

    public Challange getChallanges(String month) {
        Optional<Challange> challange = challangeRepository.findByMonthIgnoreCase(month);
        return challange.orElse(null);
    }
    public boolean updateChallange(Long id,Challange updatedChallange){
        Optional<Challange> challange = challangeRepository.findById(id);
        if(challange.isPresent()){
            Challange challangeToUpdate = challange.get();
            challangeToUpdate.setMonth(updatedChallange.getMonth());
            challangeToUpdate.setDescription(updatedChallange.getDescription());
            challangeRepository.save(challangeToUpdate);
            return true;
        }
        return false;
    }
    public boolean deleteChallange(Long id){
        Optional<Challange> challange = challangeRepository.findById(id);
        if(challange.isPresent()) {
            challangeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
