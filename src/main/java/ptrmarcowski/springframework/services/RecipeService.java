package ptrmarcowski.springframework.services;

import java.util.Set;

import ptrmarcowski.springframework.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
}
