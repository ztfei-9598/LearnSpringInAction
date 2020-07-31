package com.tacocloud.controller;

import com.tacocloud.entity.Ingredient;
import com.tacocloud.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangtengfei
 */
/**
 * Lombok所提供的注解，在运行时，它会在这个类中自动生成一个SLF4J（Simple Logging Facade for Java）Logger。
 */
@Slf4j
/**
 * 将这个类识别为控制器，并且将其作为组件扫描的候选者，
 * 所以Spring会发现它并自动创建一个DesignTacoController实例，并将该实例作为Spring应用上下文中的bean
 */
@Controller
/**
 * 能够指定该控制器所处理的请求类型
 */
@RequestMapping("/design")
public class DesignTacoController {
    /**
     * 是一个相对较新的注解，是在Spring 4.3引入的。
     * 在Spring 4.3之前，你可能需要使用方法级别的@RequestMapping注解作为替代：
     * @GetMapping
     * @param model
     * @return
     */
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        //Model对象负责在控制器和展现数据的视图之间传递数据
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> collect = ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
        return collect;
    }


    /**
     * @Valid注解会告诉Spring MVC要对提交的Taco对象进行校验，
     * 而校验时机是在它绑定完表单数据之后、调用processDesign()之前。如果存在校验错误，
     * 那么这些错误的细节将会捕获到一个Errors对象中并传递给processDesign()。processDesign()方法的前几行会查阅Errors对象，
     * 调用其hasErrors()方法判断是否有校验错误。如果存在校验错误，那么这个方法将不会处理Taco对象并返回“design”视图名，表单会重新展现。
     * @param design
     * @param errors
     * @param model
     * @return
     */
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, ModelMap model) {
        if (errors.hasErrors()) {
            model.addAttribute("design", design);
            return "design";
        }
        // Save the taco design...
        // We'll do this in chapter 3
        // Validating form input
        log.info("Processing design: " + design);
        //用户将会被重定向到一个订单表单页面，在这里用户可以创建一个订单，将他们所创建的taco快递过去
        return "redirect:/orders/current";
    }

}