package repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    @Version
    private Integer version;
    @Indexed(unique = true)
    private Integer taskId;
    private String name;

    public ProductEntity(Integer taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }
}
