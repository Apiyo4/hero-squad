import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            request.session().attribute("name", name);
            model.put("name", name);
            int max_size = Integer.parseInt(request.queryParams("max_size"));
            request.session().attribute("max_size", max_size);
            model.put("max_size", max_size);
            String cause = request.queryParams("cause");
            request.session().attribute("cause", cause);
            model.put("cause", cause);
            Squad squad = new Squad(max_size, name, cause);
            model.put("squad", squad);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroes-form.hbs");
        }, new HandlebarsTemplateEngine());
        post("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            request.session().attribute("name", name);
            model.put("name", name);
            int age = Integer.parseInt(request.queryParams("age"));
            request.session().attribute("age", age);
            model.put("age", age);
            String specialPower = request.queryParams("specialPower");
            request.session().attribute("specialPower", specialPower);
            model.put("specialPower", specialPower);
            String weakness = request.queryParams("weakness");
            request.session().attribute("weakness", weakness);
            model.put("weakness", weakness);
            Hero heroes = new Hero( name, age, specialPower, weakness);
            model.put("heroes", heroes);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());
    }
    }
