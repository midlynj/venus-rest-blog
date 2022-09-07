package stacks.venusrestblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stacks.venusrestblog.data.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    @GetMapping("/")
    public List<Post> fetchPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L,"Post 1","This is my first post"));
        posts.add(new Post(2L,"Post 2", "This is my second post"));
        return posts;
    }

    public Post fetchPostsById(long id) {
        switch ((int) id) {
            case 1:
                return new Post(1L,"Post 1","This is my first post");
            case 2:
                new Post(2L,"Post 2", "This is my second post");
            default:
                return "Not found";
        }

    }
}
