package board.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "workspace")
class Workspace {

    @Id
    String id

    String name
}
