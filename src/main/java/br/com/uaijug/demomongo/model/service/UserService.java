package br.com.uaijug.demomongo.model.service;

import java.util.List;
import java.util.Optional;

import br.com.uaijug.demomongo.model.domain.User;

public interface UserService {

	List<User> getAll();

	Optional<User> getById(String userId);

	User add(User user);

	Object getAllSettings(String userId);

	String getSetting(String userId, String key);
}