package com.hunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hunter.file.storage.StorageProperties;

/*
 * Khai code đầu xuân 2020
 * Chúc mừng năm mới !!!
 * Mục tiêu : Hoàn thành project này trước tháng 3, Thực tập, TOEIC 400+  
 */

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableTransactionManagement
public class PetProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetProjectApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(StorageService storageService) {
//		return (args) -> {
//			storageService.deleteAll();
//			storageService.init();
//		};
//	}

}
