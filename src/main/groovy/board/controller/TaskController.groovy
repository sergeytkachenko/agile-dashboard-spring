package board.controller

import board.auth.TokenService
import board.model.Sprint
import board.model.Task
import board.model.User
import board.repository.SprintRepository
import board.repository.TaskRepository
import board.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/task")
class TaskController {

    @Autowired
    TokenService tokenService

    @Autowired
    UserRepository userRepository

    @Autowired
    TaskRepository taskRepository

    @Autowired
    SprintRepository sprintRepository

    @GetMapping("/current-sprint")
    List<Task> current(@RequestHeader("token") String token) {
        String userId = tokenService.getUserId(token)
        User user = userRepository.findOne(userId)
        Sprint sprint = sprintRepository.findByDateStartLessThanEqualAndDateEndGreaterThanEqualAndWorkspaceId(new Date(),
                new Date(), user.workspaceId)
        if (sprint) {
            return taskRepository.findBySprintId(sprint.id)
        }
    }

    @PostMapping('/add')
    Task add(HttpServletRequest request) {
        String name = request.getParameter('name')
        String description = request.getParameter('description')
        String[] tags = request.getParameterMap().get('tags[]')
        String sprintId = request.getParameter('sprintId')
        Task task = new Task(name: name, description: description, tags: tags, sprintId: sprintId)
        taskRepository.save(task)
        return task
    }

    @PutMapping('/save')
    Task save(HttpServletRequest request) {
        String id = request.getParameter('id')
        String name = request.getParameter('name')
        String description = request.getParameter('description')
        String[] tags = request.getParameterMap().get('tags[]')
        String sprintId = request.getParameter('sprintId')
        Task task = taskRepository.findById(id)
        task.name = name
        task.description = description
        task.tags = tags
        task.sprintId = sprintId
        taskRepository.save(task)
        return task
    }

    @PatchMapping('/save')
    void patch(@RequestParam long index, @RequestParam String id, @RequestParam String groupId) {
        Task task = taskRepository.findById(id)
        if (task) {
            task.index = index
            task.groupId = groupId
            taskRepository.save(task)
        }
    }

    @DeleteMapping('/remove/{id}')
    Task remove(@PathVariable String id) {
        Task task = taskRepository.findById(id)
        taskRepository.delete(task)
    }
}
