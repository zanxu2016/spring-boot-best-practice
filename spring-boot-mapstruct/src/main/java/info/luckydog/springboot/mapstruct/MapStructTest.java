package info.luckydog.springboot.mapstruct;

import info.luckydog.springboot.mapstruct.enums.CarType;
import info.luckydog.springboot.mapstruct.enums.GenderEnum;
import info.luckydog.springboot.mapstruct.model.Car;
import info.luckydog.springboot.mapstruct.model.CarDto;
import info.luckydog.springboot.mapstruct.model.User;
import info.luckydog.springboot.mapstruct.model.UserDto;
import info.luckydog.springboot.mapstruct.model.support.CarMapper;
import info.luckydog.springboot.mapstruct.model.support.UserMapper;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * MapStructApplication
 *
 * @author eric
 * @since 2020/1/13
 */
public class MapStructTest {

    @Test
    public void shouldMapCarToDto() {
        // given
        Car car = new Car("Morris", 5, CarType.SEDAN);

        // when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        // then
        assertThat(carDto, notNullValue());
        assertThat(carDto.getMake(), equalTo("Morris"));
        assertThat(carDto.getSeatCount(), equalTo(5));
        assertThat(carDto.getType(), equalTo("SEDAN"));

        // reverse
        Car carSource = CarMapper.INSTANCE.fromCarDto(carDto);

        // then
        assertThat(carSource, notNullValue());
        assertThat(carSource.getMake(), equalTo("Morris"));
        assertThat(carSource.getNumberOfSeats(), equalTo(5));
        assertThat(carSource.getType(), equalTo(CarType.SEDAN));

    }

    @Test
    public void shouldMapUserToDto() {
        // given
        User user = new User(1L, "Eric", "123456", "17621039789",
                "342222199510104425", 0, 25, new Date(),
                "250476498@qq.com", 2000.555);

        // when
        UserDto userDto = UserMapper.INSTANCE.fromUser(user);

        // then
        assertThat(userDto, notNullValue());
        assertThat(userDto.getUserId(), equalTo(1L));
        assertThat(userDto.getUserName(), equalTo("Eric"));
        assertThat(userDto.getPassword(), nullValue());
        assertThat(userDto.getPhone(), equalTo("17621039789"));
        assertThat(userDto.getIdNo(), equalTo("342222199510104425"));
        assertThat(userDto.getGender(), equalTo(GenderEnum.getGenderName(user.getGender())));
        assertThat(userDto.getAge(), equalTo(25));
        assertThat(userDto.getBirthDate(), equalTo("2020-01-13"));
        assertThat(userDto.getEmail(), equalTo("250476498@qq.com"));
        assertThat(userDto.getSalary(), equalTo(2000.55));
    }

    @Test
    public void test() {
        String test = "string";
        test = Optional.ofNullable(test).orElse("default");
        System.out.println("test: " + test);

        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList = null;

        String str = of(strList).findFirst().orElse("default");

        System.out.println("str: " + str);


        

    }

    public static <T> Stream<T> of(Iterable<T> iterable) {
        return Objects.isNull(iterable) ? Stream.of() : StreamSupport.stream(iterable.spliterator(), false);
    }
}
