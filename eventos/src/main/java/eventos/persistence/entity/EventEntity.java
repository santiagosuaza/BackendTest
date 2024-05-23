package eventos.persistence.entity;

import io.micronaut.core.annotation.Generated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Serdeable
@MappedEntity
public class EventEntity implements Serializable {
    @Id
    @Generated
    ObjectId id;
    String name;
    String date;
    String location;
    List<UserEntity> userEntityList;

    public EventEntity() {
    }

    public EventEntity(ObjectId id, List<UserEntity> userEntityList, String name, String date, String location) {
        this.id = id;
        this.userEntityList = userEntityList;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public EventEntity(String name, String date, String location, List<UserEntity> userEntityList) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.userEntityList = userEntityList;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}