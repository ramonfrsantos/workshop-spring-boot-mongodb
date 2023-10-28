package br.com.ramonsantos.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonsantos.workshopmongo.domain.Post;
import br.com.ramonsantos.workshopmongo.repository.PostRepository;
import br.com.ramonsantos.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				String.format("O post com o id %s não foi encontrado no sistema.", id)));

		return post;
	}

	public Post insert(Post post) {
		return repository.insert(post);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

}
