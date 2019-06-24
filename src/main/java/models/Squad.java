package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private int max_size;
    private String name;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;
    private ArrayList<Hero> heroes;

    public Squad(int max_size, String name, String cause) {
        this.max_size = max_size;
        this.name = name;
        this.cause = cause;
        instances.add(this);
        id = instances.size();
        heroes = new ArrayList<>();
    }

    public int getMax_size() {
        return max_size;
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public static void setInstances(ArrayList<Squad> instances) {
        Squad.instances = instances;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public static void clear(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Squad findById(int id){
        return instances.get( id - 1);
    }
    public static ArrayList<Squad> getAll() {
        return instances;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero){
        heroes.add(hero);
    }

}
