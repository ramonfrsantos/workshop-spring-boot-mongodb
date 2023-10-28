package br.com.ramonsantos.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonsantos.workshopmongo.domain.User;
import br.com.ramonsantos.workshopmongo.dto.UserDTO;
import br.com.ramonsantos.workshopmongo.repository.UserRepository;
import br.com.ramonsantos.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				String.format("O usuário com o id %s não foi encontrado no sistema.", id)));

		return user;
	}

	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public void update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		repository.save(newUser);
	}
	
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
