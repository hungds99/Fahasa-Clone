package com.hunter.crawler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.hunter.model.Image;
import com.hunter.model.Product;
import com.hunter.repository.CategoryRepository;
import com.hunter.repository.ImageRepository;
import com.hunter.service.ProductService;
import com.hunter.utils.DateUtil;

public class ProductCrawler {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ImageRepository imageRepository;

	public void crawlProduct(WebDriver driver, JavascriptExecutor js) throws InterruptedException {
		try {
			WebElement uls = driver.findElement(By.id("products_grid"));

			List<WebElement> lis = uls.findElements(By.tagName("li"));

			int count = 0;

			for (WebElement li : lis) {
				count++;

				WebElement imageEl = li.findElement(By.className("lazyloaded"));
				String imageSrc = imageEl.getAttribute("data-src");
				String productName = li.findElement(By.className("p-name-list")).getText();
//				Double productPrice = Double.parseDouble(li.findElement(By.className("special-price")).getText());

				// Product Insert
				Product newProduct = new Product();

//				newProduct.setProductCode(product.getProductCode());
				newProduct.setCategory(categoryRepository.findById(16).orElse(null));
				newProduct.setProductName(productName);
				newProduct.setProductPrice((Double) (Math.random() * ((200000 - 20000) + 1)) + 20000);
				newProduct.setProductAmount((int) (Math.random() * ((50 - 1) + 1)) + 1);
				newProduct.setCreatedDate(DateUtil.getCurrentDateTime());
//				newProduct.setDiscount(product.getDiscount());
				newProduct.setProductStatus((int) (Math.random() * ((3 - 1) + 1)) + 1);
				newProduct.setHighlight(true);
				newProduct.setIsshowed(true);
				newProduct.setProductContent("Mô tả sản phẩm");
//				newProduct.setPromotion(product.getPromotion());

				Product productSaved = productService.saveAndUpdate(newProduct);

				// Get image
				URL imageURL = new URL(imageSrc);
				BufferedImage saveImage = ImageIO.read(imageURL);

				String imageName = System.currentTimeMillis() + ".jpg";
				File fileIn = new File("src/main/resources/static/images/" + imageName);

				System.out.println(fileIn.getAbsolutePath());
				ImageIO.write(saveImage, "jpg", fileIn);

				// Save Image
				Image newImage = new Image();
				newImage.setImageUrl(imageName);
				newImage.setImageAlt(imageName);
				newImage.setDisplayOrder(1);
				newImage.setProduct(productSaved);

				imageRepository.save(newImage);

				// Scroll to load more data
				if (100 * count < 1500)
					js.executeScript("window.scrollTo(0, " + 100 * count + ")");
			}

			// Next Page
			driver.findElement(By.xpath("//div[@id='pagination']/ol/li[last()]/a")).click();

			Thread.sleep(2500);

		} catch (InterruptedException r) {
			if (driver.findElement(By.id("NC_IMAGE")) != null) {
				driver.findElement(By.id("NC_IMAGE")).click();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");

		String url = "https://www.fahasa.com/sach-trong-nuoc/van-hoc-trong-nuoc.html";

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Maximize browser window
		driver.manage().window().maximize();

		// Navigate to URL
		driver.get(url);

		for (int i = 0; i < 3; i++) {
			new ProductCrawler().crawlProduct(driver, js);
		}

		// Close driver
		driver.quit();

	}
}
