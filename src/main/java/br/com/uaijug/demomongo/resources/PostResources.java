package br.com.uaijug.demomongo.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.uaijug.demomongo.model.domain.Post;
import br.com.uaijug.demomongo.model.repository.PostRepository;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Post addNewPosts(@RequestBody Post post) {
		LOG.info("Saving post.");
		return postRepository.save(post);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Post> list() {
		LOG.info("Getting all posts.");
		return postRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Post> getById(@PathVariable String id) {
		LOG.info("Getting post with ID: {}.", id);
		return postRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Post post) {
		postRepository.save(post);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		postRepository.findById(id);
	}
}