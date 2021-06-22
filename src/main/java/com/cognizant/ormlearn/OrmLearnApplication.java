package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import com.cognizant.ormlearn.model.Stock;

import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	

	@Autowired
	private StockService stockService;



	private static final Logger logger = LoggerFactory.getLogger(OrmLearnApplication.class);

	
	@Bean
	CommandLineRunner testGetAllStockDetails() {
		return args -> {
			logger.info("START... for getAllStockDetails");
			stockService.getAllStockDetails().forEach(c -> logger.info("{}", c));
			logger.info("END... for getAllStockDetails");
		};
	}

	@Bean
	CommandLineRunner testFindStockUsingCode() {
		return args -> {
			logger.info("START... for findStockUsingCode");
			stockService.findStockUsingCode("GOOGL").forEach(c -> logger.info("{}", c));
			logger.info("END... for findStockUsingCode");
		};
	}

	@Bean
	CommandLineRunner testFindFBStockInSep19() {
		return args -> {
			logger.info("START... for findFBStockInSep19");
			List<Stock> stockInSep19 = stockService.findFBStockInSep19("FB",
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01"),
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-30"));
			stockInSep19.forEach(c -> logger.info("{}", c));
			logger.info("END... for findFBStockInSep19");
		};
	}

	@Bean
	CommandLineRunner testFindGoogleStockGreaterThan1250() {
		return args -> {
			logger.info("START... for findGoogleStockGreaterThan1250");
			stockService.findGoogleStockGreaterThan1250("GOOGL", 1250).forEach(c -> logger.info("{}", c));
			logger.info("END... for findGoogleStockGreaterThan1250");
		};
	}

	@Bean
	CommandLineRunner testFindTop3VolumeStock() {
		return args -> {
			logger.info("START... for findTop3VolumeStock");
			stockService.findTop3VolumeStock().forEach(c -> logger.info("{}", c));
			logger.info("END... for findTop3VolumeStock");
		};
	}

	@Bean
	CommandLineRunner testFindLowest3NetflixStocks() {
		return args -> {
			logger.info("START... for findLowest3NetflixStocks");
			stockService.findLowest3NetflixStocks("NFLX").forEach(c -> logger.info("{}", c));
			logger.info("END... for findLowest3NetflixStocks");
		};
	}
	

}