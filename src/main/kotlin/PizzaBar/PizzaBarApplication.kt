package PizzaBar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@ComponentScan(value =["PizzaBar"])
@EntityScan(basePackages = ["PizzaBar.repository"])
@EnableJpaRepositories(basePackages = ["PizzaBar.repository"])
@SpringBootApplication
class PizzaBarApplication{


      companion object {

		  @JvmStatic
		  fun main(args: Array<String>) {
			  runApplication<PizzaBarApplication>(*args)
		  }

	  }
}