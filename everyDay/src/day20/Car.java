package day20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Creator<Car> {

    public String code;

    public BigDecimal price;

    @Override
    public Car create() {
        System.out.println(code + price);
        return null;
    }
}
