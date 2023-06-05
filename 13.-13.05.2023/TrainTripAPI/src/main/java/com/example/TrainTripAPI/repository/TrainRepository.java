package com.example.TrainTripAPI.repository;

import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Train entities in the TrainTripAPI.
 */
public interface TrainRepository extends JpaRepository<Train, Integer> {

    /**
     * Retrieves a list of trains by name.
     *
     * @param name The name of the trains to retrieve.
     * @return A list of trains with the specified name.
     */
    List<Train> findByName(String name);

    /**
     * Retrieves a list of trains by number.
     *
     * @param number The number of the trains to retrieve.
     * @return A list of trains with the specified number.
     */
    List<Train> findByNumber(String number);

    /**
     * Retrieves a list of trains by train type.
     *
     * @param trainTypeId The train type of the trains to retrieve.
     * @return A list of trains with the specified train type.
     */
    List<Train> findByTrainTypeId(TrainType trainTypeId);

    /**
     * Retrieves a list of trains by car count.
     *
     * @param carCount The car count of the trains to retrieve.
     * @return A list of trains with the specified car count.
     */
    List<Train> findByCarCount(Integer carCount);

    /**
     * Retrieves a list of trains by seats per car.
     *
     * @param seatsPerCar The seats per car of the trains to retrieve.
     * @return A list of trains with the specified seats per car.
     */
    List<Train> findBySeatsPerCar(Integer seatsPerCar);
}
