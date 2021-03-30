package ptrmarcowski.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import ptrmarcowski.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
