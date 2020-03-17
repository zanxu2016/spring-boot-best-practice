package info.luckydog.springboot.mapstruct.model;

import info.luckydog.springboot.mapstruct.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Car
 *
 * @author eric
 * @since 2020/1/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;

//    public Car(String make, int numberOfSeats, CarType type) {
//        this.make = make;
//        this.numberOfSeats = numberOfSeats;
//        this.type = type;
//    }
//
//    public Car() {
//    }
//
//    public String getMake() {
//        return make;
//    }
//
//    public void setMake(String make) {
//        this.make = make;
//    }
//
//    public int getNumberOfSeats() {
//        return numberOfSeats;
//    }
//
//    public void setNumberOfSeats(int numberOfSeats) {
//        this.numberOfSeats = numberOfSeats;
//    }
//
//    public CarType getType() {
//        return type;
//    }
//
//    public void setType(CarType type) {
//        this.type = type;
//    }
}
