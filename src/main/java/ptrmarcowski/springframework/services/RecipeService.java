package ptrmarcowski.springframework.services;

import ptrmarcowski.springframework.commands.RecipeCommand;
import ptrmarcowski.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long l);

	RecipeCommand findCommandById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);

}
