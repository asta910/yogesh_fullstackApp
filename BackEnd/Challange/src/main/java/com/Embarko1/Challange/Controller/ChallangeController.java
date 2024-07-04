package com.Embarko1.Challange.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challanges")
@CrossOrigin(origins = "http://localhost:5173/")
public class ChallangeController {
    private final ChallangeService challangeService;

    public ChallangeController(ChallangeService challangeService) {
        this.challangeService = challangeService;
    }

    @GetMapping
    public ResponseEntity<List<Challange>> getAllChallanges() {
        return new ResponseEntity<>(challangeService.getAllChallanges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallange(@RequestBody Challange challange) {
        boolean isChallangeAdded = challangeService.addChallange(challange);
        if (isChallangeAdded) {
            return new ResponseEntity<>("Challange added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challange not added", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challange> getChallanges(@PathVariable String month) {
        Challange challange = challangeService.getChallanges(month);
        if (challange != null) {
            return new ResponseEntity<>(challange, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable Long id,@RequestBody Challange updatedChallange) {
        boolean isChallangeUpdated = challangeService.updateChallange(id, updatedChallange);
        if (isChallangeUpdated) {
            return new ResponseEntity<>("updated challange succesfully ", HttpStatus.OK);
        }
        return new ResponseEntity<>("cannot update challange", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallange(@PathVariable Long id){
        boolean isDeleted = challangeService.deleteChallange(id);
        if(isDeleted){
            return new ResponseEntity<>("Challange deleted succesfully",HttpStatus.OK);
        }
            return new ResponseEntity<>("Challange not found",HttpStatus.NOT_FOUND);
    }
    //@PatchMapping
}
