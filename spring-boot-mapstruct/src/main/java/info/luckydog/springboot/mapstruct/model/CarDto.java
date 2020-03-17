package info.luckydog.springboot.mapstruct.model;

/**
 * CarDTO
 *
 * @author eric
 * @since 2020/1/13
 */
public class CarDto {
    private String make;
    private int seatCount;
    private String type;

    public CarDto() {
    }

    public CarDto(String make, int seatCount, String type) {
        this.make = make;
        this.seatCount = seatCount;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
