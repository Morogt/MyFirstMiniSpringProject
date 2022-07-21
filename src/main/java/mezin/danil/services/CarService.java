package mezin.danil.services;

import mezin.danil.models.Car;
import mezin.danil.models.Person;
import mezin.danil.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findOne(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Transactional
    public void save(@Valid Car car) {
        carRepository.save(car);
    }

    @Transactional
    public void update(int id, Car updatedCar) {
        Car carForUpdate = carRepository.findById(id).get();

        updatedCar.setId(id);
        updatedCar.setPersonId(carForUpdate.getPersonId());
        carRepository.save(updatedCar);

    }

    @Transactional
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    public Person getCarOwner(int id) {
        return carRepository.findById(id).map(Car::getPersonId).orElse(null);
    }

    @Transactional
    public void release(int id) {
        carRepository.findById(id).ifPresent(car -> car.setPersonId(null));
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        carRepository.findById(id).ifPresent(car -> car.setPersonId(selectedPerson));
    }
}
