package board.controller

import board.auth.TokenService
import board.model.Sprint
import board.model.User
import board.repository.SprintRepository
import board.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sprint")
class SprintController {

    @Autowired
    TokenService tokenService

    @Autowired
    UserRepository userRepository

    @Autowired
    SprintRepository sprintRepository

    @RequestMapping("/all")
    List<Sprint> all(@RequestHeader("token") String token) {
        String userId = tokenService.getUserId(token)
        User user = userRepository.findOne(userId)
        return sprintRepository.findByWorkspaceId(user.workspaceId)
    }

    @RequestMapping("/current")
    Sprint current(@RequestHeader("token") String token) {
        String userId = tokenService.getUserId(token)
        User user = userRepository.findOne(userId)
        return sprintRepository.findByDateStartLessThanEqualAndDateEndGreaterThanEqualAndWorkspaceId(new Date(),
                new Date(), user.workspaceId)
    }
}
