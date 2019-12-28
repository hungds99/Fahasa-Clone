package com.hunter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunter.dto.SearchDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<Object[]> getProductBySearch(SearchDTO searchDTO) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_code, c.category_name, p.product_name, ");
		strBuilder.append("i.image_url, i.image_alt, p.highlight, p.isshowed, ");
		strBuilder.append("p.product_price, pr.promotion_value, p.created_date, p.product_amount, p.product_status ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();
		return results;
	}

	@Override
	public List<Object[]> getProductByCategoryId(int categoryId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.product_name, p.product_price, p.product_finalprice, ");
		strBuilder.append("pr.promotion_value, pr.promotion_type, ");
		strBuilder.append("c.category_name, c.id ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id AND p.category_id = " + categoryId + " ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		return results;
	}

}
