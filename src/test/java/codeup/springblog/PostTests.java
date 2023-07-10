package codeup.springblog;

import codeup.springblog.repositories.PostRepository;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTests {

    @Autowired
    private PostRepository postDao;

    @Test
    public void deletePost() {

    }


}
