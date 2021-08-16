package service;

import org.springframework.web.bind.annotation.*;

/**
 * @author RITURAJ
 * @apiNote API to expose tasks info
 */
public interface ProductCompositeService {

        @GetMapping(
                value = "/product-composite/{taskid}",
                produces = "application/json")
        ProductAggregate getCompositeProduct(@PathVariable int taskId);

        @PostMapping(
                value= "/product-composite",
                consumes = "application/json")
        void createCompositetask(@RequestBody ProductAggregate body);

    }

}
