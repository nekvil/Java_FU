package com.example.TrainTripAPI.service;

import com.example.TrainTripAPI.model.TrainType;
import com.example.TrainTripAPI.repository.TrainTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing TrainType entities in the TrainTripAPI.
 */
@Service
@Transactional
public class TrainTypeService {
    @Autowired
    private TrainTypeRepository trainTypeRepository;

    /**
     * Retrieves all train types.
     *
     * @return A list of all train types.
     */
    public List<TrainType> getAllTrainTypes(){
        return trainTypeRepository.findAll();
    }

    /**
     * Retrieves train types by name.
     *
     * @param name The name of the train type.
     * @return A list of train types with the specified name.
     */
    public List<TrainType> getTrainTypeByName(String name){
        return trainTypeRepository.findByName(name);
    }

    /**
     * Saves a train type.
     *
     * @param trainType The train type to be saved.
     */
    public void saveTrainType(TrainType trainType){
        trainTypeRepository.save(trainType);
    }

    /**
     * Deletes a train type by ID.
     *
     * @param id The ID of the train type to be deleted.
     */
    public void deleteTrainType(Integer id){
        trainTypeRepository.deleteById(id);
    }

    /**
     * Retrieves a train type by ID.
     *
     * @param id The ID of the train type.
     * @return The train type with the specified ID, or null if not found.
     */
    public TrainType getTrainTypeById(Integer id){
        return trainTypeRepository.findById(id).orElse(null);
    }
}
