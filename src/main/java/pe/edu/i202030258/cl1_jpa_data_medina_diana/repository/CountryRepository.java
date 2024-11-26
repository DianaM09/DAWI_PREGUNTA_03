package pe.edu.i202030258.cl1_jpa_data_medina_diana.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202030258.cl1_jpa_data_medina_diana.Entity.country;

import java.util.List;

public interface CountryRepository extends CrudRepository<country, String> {



}
