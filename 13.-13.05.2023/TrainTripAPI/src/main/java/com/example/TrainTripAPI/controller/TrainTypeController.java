package com.example.TrainTripAPI.controller;

import com.example.TrainTripAPI.model.TrainType;
import com.example.TrainTripAPI.service.TrainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/train_types")
public class TrainTypeController {
    @Autowired
    private TrainTypeService trainTypeService;

    /**
     * Retrieves all train types.
     *
     * @return the list of all train types
     */
    @GetMapping("")
    public List<TrainType> getAllTypes(){
        return trainTypeService.getAllTrainTypes();
    }

    /**
     * Retrieves a train type by its ID.
     *
     * @param id the ID of the train type
     * @return the ResponseEntity with the retrieved train type if found, or NOT_FOUND if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<TrainType> get(@PathVariable Integer id){
        try{
            TrainType trainType = trainTypeService.getTrainTypeById(id);
            return new ResponseEntity<TrainType>(trainType, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<TrainType>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves train types by name.
     *
     * @param name the name of the train types
     * @return the list of train types with the specified name
     */
    @GetMapping("/name/{name}")
    public List<TrainType> getByName(@PathVariable String name){
        return trainTypeService.getTrainTypeByName(name);
    }

    /**
     * Adds a new train type.
     *
     * @param trainType the train type to be added
     */
    @PostMapping("/")
    public void add(@RequestBody TrainType trainType){
        trainTypeService.saveTrainType(trainType);
    }

    /**
     * Deletes a train type by its ID.
     *
     * @param id the ID of the train type to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        trainTypeService.deleteTrainType(id);
    }

    /**
     * Updates a train type by its ID.
     *
     * @param trainType the updated train type object
     * @param id the ID of the train type to be updated
     * @return the ResponseEntity with HTTP status OK if the train type is updated successfully, or NOT_FOUND if the train type is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TrainType trainType, @PathVariable Integer id){
        try{
            TrainType baseTrainType = trainTypeService.getTrainTypeById(id);
            baseTrainType.updateType(trainType);
            trainTypeService.saveTrainType(baseTrainType);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
