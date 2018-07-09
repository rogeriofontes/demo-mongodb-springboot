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

import br.com.uaijug.demomongo.model.domain.User;
import br.com.uaijug.demomongo.model.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> list() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> getById(@PathVariable String id) {
		LOG.info("Getting user with ID: {}.", id);
		return userRepository.findById(id);
	}

	@RequestMapping(value = "/settings/{id}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get().getUserSettings();
		} else {
			return "User not found.";
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		userRepository.findById(id);
	}
}