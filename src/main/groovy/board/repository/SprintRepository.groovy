package board.repository

import board.model.Sprint
import org.springframework.data.mongodb.repository.MongoRepository

interface SprintRepository extends MongoRepository<Sprint, Long> {

    Sprint findByDateStartLessThanEqualAndDateEndGreaterThanEqual(Date dateStart, Date dateEnd)
}
