package guru.springframework.controllers;

import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {
    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        // This is to initialize the mocks
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);

    }


    @Test
    public void getIndexPage() {

        String viewName =  indexController.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());

    }
}