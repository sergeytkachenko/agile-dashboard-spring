package board.repository

import board.model.Task
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository extends MongoRepository<Task, Long> {

    List<Task> findBySprintId(String sprintId)
    Task findById(String id)
}
