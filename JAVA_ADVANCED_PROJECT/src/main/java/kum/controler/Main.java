package kum.controler;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import kum.entity.Cafe;
import kum.entity.OpenClose;
import kum.entity.Type;
import kum.model.view.CafeView;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		new Aplication().run();
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		List<Cafe> cafes = em.createQuery("FROM Cafe", Cafe.class).getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe.getName());
//		}
		
//		List<Cafe> cafes = em.createQuery("FROM Cafe c WHERE c.id IN (:ids)", Cafe.class)
//				.setParameter("ids", Arrays.asList(8,9,10,11))
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			em.remove(cafe);
//		}
//		List<Cafe> cafes = em.createQuery("FROM Cafe c WHERE c.fullDescription LIKE :fullDescription", Cafe.class)
//				.setParameter("fullDescription", "s%")
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			cafe.setPhone("+5555555555");
//		}
//		Cafe cafe = em.find(Cafe.class, 1);
//		em.remove(cafe);
//		
//		Long count = em.createQuery("SELECT count(c.id) FROM Cafe c", Long.class).getSingleResult();
//		System.out.println(count);
		
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c JOIN FETCH c.open o WHERE o.time =?1 ", Cafe.class)
//				.setParameter(1, LocalTime.of(10, 0))
//				.getResultList();
//		List<CafeView> views = em.createQuery(" SELECT new kum.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time) FROM Cafe c JOIN c.open open JOIN c.close close WHERE open.time=?1 ", CafeView.class)
//				.setParameter(1, LocalTime.of(10, 0))
//				.getResultList();
//		new Menu().run();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeView> cq = cb.createQuery(CafeView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		Join<Cafe, OpenClose> closeJoin = root.join("close");
		Join<Cafe, OpenClose> openJoin = root.join("open");
		cq.multiselect(root.get("id"),
				root.get("rate"),
				root.get("name"),
				root.get("photoUrl"),
				root.get("version"),
				root.get("address"),
				root.get("fullDescription"),
				root.get("type"),
				root.get("phone"),
				root.get("email"),
				openJoin.get("time"),
				closeJoin.get("time"));
		Predicate ratePredicate =cb.ge(root.get("rate"), new BigDecimal("4"));
		Predicate typePredicate =  cb.equal(root.get("type"), Type.CAFE);
		Predicate phonePredicate =  cb.like(root.get("phone"), "+380%"); 
		Predicate closePredicate = closeJoin.get("time").in(Arrays.asList(LocalTime.of(10,0),LocalTime.of(9,0),LocalTime.of(11,0)));
//		root.fetch("close");
		Predicate and = cb.and(ratePredicate, typePredicate, phonePredicate, closePredicate);
		cq.where(and);
		List<CafeView> cafes  = em.createQuery(cq).getResultList();
		System.out.println(cafes);
		
		em.getTransaction().commit();
 		em.close();
//		cafes.forEach(c->System.out.println(c.getOpen().getTime()));
//		views.forEach(System.out::println);
		
		
				
		factory.close();

	}

}
