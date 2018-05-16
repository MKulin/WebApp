package webApp.data;

import webApp.model.Human;
import webApp.util.WLogger;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
@org.springframework.stereotype.Repository
public class TempRepositoryImpl<T> implements Repository<T> {

    private static List list = new ArrayList<>();
    static {
        list.add(new Human(0, "John"));
    }

    @Override
    public T get(long id) {
        WLogger.getLogger().debug("Repository get...");
        return (T)list.get((int)id);
    }

    @Override
    public void set(T value) {
        list.add(value);
        WLogger.getLogger().debug("Repository add...");
    }

    @Override
    public void update(T value) {
        list.set(list.indexOf(value), value);
        WLogger.getLogger().debug("Repository update...");
    }

    @Override
    public void delete(T value) {
        list.remove(value);
        WLogger.getLogger().debug("Repository delete...");
    }

    public Human getByName(String name){
        return (Human)list.stream()
                .filter(o -> ((Human) o).getUsername().equals(name))
                .findFirst()
                .get();
    }

    public boolean checkIfUserExists(String name){
        return list.stream()
               .anyMatch(o -> ((Human) o).getUsername().equals(name));
    }
}
