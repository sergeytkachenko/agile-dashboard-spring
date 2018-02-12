package board.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
class User {

	@Id
	public String id

	public String login

	public String email

	public String firstName

	public String secondName

	public String lastName

	public String password

	public String salt

	public Boolean isActive

	public Boolean isAdmin

	public String token

	public String workspaceId
}
