package pe.edu.i202030258.cl1_jpa_data_medina_diana;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202030258.cl1_jpa_data_medina_diana.Entity.country;
import pe.edu.i202030258.cl1_jpa_data_medina_diana.repository.CountryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataMedinaDianaApplication implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMedinaDianaApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {


		// Primera consulta: Uso de ifPresentOrElse()
		System.out.println("----------------------------------------------------------");
		System.out.println("Consulta 1: Mostrar lenguajes de 'ARG' o 'PER'");
		System.out.println("----------------------------------------------------------");

		//r Mostrar lenguajes de Argentina (ARG) o Peú (PER)
		Optional<country> argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				(country) -> {
					System.out.println("Lenguajes hablados en Argentina (ARG):");
					// Aquí mostramos los detalles directamente desde la entidad Country
					// Suponiendo que los lenguajes estén almacenados como un atributo o simplemente queremos mostrar el nombre del país
					System.out.println("Nombre del país: " + country.getName());
					// Si los lenguajes están en un atributo de la entidad, puedes acceder a ellos aquí
				},
				() -> {
					System.out.println("No se encontraron lenguajes en Argentina. Mostrando lenguajes de Perú (PER):");
					Optional<country> peru = countryRepository.findById("PER");
					peru.ifPresent((country) -> {
						System.out.println("Nombre del país: " + country.getName());
						// Similar, si los lenguajes están en un atributo, lo mostramos aquí
					});
				}
		);

		// Segunda consulta: Uso de deleteAllById()
		System.out.println("----------------------------------------------------------");
		System.out.println("Consulta 2: Eliminar países 'COL' y 'ARG'");
		System.out.println("----------------------------------------------------------");

		// Eliminar países 'COL' y 'ARG'
		List<String> countryIds = List.of("COL", "ARG");
		countryRepository.deleteAllById(countryIds);
		System.out.println("Países eliminados: COL y ARG.");

		// Validar nuevamente la primera consulta después de la eliminación
		System.out.println("----------------------------------------------------------");
		System.out.println("Consulta 1 (post-eliminación): Mostrar lenguajes de 'ARG' o 'PER'");
		System.out.println("----------------------------------------------------------");

		// Validar nuevamente la consulta después de la eliminación de 'COL' y 'ARG'
		argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				(country) -> {
					System.out.println("Lenguajes hablados en Argentina (ARG):");
					// Mostramos la información del país después de la eliminación
					System.out.println("Nombre del país: " + country.getName());
				},
				() -> {
					System.out.println("No se encontraron lenguajes en Argentina. Mostrando lenguajes de Perú (PER):");
					Optional<country> peru = countryRepository.findById("PER");
					peru.ifPresent((country) -> {
						System.out.println("Nombre del país: " + country.getName());
					});
				}
		);
	}
}
