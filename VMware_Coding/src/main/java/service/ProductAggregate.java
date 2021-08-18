package service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
public class ProductAggregate {
    private final int taskId;
    private final String name;
    

    
    public ProductAggregate() {
        taskId = 0;
        name = null;
      
    }
}
