package za.co.bakgoko.crud.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.bakgoko.crud.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
}