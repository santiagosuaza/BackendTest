package eventos.infrastructure.model.dto;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Serdeable
@MappedEntity
public class EventDto implements Serializable {
    ObjectId id;
    String name;
    String date;
    String location;
    List<UserDto> userEntityList;

    public EventDto() {
    }

    public EventDto(ObjectId id, String name, String date, String location, List<UserDto> userEntityList) {
        this.id = id;
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

    public List<UserDto> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserDto> userEntityList) {
        this.userEntityList = userEntityList;
    }
}

