package board.model


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "task-group")
class TaskGroup {

    @Id
    long id

    String name
}
