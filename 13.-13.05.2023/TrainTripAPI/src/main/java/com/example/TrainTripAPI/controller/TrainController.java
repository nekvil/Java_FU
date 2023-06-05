package com.example.TrainTripAPI.controller;

import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.TrainType;
import com.example.TrainTripAPI.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    /**
     * Retrieves all trains.
     *
     * @return the list of all trains
     */
    @GetMapping("")
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    /**
     * Retrieves a train by its ID.
     *
     * @param id the ID of the train
     * @return the ResponseEntity with the retrieved train if found, or NOT_FOUND if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Train> get(@PathVariable Integer id){
        try{
            Train train = trainService.getTrainById(id);
            return new ResponseEntity<Train>(train, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves trains by name.
     *
     * @param name the name of the trains
     * @return the list of trains with the specified name
     */
    @GetMapping("/name/{name}")
    public List<Train> getByName(@PathVariable String name){
        return trainService.getTrainByName(name);
    }

    /**
     * Retrieves trains by number.
     *
     * @param number the number of the trains
     * @return the list of trains with the specified number
     */
    @GetMapping("/number/{number}")
    public List<Train> getByNumber(@PathVariable String number){
        return trainService.getTrainByNumber(number);
    }

    /**
     * Retrieves trains by train type ID.
     *
     * @param trainTypeId the ID of the train type
     * @return the list of trains with the specified train type ID
     */
    @GetMapping("/train_type/{trainTypeId}")
    public List<Train> getByTrainTypeId(@PathVariable TrainType trainTypeId){
        return trainService.getTrainByTrainTypeId(trainTypeId);
    }

    /**
     * Retrieves trains by car count.
     *
     * @param carCount the number of cars in the trains
     * @return the list of trains with the specified car count
     */
    @GetMapping("/car_count/{carCount}")
    public List<Train> getByCarCount(@PathVariable int carCount){
        return trainService.getTrainByCarCount(carCount);
    }

    /**
     * Retrieves trains by seats per car count.
     *
     * @param seatsPerCar the number of seats per car in the trains
     * @return the list of trains with the specified seats per car count
     */
    @GetMapping("/seats_per_car/{seatsPerCar}")
    public List<Train> getBySeatsPerCar(@PathVariable int seatsPerCar){
        return trainService.getTrainBySeatsPerCar(seatsPerCar);
    }

    /**
     * Adds a new train.
     *
     * @param train the train to be added
     */
    @PostMapping("/")
    public void add(@RequestBody Train train){
        trainService.saveTrain(train);
    }

    /**
     * Deletes a train by its ID.
     *
     * @param id the ID of the train to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        trainService.deleteTrain(id);
    }

    /**
     * Updates a train by its ID.
     *
     * @param train the updated train object
     * @param id the ID of the train to be updated
     * @return the ResponseEntity with HTTP status OK if the train is updated successfully, or NOT_FOUND if the train is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Train train, @PathVariable Integer id){
        try{
            Train baseTrain = trainService.getTrainById(id);
            baseTrain.updateTrain(train);
            trainService.saveTrain(baseTrain);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

