package eventos.infrastructure.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.types.ObjectId;

import java.util.List;

@Introspected
@Serdeable
public class EventRequest {
    ObjectId id;
    String name;
    String date;
    String location;
    List<UserRequest> userRequests;

    public EventRequest() {
    }

    public EventRequest(ObjectId id, String name, String date, String location, List<UserRequest> userRequests) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.userRequests = userRequests;
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

    public List<UserRequest> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(List<UserRequest> userRequests) {
        this.userRequests = userRequests;
    }
}