package eventos.infrastructure.model.dto;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Serdeable
@MappedEntity
public class UserDto  implements Serializable {
    String id;
    String name;

    public UserDto() {
    }

    public UserDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
