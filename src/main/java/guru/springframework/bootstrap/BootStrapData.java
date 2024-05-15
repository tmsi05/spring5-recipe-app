package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.maps.RecipeServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {


    private RecipeService recipeService;
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapData(RecipeRepository recipeRepository,
                         CategoryRepository categoryRepository,
                         UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeService = new RecipeServiceMap(recipeRepository);
        this.recipeRepository = recipeRepository;
        this.categoryRepository= categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("How to Make the Best Guacamole");
        Optional<Category> category1 = categoryRepository.findByDescription("Mexican");
        Category category = (category1.orElse(null));


        recipe1.getCategories().add(category);
        recipe1.setPrepTime(10);
        recipe1.setCookTime(0);
        recipe1.setServings(4);
        recipe1.setSource("Simple Recipes");
        recipe1.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe1.setDirections("Prepare Ingredients" +
                "Remove chilis, stems and seeds from jalapenos" +
                "Finely chop the cilantro" +
                "Finely chop the tomato" +
                "Cut the avocados:" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl. " +
                "Mash the avocado flesh:" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "Add the remaining ingredients to taste:" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "Serve immediately:" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips." +
                "Refrigerate leftover guacamole up to 3 days.");
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setDescription("Avocados");
        ingredient1.setAmount(BigDecimal.valueOf(2));
        ingredient1.setRecipe(recipe1);
        ingredient1.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe1.getIngredients().add(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setDescription("Kosher Salt");
        ingredient2.setAmount(BigDecimal.valueOf(0.25));
        ingredient2.setRecipe(recipe1);
        ingredient2.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        recipe1.getIngredients().add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setDescription("lime");
        ingredient3.setAmount(BigDecimal.valueOf(1));
        ingredient3.setRecipe(recipe1);
        ingredient3.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        recipe1.getIngredients().add(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setDescription("Jalapeno");
        ingredient4.setAmount(BigDecimal.valueOf(2));
        ingredient4.setRecipe(recipe1);
        ingredient4.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe1.getIngredients().add(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setDescription("cilantro");
        ingredient5.setAmount(BigDecimal.valueOf(2));
        ingredient5.setRecipe(recipe1);
        ingredient5.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        recipe1.getIngredients().add(ingredient5);

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setDescription("Black Pepper");
        ingredient6.setAmount(BigDecimal.valueOf(1));
        ingredient6.setRecipe(recipe1);
        ingredient6.setUom(unitOfMeasureRepository .findByDescription("Pinch").get());
        recipe1.getIngredients().add(ingredient6);

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setDescription("Tomato");
        ingredient7.setAmount(BigDecimal.valueOf(0.5));
        ingredient7.setRecipe(recipe1);
        ingredient7.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe1.getIngredients().add(ingredient7);

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setDescription("Red Radish");
        ingredient8.setAmount(BigDecimal.valueOf(1));
        ingredient8.setRecipe(recipe1);
        ingredient8.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe1.getIngredients().add(ingredient8);

        Ingredient ingredient9 = new Ingredient();
        ingredient9.setDescription("Tortilla chips");
        ingredient9.setAmount(BigDecimal.valueOf(20));
        ingredient9.setRecipe(recipe1);
        recipe1.getIngredients().add(ingredient9);

        recipeService.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Spicy Grilled Chicken Tacos");
        Optional<Category> category2 = categoryRepository.findByDescription("Mexican");
        category = (category2.orElse(null));

        recipe2.setPrepTime(20);
        recipe2.setCookTime(15);
        recipe2.setServings(6);
        recipe2.setSource("Simple Recipes");
        recipe2.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        recipe2.setDirections("Prepare Ingredients" +
                "Remove chilis, stems and seeds from jalapenos" +
                "Finely chop the cilantro" +
                "Finely chop the tomato" +
                "Prepare the grill:" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat." +
                "Make the marinade and coat the chicken:" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over." +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings."+
                "Grill the chicken:" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes." +
                "Thin the sour cream with milk:" +
                "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle." +
                "Assemble the tacos:" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges." +
                "Warm the tortillas:" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side." +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving."
                );
        Ingredient ingredient21 = new Ingredient();
        ingredient21.setDescription("ancho chili powder");
        ingredient21.setAmount(BigDecimal.valueOf(2));
        ingredient21.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient21.setRecipe(recipe2);
        recipe2.getIngredients().add(ingredient21);

        Ingredient ingredient22 = new Ingredient();
        ingredient22.setDescription("Dried Oregano");
        ingredient22.setAmount(BigDecimal.valueOf(1));
        ingredient22.setRecipe(recipe2);
        ingredient22.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        recipe2.getIngredients().add(ingredient22);

        Ingredient ingredient23 = new Ingredient();
        ingredient23.setDescription("Dried Cumin");
        ingredient23.setAmount(BigDecimal.valueOf(1));
        ingredient23.setRecipe(recipe2);
        ingredient23.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        recipe2.getIngredients().add(ingredient23);

        Ingredient ingredient24 = new Ingredient();
        ingredient24.setDescription("sugar");
        ingredient24.setAmount(BigDecimal.valueOf(1));
        ingredient24.setRecipe(recipe2);
        ingredient24.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        recipe2.getIngredients().add(ingredient24);

        Ingredient ingredient25 = new Ingredient();
        ingredient25.setDescription("Kosher Salt");
        ingredient25.setAmount(BigDecimal.valueOf(0.5));
        ingredient25.setRecipe(recipe2);
        ingredient25.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        recipe2.getIngredients().add(ingredient25);

        Ingredient ingredient26 = new Ingredient();
        ingredient26.setDescription("Clove Garlic");
        ingredient26.setAmount(BigDecimal.valueOf(1));
        ingredient26.setRecipe(recipe2);
        ingredient26.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient26);

        Ingredient ingredient27 = new Ingredient();
        ingredient27.setDescription("Orange zest");
        ingredient27.setAmount(BigDecimal.valueOf(0.5));
        ingredient27.setRecipe(recipe2);
        ingredient27.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        recipe2.getIngredients().add(ingredient27);

        Ingredient ingredient28 = new Ingredient();
        ingredient28.setDescription("Orange juice");
        ingredient28.setAmount(BigDecimal.valueOf(3));
        ingredient28.setRecipe(recipe2);
        ingredient28.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        recipe2.getIngredients().add(ingredient28);

        Ingredient ingredient29 = new Ingredient();
        ingredient29.setDescription("Olive Oil");
        ingredient29.setAmount(BigDecimal.valueOf(2));
        ingredient29.setRecipe(recipe2);
        ingredient29.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        recipe2.getIngredients().add(ingredient29);

        Ingredient ingredient30 = new Ingredient();
        ingredient30.setDescription("Chicken Thights");
        ingredient30.setAmount(BigDecimal.valueOf(6));
        ingredient30.setRecipe(recipe2);
        recipe2.getIngredients().add(ingredient30);

        Ingredient ingredient31 = new Ingredient();
        ingredient31.setDescription("Tortillas");
        ingredient31.setAmount(BigDecimal.valueOf(8));
        ingredient31.setRecipe(recipe2);
        ingredient31.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient31);

        Ingredient ingredient32 = new Ingredient();
        ingredient32.setDescription("packed baby arugula ");
        ingredient32.setAmount(BigDecimal.valueOf(6));
        ingredient32.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
        ingredient32.setRecipe(recipe2);
        recipe2.getIngredients().add(ingredient32);

        Ingredient ingredient33 = new Ingredient();
        ingredient33.setDescription("Medium Ripe Avocado ");
        ingredient33.setAmount(BigDecimal.valueOf(2));
        ingredient33.setRecipe(recipe2);
        ingredient33.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient33);

        Ingredient ingredient34 = new Ingredient();
        ingredient34.setDescription("Radishes");
        ingredient34.setAmount(BigDecimal.valueOf(4));
        ingredient34.setRecipe(recipe2);
        ingredient34.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient34);

        Ingredient ingredient35 = new Ingredient();
        ingredient35.setDescription("Cherry Tomato");
        ingredient35.setAmount(BigDecimal.valueOf(0.5));
        ingredient35.setUom(unitOfMeasureRepository.findByDescription("Pint").get());
        ingredient35.setRecipe(recipe2);
        recipe2.getIngredients().add(ingredient35);

        Ingredient ingredient36 = new Ingredient();
        ingredient36.setDescription("Red Onion");
        ingredient36.setAmount(BigDecimal.valueOf(0.25));
        ingredient36.setRecipe(recipe2);
        ingredient36.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient36);

        Ingredient ingredient37 = new Ingredient();
        ingredient37.setDescription("Cilantro");
        ingredient37.setAmount(BigDecimal.valueOf(0.25));
        ingredient37.setRecipe(recipe2);
        ingredient37.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
        recipe2.getIngredients().add(ingredient37);

        Ingredient ingredient38 = new Ingredient();
        ingredient38.setDescription("Sour Cream");
        ingredient38.setAmount(BigDecimal.valueOf(0.5));
        ingredient38.setRecipe(recipe2);
        ingredient38.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
        recipe2.getIngredients().add(ingredient38);

        Ingredient ingredient39 = new Ingredient();
        ingredient39.setDescription("Milk");
        ingredient39.setAmount(BigDecimal.valueOf(0.25));
        ingredient39.setRecipe(recipe2);
        ingredient39.setUom(unitOfMeasureRepository.findByDescription("Cup").get());
        recipe2.getIngredients().add(ingredient39);

        Ingredient ingredient40 = new Ingredient();
        ingredient40.setDescription("Lime");
        ingredient40.setAmount(BigDecimal.valueOf(1));
        ingredient40.setRecipe(recipe2);
        ingredient40.setUom(unitOfMeasureRepository.findByDescription("Unit").get());
        recipe2.getIngredients().add(ingredient40);

        recipeService.save(recipe2);

    }


}
