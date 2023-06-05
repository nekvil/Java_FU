package com.example.TrainTripAPI.service;

import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.TrainType;
import com.example.TrainTripAPI.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Train entities in the TrainTripAPI.
 */
@Service
@Transactional
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    /**
     * Retrieves all trains.
     *
     * @return A list of all trains.
     */
    public List<Train> getAllTrains(){
        return trainRepository.findAll();
    }

    /**
     * Retrieves trains by name.
     *
     * @param name The name of the train.
     * @return A list of trains with the specified name.
     */
    public List<Train> getTrainByName(String name){
        return trainRepository.findByName(name);
    }

    /**
     * Retrieves trains by number.
     *
     * @param number The number of the train.
     * @return A list of trains with the specified number.
     */
    public List<Train> getTrainByNumber(String number){
        return trainRepository.findByNumber(number);
    }

    /**
     * Retrieves trains by train type.
     *
     * @param trainTypeId The train type of the trains.
     * @return A list of trains with the specified train type.
     */
    public List<Train> getTrainByTrainTypeId(TrainType trainTypeId){
        return trainRepository.findByTrainTypeId(trainTypeId);
    }

    /**
     * Retrieves trains by car count.
     *
     * @param carCount The car count of the trains.
     * @return A list of trains with the specified car count.
     */
    public List<Train> getTrainByCarCount(int carCount){
        return trainRepository.findByCarCount(carCount);
    }

    /**
     * Retrieves trains by seats per car.
     *
     * @param seatsPerCar The seats per car of the trains.
     * @return A list of trains with the specified seats per car.
     */
    public List<Train> getTrainBySeatsPerCar(int seatsPerCar){
        return trainRepository.findBySeatsPerCar(seatsPerCar);
    }

    /**
     * Saves a train.
     *
     * @param train The train to be saved.
     */
    public void saveTrain(Train train){
        trainRepository.save(train);
    }

    /**
     * Deletes a train by ID.
     *
     * @param id The ID of the train to be deleted.
     */
    public void deleteTrain(Integer id){
        trainRepository.deleteById(id);
    }

    /**
     * Retrieves a train by ID.
     *
     * @param id The ID of the train.
     * @return The train with the specified ID, or null if not found.
     */
    public Train getTrainById(Integer id){
        return trainRepository.findById(id).orElse(null);
    }
}
