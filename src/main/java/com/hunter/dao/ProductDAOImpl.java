package com.hunter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hunter.dto.SearchDTO;

@Repository
@Transactional
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
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id AND i.display_order = 1 ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductByCategoryId(int categoryId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.category_id = " + categoryId);
		
		// Những sản phẩm sắp phát hành
//		String a = "";
//		if(a.equals(ConstantUtil.ProductStatus.SAPMOBAN.getValue())) {
//			strBuilder.append(" AND p.product_status = " + 1);
//		} else {
//			strBuilder.append(" AND p.product_status != " + 1);
//		}
		
		// Những sản phẩm nổi bật
//		if(a == "1") {
//			strBuilder.append(" AND p.highlight = " + 1);
//		}
		
		// Sắp xếp theo khuyến mãi		
		strBuilder.append(" ORDER BY pr.promotion_value DESC");
		
		strBuilder.append(" LIMIT 24");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductByProductId(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.id = " + productId + " ");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductByOrder(int categoryId, int productStatus, boolean highlight, boolean promotion) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.category_id = " + categoryId);

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductByCategoryIdSort(int categoryId, String sortBy) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.category_id = " + categoryId);
		
		// Những sản phẩm sắp phát hành
		if(sortBy.equalsIgnoreCase("coming_soon")) {
			strBuilder.append(" AND p.product_status = " + 3);
		} else {
			strBuilder.append(" AND p.product_status != " + 3);
		}
		
		// Những sản phẩm nổi bật
		if(sortBy.equalsIgnoreCase("highlight")) {
			strBuilder.append(" AND p.highlight = " + 1);
		}
		
		strBuilder.append(" AND pr.promotion_value > 15 ");
		
		// Sắp xếp theo khuyến mãi		
		strBuilder.append("ORDER BY pr.promotion_value DESC ");
		
		// Giới hạn hiển thị
		strBuilder.append("LIMIT 12 ");

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductByOrder(int category_id, String order_by, int page, int limit) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.category_id = " + category_id);
		
		// Phân trang
		strBuilder.append(" LIMIT " + 12 + " OFFSET " + (page-1)*12);
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

	@Override
	public List<Object[]> getProductBySearch(String terms, String order_by, int page, int limit) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("SELECT p.id, p.product_name, p.product_price, ");
		strBuilder.append("pr.promotion_value, ");
		strBuilder.append("i.image_url, i.image_alt ");
		strBuilder.append("FROM product p ");
		strBuilder.append("LEFT JOIN category c ON p.category_id = c.id ");
		strBuilder.append("LEFT JOIN image i ON i.product_id = p.id ");
		strBuilder.append("LEFT JOIN promotion pr ON p.promotion_id = pr.id ");
		strBuilder.append("WHERE p.product_name LIKE '%" + terms + "%'");
		
		// Phân trang
		strBuilder.append(" LIMIT " + 12 + " OFFSET " + (page-1)*12);
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createNativeQuery(strBuilder.toString()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return results;
	}

}
