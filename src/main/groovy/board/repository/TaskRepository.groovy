package board.repository

import board.model.Task
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
