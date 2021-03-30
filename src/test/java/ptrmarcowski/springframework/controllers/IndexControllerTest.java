package ptrmarcowski.springframework.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import ptrmarcowski.springframework.domain.Recipe;
import ptrmarcowski.springframework.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;


	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		controller = new IndexController(recipeService);
	}

	@Test
	public void testMocMVC() throws  Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));

	}

	@Test
	public void testGetIndexPage() throws Exception {
		
		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = controller.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);
	
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		verify(recipeService, times(1)).getRecipes();
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
		
	}

}
