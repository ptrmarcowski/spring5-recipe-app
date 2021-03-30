package ptrmarcowski.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import ptrmarcowski.springframework.domain.Category;
import ptrmarcowski.springframework.domain.UnitOfMeasure;
import ptrmarcowski.springframework.repositories.CategoryRepository;
import ptrmarcowski.springframework.repositories.RecipeRepository;
import ptrmarcowski.springframework.repositories.UnitOfMeasureRepository;
import ptrmarcowski.springframework.services.RecipeService;

@Slf4j
@Controller
public class IndexController {

	
	private final RecipeService recipeService;
	
//	private CategoryRepository categoryRepository;
//	private UnitOfMeasureRepository unitOfMeasureRepository;
//	private RecipeRepository recipeRepository;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		log.debug("Getting Index page");
//		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//		
//		System.out.println("Cat Id is:" + categoryOptional.get().getId());
//		System.out.println("Unit Id is:" + unitOfMeasureOptional.get().getId());
		
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
		}
	
}
