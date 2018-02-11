package board.repository

import board.model.Group
import org.springframework.data.mongodb.repository.MongoRepository

interface GroupRepository extends MongoRepository<Group, Long> {

}
