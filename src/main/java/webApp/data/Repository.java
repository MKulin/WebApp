package webApp.data;

public interface Repository<T> {
    T get(long id);
    void set(T value);
    void update(T value);
    void delete(T value);
}
