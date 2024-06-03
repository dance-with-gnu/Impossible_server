package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.Post;
import dance.withgnu.demo.user.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
