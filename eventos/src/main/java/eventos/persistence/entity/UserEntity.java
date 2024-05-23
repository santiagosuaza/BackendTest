package eventos.persistence.entity;

import io.micronaut.core.annotation.Generated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Serdeable
@MappedEntity
public class UserEntity implements Serializable {
    @Id
    @Generated
    String id;
    String name;


    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
