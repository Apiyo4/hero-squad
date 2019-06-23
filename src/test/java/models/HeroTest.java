package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        Hero.clear();
    }

    @Test
    public void newHero_InstantiatesCorrectly() throws Exception{
        Hero hero = new Hero("Flash", 28, "fast", "dies");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void newHero_getsName_Flash() throws Exception{
        Hero hero = setupNewHero();
        assertEquals("Flash", hero.getName());
    }

    @Test
    public void newHero_getsAge_28() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(28, hero.getAge());
    }

    @Test
    public void newHero_getSpecialPower_fast() throws Exception{
        Hero hero = setupNewHero();
        assertEquals("fast", hero.getSpecialPower());
    }

    @Test
    public void newHero_getWeakness_dies() throws Exception{
        Hero hero = setupNewHero();
        assertEquals("dies", hero.getWeakness());
    }

    @Test
    public void newHero_getId_1() throws Exception{
        Hero.clear();
        Hero hero = setupNewHero();
        assertEquals(1, hero.getId());
    }

    @Test
    public void newHero_returnsAllInstancesOfHeroes() throws Exception{
        Hero hero = setupNewHero();
        Hero otherHero = new Hero("Moose", 31, "weapons", "cake");
        assertEquals(true, Hero.getAll().contains(hero));
        assertEquals(true, Hero.getAll(). contains(hero));
    }

    @Test
    public void newHero_findsCorrectHero() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void newHero_findsReturnCorrectHeroWhenMoreHeroesExists() throws Exception{
        Hero hero = setupNewHero();
        Hero otherHero =  new Hero("Moose", 31, "weapons", "cake");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

    public Hero setupNewHero(){
        return new Hero("Flash", 28, "fast", "dies");
    }

}