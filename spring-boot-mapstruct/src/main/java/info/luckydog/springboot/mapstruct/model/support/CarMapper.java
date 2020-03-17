package info.luckydog.springboot.mapstruct.model.support;

import info.luckydog.springboot.mapstruct.model.Car;
import info.luckydog.springboot.mapstruct.model.CarDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * CarMapper
 *
 * @author eric
 * @since 2020/1/13
 */
@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mappings({
            @Mapping(source = "numberOfSeats", target = "seatCount")
    })
    CarDto carToCarDto(Car car);

    @InheritInverseConfiguration
    Car fromCarDto(CarDto carDto);
}
