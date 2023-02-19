package dat3.car.service;

import dat3.car.dto.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarServiceH2Test {

    @Autowired
    public CarRepository carRepository;

    CarService carService;

    boolean dataIsReady = false;

    @BeforeEach
    void setUp() {
        if(!dataIsReady){
            carRepository.save(new Car("brand1", "model1", 100, 10));
            carRepository.save(new Car("brand2", "model2", 200, 20));
            dataIsReady = true;
            carService = new CarService(carRepository);
        }
    }

    @Test
    void getCars() {
        List<CarResponse> carResponses = carService.getCars(true);
        assertEquals(2, carResponses.size());
        assertNotNull(carResponses.get(0).getCreated());
    }

}