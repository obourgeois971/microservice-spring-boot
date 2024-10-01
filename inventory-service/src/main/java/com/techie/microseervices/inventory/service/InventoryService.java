package com.techie.microseervices.inventory.service;

import org.springframework.stereotype.Service;

import com.techie.microseervices.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	public boolean isInStock(String skuCode, Integer quantity) {
		// Find an inventory for a given skuCode where quantity >= 0
		log.info(" Start -- Received request to check stock for skuCode {}, with quantity {}", skuCode, quantity);
		boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
		log.info(" End -- Product with skuCode {}, and quantity {}, is in stock - {}", skuCode, quantity, isInStock);
        return isInStock;
	}
}
