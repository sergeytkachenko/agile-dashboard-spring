package board.controller

import board.model.Sprint
import board.model.Task
import board.repository.SprintRepository
import board.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.xml.ws.http.HTTPException

@RestController
@RequestMapping("/task")
class TaskController {

    @Autowired
    TaskRepository taskRepository

    @Autowired
    SprintRepository sprintRepository

    @GetMapping("/all")
    List<Task> all() {
        return taskRepository.findAll()
    }

    @GetMapping("/current-sprint")
    List<Task> current() {
        Sprint sprint = sprintRepository.findByDateStartLessThanEqualAndDateEndGreaterThanEqual(new Date(), new Date())
        if (sprint) {
            return taskRepository.findBySprintId(sprint.id)
        }
    }

    @GetMapping('/add')
    Task add(HttpServletRequest request) {
        String name = request.getParameter('name')
        String description = request.getParameter('description')
        String sprintId = request.getParameter('sprintId')
        Task task = new Task(name: name, description: description, sprintId: sprintId)
        taskRepository.save(task)
        return task
    }

    @PostMapping('/save')
    Task save(HttpServletRequest request) {
        String id = request.getParameter('id')
        String name = request.getParameter('name')
        String description = request.getParameter('description')
        String sprintId = request.getParameter('sprintId')
        Task task = taskRepository.findById(id)
        task.name = name
        task.description = description
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
}
