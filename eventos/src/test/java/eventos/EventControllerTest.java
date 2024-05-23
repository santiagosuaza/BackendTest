package eventos;

import eventos.application.useCase.EventUseCase;
import eventos.domain.Event;
import eventos.domain.User;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventControllerTest {
    @Inject
    @Client("/iasapi")
    HttpClient client;

    @Inject
    EventUseCase eventUseCase;

    @BeforeEach
    void setUp() {
        eventUseCase = mock(EventUseCase.class);
    }

    @Test
    void getAllEvents() {
        List<User> users = new ArrayList<>();
        users.add(new User("test", "test"));

        List<Event> events = new ArrayList<>();
        events.add(new Event("test", "test", "test", users));

        when(eventUseCase.findAllEvents()).thenReturn(Flux.fromIterable(events));

        StepVerifier.create(client.retrieve(HttpRequest.GET("/event"), Argument.listOf(Event.class)))
                .consumeNextWith(event1 -> {
                    assertEquals("test", event1.get(0).getName());
                });
    }

    @Test
    void getEvents() {
        List<User> users = new ArrayList<>();
        users.add(new User("test", "test"));
        Event events = new Event("test", "test", "test", users);

        ObjectId objectId = new ObjectId();

        when(eventUseCase.findEventById(objectId)).thenReturn(Mono.just(events));

        StepVerifier.create(client.retrieve(HttpRequest.GET("/event/test"), Event.class))
                .consumeNextWith(event1 -> {
                    assertEquals("test", event1.getName());
                });
    }

}

