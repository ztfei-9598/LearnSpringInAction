package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.Ingredient;
import sia.tacocloud.Ingredient.Type;
import sia.tacocloud.Taco;

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
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        //Model对象负责在控制器和展现数据的视图之间传递数据
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Type type) {
        List<Ingredient> collect = ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
        return collect;
    }


    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, ModelMap model) {
        if (errors.hasErrors()) {
            model.addAttribute("design", design);
            return "design";
        }
        // Save the taco design...
        // We'll do this in chapter 3
        log.info("Processing design: " + design);//Validating form input
        return "redirect:/orders/current";
    }

}