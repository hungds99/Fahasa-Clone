package com.hunter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public String findCategoryBreadcrumbByParentId(int parentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Object categoryBreadcrumb = entityManager
									.createNativeQuery("SELECT c.category_breadcrumb FROM category c WHERE c.id = :parentId")
									.setParameter("parentId", parentId)
									.getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		return categoryBreadcrumb.toString();
	}

}
