package webApp.data;

import java.util.List;

public interface Repository<T> {
    T get(long id);
    T getByName(String name);
    void set(T value);
    void update(T value);
    void delete(T value);
    List<T> list();
}
