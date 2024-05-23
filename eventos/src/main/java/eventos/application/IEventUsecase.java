package eventos.application;

import eventos.domain.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEventUsecase {

    Mono<Event> findEventById(Object id);
    Mono<Event> saveEvent(Event event);
    Flux<Event> findAllEvents();
    Flux<Event> findbyUser(String id);
}
