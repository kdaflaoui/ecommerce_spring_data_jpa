package kdevelop.dao;

import java.util.List;

public interface Dao<T> {
    public T save(T entity);
    public List<T> getAll();
    List<T> getAllByKeyWord(String keyWord);
    T getOneById(long id);
    T update(T entity);
    void delete(long id);
}
