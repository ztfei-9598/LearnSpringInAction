package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Ingredient.Type;
import sia.tacocloud.Order;
import sia.tacocloud.Taco;
import sia.tacocloud.data.IngredientRepository;
import sia.tacocloud.data.TacoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design2")
@SessionAttributes("order")
public class DesignTaco2Controller {


    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTaco2Controller(IngredientRepository ingredientRepo,TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }


    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Type type) {
        List<Ingredient> collect = ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
        return collect;
    }


    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, ModelMap model,@ModelAttribute Order order) {
        if (errors.hasErrors()) {
            model.addAttribute("design", design);
            return "design";
        }
        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);//Validating form input

        Taco save = designRepo.save(design);



        return "redirect:/orders/current";
    }

}