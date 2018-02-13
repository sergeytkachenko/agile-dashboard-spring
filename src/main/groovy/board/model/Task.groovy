package board.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "task")
class Task {

    @Id
    String id

    String name
    String description

    long index

    String[] tags

    String sprintId
    String groupId
}
