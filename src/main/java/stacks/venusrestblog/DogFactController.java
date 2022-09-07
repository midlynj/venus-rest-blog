package stacks.venusrestblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DogFactController {

    @GetMapping("/dogo")
    @ResponseBody
    public String fetchDogFacts() {
        return "Corgis are cute puppies";
    }

    @GetMapping("/dogo/{id}")
    @ResponseBody
    public String fetchSingleDogFact(long id)  {
        switch ((int) id) {
            case 1:
                return "Dogs don't feel guilty";
            case 2:
                return "Sense of smell is powerful";
            default:
                return "Unknown fact id!";
        }
    }
}
