package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        Squad.clear();
    }

    @Test
    public void newSquad_InstantiatesCorrectly() throws Exception{
        Squad squad = new Squad(5, "Jumanji", "save Jumanji");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void newSquad_getsMaxSize_5() throws Exception{
        Squad squad = setupNewSquad();
        assertEquals(5, squad.getMax_size());
    }

    @Test
    public void newSquad_getsName_Jumanji() throws Exception{
        Squad squad = setupNewSquad();
        assertEquals("Jumanji", squad.getName());
    }

    @Test
    public void newSquad_getsCause_saveJumanji() throws Exception{
        Squad squad = setupNewSquad();
        assertEquals("save Jumanji", squad.getCause());
    }

    @Test
    public void newSquad_returnsAllInstancesOfSquads() throws Exception{
        Squad squad = setupNewSquad();
        Squad otherSquad = new Squad(5, "Maven", "computer illiteracy");
        assertEquals(true, Squad.getAll().contains(squad));
        assertEquals(true, Squad.getAll(). contains(squad));
    }

    @Test
    public void newSquad_clear_0() {
        Squad.clear();
        assertEquals(0,Squad.getAll().size());
    }

    @Test
    public void newSquad_getId_1() throws Exception{
        Squad.clear();
        Squad squad = setupNewSquad();
        assertEquals(1, squad.getId());
    }

    @Test
    public void newSquad_findsCorrectSquad() throws Exception{
        Squad squad = setupNewSquad();
        assertEquals(1, Squad.findById(squad.getId()).getId());
    }

    @Test
    public void newSquad_findsReturnCorrectHeroWhenMoreHeroesExists() throws Exception{
        Squad squad = setupNewSquad();
        Squad otherSquad =  new Squad(5, "Maven", "computer illiteracy");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }

    @Test
    public void newSquad_startsWithEmptyList_ArrayList() {
        Squad.clear();
        Squad squad = setupNewSquad();
        assertEquals(0, squad.getHeroes().size());
    }

    @Test
    public void newSquad_addsHeroesToList_true() {
        Squad squad = setupNewSquad();
        Hero hero = setupNewHero();
        squad.addHero(hero);
        assertEquals(true, squad.getHeroes().contains(hero));
    }

    public Squad setupNewSquad(){
        return new Squad(5, "Jumanji", "save Jumanji");
    }

    public Hero setupNewHero(){
        return new Hero("Flash", 28, "fast", "dies");
    }
}