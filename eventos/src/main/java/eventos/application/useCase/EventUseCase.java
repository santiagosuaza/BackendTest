package eventos.application.useCase;

import eventos.application.IEventUsecase;
import eventos.domain.Event;
import eventos.persistence.entity.EventEntity;
import eventos.persistence.repository.IEventRepository;
import jakarta.inject.Singleton;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Singleton
public class EventUseCase implements IEventUsecase {

    private IEventRepository eventRepository;
    private ModelMapper modelMapper;

    public EventUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Mono<Event> findEventById(Object id) {
        return Mono.just(eventRepository.findById(id)).map(event -> modelMapper.map(event, Event.class));
    }

    @Override
    public Mono<Event> saveEvent(Event event) {
        EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
        return Mono.just(eventRepository.save(eventEntity)).map(eventEntity1 -> modelMapper.map(eventEntity1, Event.class));
    }

    @Override
    public Flux<Event> findAllEvents() {
        return Flux.fromIterable(eventRepository.findAll()).map(event -> modelMapper.map(event, Event.class));
    }

    @Override
    public Flux<Event> findbyUser(String id) {
        List<EventEntity> events= eventRepository.findAll();
        return null;
    }
}
