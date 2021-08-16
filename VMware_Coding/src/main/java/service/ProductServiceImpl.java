package service;

import com.rituraj.api.core.Product;
import com.rituraj.api.core.ProductService;
import com.rituraj.productservice.persistence.ProductEntity;
import com.rituraj.productservice.persistence.ProductRepository;
import com.rituraj.util.customExceptions.InvalidInputException;
import com.rituraj.util.customExceptions.NotFoundException;
import com.rituraj.util.exceptions.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger("ProductServiceImpl.class");

    private final ProductMapper mapper;
    private final ProductRepository repository;
    private final ServiceUtil serviceUtil;

    @Autowired
    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository, ServiceUtil serviceUtil) {
        this.mapper = mapper;
        this.repository = repository;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getTask(Integer taskId) {
        if(taskId < 1){
            throw new InvalidInputException("Invalid taskId: " + taskId);
        }
        ProductEntity entity = repository.findBytaskId(taskId)
                .orElseThrow(() -> new NotFoundException("No product found for taskId: {}" + taskId));
        Product response = mapper.entityToApi(entity);
        LOG.info("getProduct: found taskId: {}", response.getProductId());
        return response;
    }

    @Override
    public Product createProduct(Product body) {
        try {
            ProductEntity entity = mapper.apiToEntity(body);
            ProductEntity newEntity = repository.save(entity);
            LOG.info("createTask: entity created for taskId : {}", body.gettaskId());
            return mapper.entityToApi(newEntity);
        }catch(DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, taskId: " + body.gettaskId());
        }
    }

    @Override
    public void deleteProduct(int taskId) {
        LOG.info("deletetask: entity with taskId: {} is deleted", taskId);
        repository.findBytaskId(taskId).ifPresent(repository::delete);
    }

}
