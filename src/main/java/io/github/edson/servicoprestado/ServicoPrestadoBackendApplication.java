package io.github.edson.servicoprestado;

import io.github.edson.servicoprestado.infraestrutura.enums.Perfil;
import io.github.edson.servicoprestado.infraestrutura.service.Facade;
import io.github.edson.servicoprestado.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class ServicoPrestadoBackendApplication implements CommandLineRunner {

	private final Facade facade;

	@Autowired
	public ServicoPrestadoBackendApplication(Facade facade) {
		this.facade = facade;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServicoPrestadoBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		facade.usuarioSave(
			new Usuario("admin", "1234", new HashSet<>(Arrays.asList(Perfil.USER)))
		);
	}
}