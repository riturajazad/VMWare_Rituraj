package core;

import org.springframework.web.bind.annotation.*;

/**
 * @author RITURAJ
 *
 */
//@Service
public interface ProductService {

    @GetMapping(
            value= "/product/{taskId}",
            produces = "application/json")
    Product getProduct(@PathVariable Integer taskId);

    @PostMapping(
            value = "/result",
            consumes = "application/json",
            produces = "application/json")
    Product createProduct(@RequestBody Product body);
}
