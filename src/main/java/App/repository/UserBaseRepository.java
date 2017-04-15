package App.repository;

import App.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserBaseRepository<T extends User>
        extends CrudRepository<T, Long> {
    public T findByEmail(String email);

}
