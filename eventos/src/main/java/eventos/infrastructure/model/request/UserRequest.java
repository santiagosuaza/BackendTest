package eventos.infrastructure.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Introspected
@Serdeable
public class UserRequest implements Serializable {
    String id;
    String name;

    public UserRequest() {
    }

    public UserRequest(String id, String name) {
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
