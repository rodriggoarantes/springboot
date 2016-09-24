package br.com.in6.springboot.livros.app;

	
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.in6.springboot.livros.entity.Livro;
import br.com.in6.springboot.livros.repository.LivroRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "br.com.in6.springboot.livros.repository" })
@EntityScan(basePackages = { "br.com.in6.springboot.livros.entity" })
@ComponentScan(basePackages = {"br.com.in6.springboot.livros.controller"})
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		log.info("Let's inspect the beans provided by Spring Boot:");
		log.info("-------------------------------");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	log.info(beanName);
        }
        log.info("-------------------------------");
	}
	
	
	@Bean
	public CommandLineRunner demo(LivroRepository repository) {
		return (args) -> {
			// save a couple of Livro
			Long id = 20L;
			repository.save( new Livro(++id, "Titulo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Rodrigo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Rodrigues " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Arantes " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Evangelista " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Rodrigo " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Rodrigues " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Arantes " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Evangelista " + id, "ISBN" + id, "Author", "") );
			repository.save( new Livro(++id, "Titulo Teste " + id, "ISBN" + id, "Author", "") );

			// fetch all Livro
			log.info("Livro found with findAll():");
			log.info("-------------------------------");
			for (Livro l : repository.findAll()) {
				log.info(l.toString());
			}
			log.info("-------------------------------");

			// fetch an individual customer by ID
			Livro l = repository.findOne(1L);
			log.info("Livro found with findOne(1L):");
			log.info("-------------------------------");
			log.info(l.toString());
            log.info("");

			// fetch Livro by last name
			log.info("Livro found with findByLastName('Arantes'):");
			log.info("-------------------------------");
			for (Livro t : repository.findByTitulo("Bauer")) {
				log.info(t.toString());
			}
			log.info("-------------------------------");
		};
	}

}
