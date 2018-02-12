package board.repository

import board.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface UserRepository extends MongoRepository<User, String> {

	User findByLogin(@Param("login") String login)
	User findByToken(@Param("token") String token)
}
