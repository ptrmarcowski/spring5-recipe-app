package ptrmarcowski.springframework.services;

import ptrmarcowski.springframework.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndId(Long recipeId, Long id);
}
