import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;


	public List<Employee> findAll() {
		return repository.findAll();
	}

	public Employee findById(long id) {
		Optional<Employee> data = repository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	public Employee create(Employee data) {
		return repository.save(candidato);
	}

	public Employee update(Employee data) {

	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}


}

