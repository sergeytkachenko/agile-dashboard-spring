package board.repository

import board.model.Task
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "sprint", path = "sprint")
interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
