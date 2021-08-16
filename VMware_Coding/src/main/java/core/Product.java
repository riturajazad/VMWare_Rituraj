package core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
//@Component
@NoArgsConstructor
public class Product {
    private  Integer taskId;
    private  String name;
    private  String type;

    public Product(int taskId, String name,String type) {

    }
}
