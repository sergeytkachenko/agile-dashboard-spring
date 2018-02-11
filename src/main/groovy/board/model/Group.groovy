package board.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "group")
class Group {

    @Id
    String id

    String name
}
