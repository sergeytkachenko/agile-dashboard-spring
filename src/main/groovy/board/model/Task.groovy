package board.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "task")
class Task {

    @Id
    long id

    String name
    String description
}
