package board.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    String name
    String description
}
