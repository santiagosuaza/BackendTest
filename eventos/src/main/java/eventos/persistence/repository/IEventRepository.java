package eventos.persistence.repository;

import eventos.persistence.entity.EventEntity;
import eventos.persistence.entity.UserEntity;
import io.micronaut.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<EventEntity, Object> {
    EventEntity findByUserEntityListAndId(UserEntity userEntity, Long id);
}
