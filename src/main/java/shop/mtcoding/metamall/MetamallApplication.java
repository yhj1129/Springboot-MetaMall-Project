package shop.mtcoding.metamall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import shop.mtcoding.metamall.model.log.err.ErrorLogRepository;
import shop.mtcoding.metamall.model.log.login.LoginLogRepository;
import shop.mtcoding.metamall.model.orderproduct.OrderProduct;
import shop.mtcoding.metamall.model.orderproduct.OrderProductRepository;
import shop.mtcoding.metamall.model.ordersheet.OrderSheet;
import shop.mtcoding.metamall.model.ordersheet.OrderSheetRepository;
import shop.mtcoding.metamall.model.product.Product;
import shop.mtcoding.metamall.model.product.ProductRepository;
import shop.mtcoding.metamall.model.user.Role;
import shop.mtcoding.metamall.model.user.User;
import shop.mtcoding.metamall.model.user.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class MetamallApplication {

	@Bean
	CommandLineRunner initData(UserRepository userRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository, OrderSheetRepository orderSheetRepository, ErrorLogRepository errorLogRepository, LoginLogRepository loginLogRepository){
		return (args)->{
			// 여기에서 save 하면 됨.
			// bulk Collector는 saveAll 하면 됨.
			User seller = User.builder().username("seller").password("1234").email("seller@nate.com").role(Role.SELLER).build();
			userRepository.save(seller);

			User ssar = User.builder().username("ssar").password("1234").email("ssar@nate.com").role(Role.USER).build();
			userRepository.save(ssar);
			OrderSheet orderSheet = OrderSheet.builder().user(ssar).totalPrice(0).build();
			orderSheetRepository.save(orderSheet); // 한 고객 당 주문 시트 생성

			Product book = Product.builder().productname("book1").price(10000).qty(100).build();
			productRepository.save(book);

			Product book2 = Product.builder().productname("book2").price(15000).qty(100).build();
			productRepository.save(book2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MetamallApplication.class, args);
	}

}
