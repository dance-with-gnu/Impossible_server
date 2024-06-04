package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.entity.Post;
import dance.withgnu.demo.user.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/community")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }
}
