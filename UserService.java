import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	private UserRepository repository;


	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(long id) {
		Optional<User> data = repository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	public User create(User data) {
		return repository.save(data);
	}

	public User update(User data) {

	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}


}

