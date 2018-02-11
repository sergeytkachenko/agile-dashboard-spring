package board.repository

import board.model.TaskGroup
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskGroupRepository extends MongoRepository<TaskGroup, Long> {

    List<TaskGroup> findByName(String name)
}
