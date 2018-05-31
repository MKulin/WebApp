package webApp.data;

import java.util.List;

public interface Repository<T> {
    T get(@javax.validation.constraints.NotNull String id);
    T getByName(String name);
    void set(T value);
    void update(T value);
    void delete(T value);
    List<T> list();
}
