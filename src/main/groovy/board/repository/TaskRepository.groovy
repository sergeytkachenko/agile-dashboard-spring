package board.repository

import board.model.Task
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository extends MongoRepository<Task, Long> {

}
