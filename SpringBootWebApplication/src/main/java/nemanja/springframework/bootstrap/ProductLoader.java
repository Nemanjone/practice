package nemanja.springframework.bootstrap;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import nemanja.springframework.domain.Product;
import nemanja.springframework.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;
	
	private org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(ProductLoader.class);
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Product shirt = new Product();
		shirt.setDescription("Spring Framework majica");
		shirt.setPrice(new BigDecimal("18.95"));
		shirt.setImageUrl("https://www.b92.net/zdravlje/vesti.php?yyyy=2018&mm=06&nav_id=1399799");
		shirt.setProductId("235268845711068308");
		productRepository.save(shirt);
		
		log.info("Saved Shirt - id: " + shirt.getId());
		
		Product mug = new Product();
		mug.setDescription("Spring Framework mug");
		mug.setImageUrl("https://www.b92.net/biz/vesti/region.php?yyyy=2018&mm=06&dd=03&nav_id=1399940");
		mug.setProductId("168639393495335947");
		mug.setPrice(new BigDecimal("11.95"));
		productRepository.save(mug);
		
		log.info("Saved Mug - id: " + mug.getId());
	}
	
}
