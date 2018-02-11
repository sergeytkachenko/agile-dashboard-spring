package board.repository

import board.model.Sprint
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "sprints", path = "sprints")
interface SprintRepository extends PagingAndSortingRepository<Sprint, Long> {

}
