package board.controller

import board.model.Sprint
import board.repository.SprintRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sprint")
class SprintController {

    @Autowired
    SprintRepository sprintRepository

    @RequestMapping("/all")
    List<Sprint> all() {
        return sprintRepository.findAll()
    }

    @RequestMapping("/current")
    Sprint current() {
        return sprintRepository.findByDateStartLessThanEqualAndDateEndGreaterThanEqual(new Date(), new Date())
    }
}
