package guru.springframework.services.maps;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceMap implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceMap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        return new HashSet<>(recipeRepository.findAll());
    }

    @Override
    public Recipe save(Recipe object) {
        return recipeRepository.save(object);
    }


}
