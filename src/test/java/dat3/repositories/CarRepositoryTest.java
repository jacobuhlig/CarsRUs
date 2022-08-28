package dat3.repositories;

import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;


    static int car1;

    static int car2;

    //Tests
    @BeforeAll
    public static void setupData(@Autowired CarRepository carRepository) {
        //Creation of objects
        Car c1 = new Car("Volvo", "PC60", 200, 10);
        Car c2 = new Car("Volvo", "P1900", 250, 15);

        //Saving objects to local database (H2)
        carRepository.save(c1);
        carRepository.save(c2);

        car1 = c1.getId();
        car2 = c2.getId();
    }

    @Test
    public void testFindById() {

        Car found1 = carRepository.findById(car1).get();
        Car found2 = carRepository.findById(car2).get();

        assertEquals(car1, found1.getId());
        assertEquals(car2, found2.getId());

        assertEquals("PC60", found1.getModel());
        assertEquals("P1900", found2.getModel());
    }


}
