package com.tacocloud.controller;

import com.tacocloud.data.IngredientRepository;
import com.tacocloud.data.TacoRepository;
import com.tacocloud.entity.Ingredient;
import com.tacocloud.entity.Order;
import com.tacocloud.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design2")
/**
 * 类级别的@SessionAttributes能够指定模型对象（如订单属性）要保存在session中，这样才能跨请求使用。
 */
@SessionAttributes("order")
public class DesignTaco2Controller {


    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTaco2Controller(IngredientRepository ingredientRepo,TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }


    /**
     * order()方法上的@ModelAttribute注解能够确保会在模型中创建一个Order对象。
     * 但是与模型中的Taco对象不同，我们需要订单信息在多个请求中都能出现，这样的话我们就能创建多个taco并将它们添加到该订单中
     * @return
     */
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
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
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