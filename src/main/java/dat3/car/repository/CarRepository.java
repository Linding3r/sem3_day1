package dat3.car.repository;

import dat3.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car getCarByBrandAndModel(String carBrand, String carModel);

    List<Car> findAllWhereAvailable();
}
