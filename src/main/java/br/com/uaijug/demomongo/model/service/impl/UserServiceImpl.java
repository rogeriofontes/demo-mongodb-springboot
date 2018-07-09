package br.com.uaijug.demomongo.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.demomongo.model.domain.User;
import br.com.uaijug.demomongo.model.repository.UserRepository;
import br.com.uaijug.demomongo.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public User add(User user) {
		userRepository.save(user);
		// Now, user object will contain the ID as well
		return user;
	}

	@Override
	public Object getAllSettings(String userId) {
		Optional<User> user = userRepository.findById(userId);
		return user != null ? user.get().getUserSettings() : "User not found.";
	}

	@Override
	public String getSetting(String userId, String key) {
		Optional<User> user = userRepository.findById(userId);
		return user != null ? user.get().getUserSettings().get(key) : "Not found.";
	}
}
