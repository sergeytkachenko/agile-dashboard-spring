package board.repository

import board.model.TaskGroup
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "task-groups", path = "task-groups")
interface TaskGroupRepository extends PagingAndSortingRepository<TaskGroup, Long> {

    List<TaskGroup> findByName(@Param("name") String name)
}
