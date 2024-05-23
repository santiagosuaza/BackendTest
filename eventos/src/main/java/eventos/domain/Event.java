package eventos.domain;

import eventos.persistence.entity.UserEntity;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Serdeable
@MappedEntity
public class Event implements Serializable {
    ObjectId id;
    String name;
    String date;
    String location;
    List<User> userEntityList;

    public Event() {
    }

    public Event(String name, String date, String location, List<User> users) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.userEntityList = users;
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

    public List<User> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<User> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
