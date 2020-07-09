package kdevelop;

import kdevelop.dao.ProductRepository;
import kdevelop.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceJpaHibernateApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(EcommerceJpaHibernateApplication.class, args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        productRepository.save(new Product("Ordinateur", 500.00, 10));
        productRepository.save(new Product("Imprimmante X50", 50.00, 10));
        productRepository.save(new Product("Samsung S10", 600.00, 10));
        productRepository.save(new Product("Dell 5740", 1500.00, 10));

        List<Product> productList = productRepository.findAll();
        productList.stream().forEach(product -> {
            System.out.println(product);
        });
        System.out.println("-----------------------------------------------");
        List<Product> productListByName = productRepository.getProductByKeyWord("Dell 5740");
        productListByName.stream().forEach(product -> {
            System.out.println(product);
        });
    }

}
