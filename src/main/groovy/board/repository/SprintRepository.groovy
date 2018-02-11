package board.repository

import board.model.Sprint
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "sprint", path = "sprint")
interface SprintRepository extends PagingAndSortingRepository<Sprint, Long> {

}
