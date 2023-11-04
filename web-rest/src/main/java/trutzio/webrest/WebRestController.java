package trutzio.webrest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    /**
     * HTTP Request -> root() -> HTTP Response
     * 
     */
    @GetMapping("/")
    public String root() {
        return "Hello World!";
    }

    /**
     * HTTP POST Request -> createUser() -> HTTP Response
     * 
     */
    @PostMapping("/create-user/{name}")
    public User createUser(@PathVariable Optional<String> name) {
        return name
                .map(n -> new User(UUID.randomUUID(), n))
                .orElse(new User(UUID.randomUUID(), "NO NAME"));
    }

}
