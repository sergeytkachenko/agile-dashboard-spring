package board.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sprint")
class Sprint {

    @Id
    String id

    String name

    Date dateStart

    Date dateEnd
}
