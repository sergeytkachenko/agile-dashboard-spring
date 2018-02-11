package board.controller

import board.model.Group
import board.repository.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/group")
class GroupController {

    @Autowired
    GroupRepository groupRepository

    @RequestMapping("/all")
    List<Group> all() {
        return groupRepository.findAll()
    }
}
