package kdevelop.dao;

import kdevelop.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements Dao<Product> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<Product> getAll() {
        Query request = entityManager.createQuery("Select p from Product p");
        return request.getResultList();
    }

    @Override
    public List<Product> getAllByKeyWord(String keyWord) {
        Query request = entityManager.createQuery("Select p from Product p where p.nameProduct like :x");
        request.setParameter("x", keyWord);
        return request.getResultList();
    }

    @Override
    public Product getOneById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product update(Product entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(long id) {
        Product product = getOneById(id);
        entityManager.remove(product);
    }
}
