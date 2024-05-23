package eventos.infrastructure.controller;

import eventos.application.IEventUsecase;
import eventos.domain.Event;
import eventos.infrastructure.model.dto.EventDto;
import eventos.infrastructure.model.request.EventRequest;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/event")
public class EventController {
    private final IEventUsecase eventUsecase;
    ModelMapper modelMapper;

    public EventController(IEventUsecase eventUsecase) {
        this.eventUsecase = eventUsecase;
        modelMapper = new ModelMapper();
    }

    @Get()
    public Flux<EventDto> getEvents() {
        return eventUsecase.findAllEvents().map(event -> modelMapper.map(event, EventDto.class));
    }

    @Get("/{id}")
    public Mono<EventDto> getEventById(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        return eventUsecase.findEventById(objectId).map(event -> modelMapper.map(event, EventDto.class));
    }

    @Get("user/{id}")
    public Flux<EventDto> getEventByUser(@PathVariable String id) {
        return eventUsecase.findbyUser(id).map(event -> modelMapper.map(event, EventDto.class));
    }

    @Post("/{id}/register")
    public Mono<EventDto> createEvent(@PathVariable String id, @Body EventRequest eventRequest) {
        Event event = modelMapper.map(eventRequest, Event.class);
        event.setId(new ObjectId(id));
        return eventUsecase.saveEvent(event).map(event1 -> modelMapper.map(event1, EventDto.class));
    }

}

