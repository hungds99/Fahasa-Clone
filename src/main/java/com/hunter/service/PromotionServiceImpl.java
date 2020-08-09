package com.hunter.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.Promotion;
import com.hunter.repository.PromotionRepository;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	PromotionRepository promotionRepository;

	@Override
	@Transactional
	public List<Promotion> findAllPromotion() {
		List<Promotion> promotions = promotionRepository.findAllPromotion();
		return promotions;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Promotion promotion) {

		Promotion promotionExisted = this.findById(promotion.getId());

		// Edit Promotion
		if (promotionExisted != null) {

			promotionExisted.setPromotionName(promotion.getPromotionName());
			promotionExisted.setPromotionValue(promotion.getPromotionValue());
			promotionExisted.setPromotionType(promotion.getPromotionType());
			promotionExisted.setBeginDate(promotion.getBeginDate());
			promotionExisted.setEndDate(promotion.getEndDate());
			promotionExisted.setCreatedDate(new Date(0));
			promotionExisted.setPromotionRule(promotion.getPromotionRule());
			promotionExisted.setUsedValid(promotion.isUsedValid());

			promotionRepository.save(promotionExisted);
			return;
		}

		// Save New
		promotionRepository.save(promotion);
	}

	@Override
	public Promotion findById(int id) {
		return promotionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Promotion> findByPromotionName(String promotionName) {
		return promotionRepository.findByPromotionName(promotionName);
	}

}
