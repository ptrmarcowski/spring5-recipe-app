package ptrmarcowski.springframework.services;

import java.util.Set;

import ptrmarcowski.springframework.commands.RecipeCommand;
import ptrmarcowski.springframework.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

	//void deleteById(Long idToDelete);

}
