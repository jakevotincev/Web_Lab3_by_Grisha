package Model;

import Entities.Point;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class PointDao {

    @PersistenceContext(unitName = "ITMO")
    private EntityManager entityManager;

    @Transactional
    public void savePoint(Point point) {
        if (point.getCorrect() == 1) {
            entityManager.persist(point);
        }
    }

    public List<Point> getPoints() {
        TypedQuery<Point> query
                = entityManager.createQuery("SELECT с FROM Point AS с ORDER BY id DESC", Point.class);
        return query.getResultList();
    }
}
