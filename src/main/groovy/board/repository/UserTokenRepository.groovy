package board.repository

import board.model.UserToken
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface UserTokenRepository extends MongoRepository<UserToken, String> {

	UserToken findByToken(@Param("token") String token)
}
