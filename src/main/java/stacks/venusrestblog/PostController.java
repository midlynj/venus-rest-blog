package stacks.venusrestblog;

import org.springframework.web.bind.annotation.*;
import stacks.venusrestblog.data.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {
    private List<Post> posts = new ArrayList<>();
    @GetMapping("")
    public List<Post> fetchPosts() {

//        posts.add(new Post(1L,"Post 1","This is my first post"));
//        posts.add(new Post(2L,"Post 2", "This is my second post"));
        return posts;
    }

    @GetMapping("/{id}")
    public Post fetchPostsById(@PathVariable long id) {
        switch ((int) id) {
            case 1:
                return new Post(1L,"Post 1","This is my first post");
            case 2:
                return new Post(2L,"Post 2", "This is my second post");
            default:
               throw new RuntimeException("Error");
        }

    }

    @PostMapping("/newPost")
    public void createPost(@RequestBody Post myStuff) {

      posts.add(myStuff);

    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable long id, @RequestBody Post updatePost) {
        for (Post post : posts) {
            if (post.getId() == id) {
             post.setContent(updatePost.getContent());
             post.setTitle(updatePost.getTitle());

            }
        }
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable long id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                posts.remove(post);
                return;
            }
        }

    }

}
