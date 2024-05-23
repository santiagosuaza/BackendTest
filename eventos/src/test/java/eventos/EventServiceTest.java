package eventos;

import eventos.application.useCase.EventUseCase;
import eventos.domain.Event;
import eventos.domain.User;
import eventos.persistence.entity.EventEntity;
import eventos.persistence.entity.UserEntity;
import eventos.persistence.repository.IEventRepository;
import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest(environments = Environment.TEST)
public class EventServiceTest {
    IEventRepository eventRepository;
    EventUseCase eventUseCase;

    @BeforeEach
    public void setup() {
        eventRepository = mock(IEventRepository.class);
        eventUseCase = new EventUseCase(eventRepository);
    }

    @Test
    public void testAddEvent() {
        List<UserEntity> usersEntity = new ArrayList<>();
        usersEntity.add(new UserEntity("test"));
        EventEntity eventEntity = new EventEntity("test", "test", "test", usersEntity);

        List<User> users = new ArrayList<>();
        users.add(new User("test", "test"));
        Event event = new Event("test", "test", "test", users);

        when(eventRepository.save(any())).thenReturn(eventEntity);
        StepVerifier.create(eventUseCase.saveEvent(event))
                .consumeNextWith(event1 -> {
                    assertEquals("test", event1.getName());
                });

    }
    @Test
    public void testFindAllEvent() {
        List<UserEntity> usersEntity = new ArrayList<>();
        usersEntity.add(new UserEntity("test"));
        EventEntity eventEntity = new EventEntity("test", "test", "test", usersEntity);
        List<EventEntity> events = new ArrayList<>();
        events.add(eventEntity);

        when(eventRepository.findAll()).thenReturn(events);
        StepVerifier.create(eventUseCase.findAllEvents())
                .consumeNextWith(event1 -> {
                    assertEquals("test", event1.getName());
                });

    }

}
