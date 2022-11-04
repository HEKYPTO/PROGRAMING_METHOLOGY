package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import card.base.SpellCard;
import card.type.DamageSpellCard;
import card.type.NormalUnitCard;

public class TestDamageSpellCard {
	NormalUnitCard unit;

	SpellCard spell0 = new DamageSpellCard("DSpell0" , "-1" , 1,true,1);
	DamageSpellCard spell1 = new DamageSpellCard("DSpell1" , "-1" , 1,true,1);
	DamageSpellCard spell2 = new DamageSpellCard("DSpell2" , "-2" , 1,true,2);
	DamageSpellCard spell3 = new DamageSpellCard("DSpell3" , "-3" , 2,false,3);
	DamageSpellCard spellN = new DamageSpellCard("DSpellN" , "XX" , -2,false, -1);
	
	@BeforeEach
	public void setUp() {
		unit = new NormalUnitCard("Tanky Unit" , "I'm a tanky unit" , 0 , 2 , 10);
	}
	
	//Fill Code Here!!!
	// 1.testConstructor
	// 2.testSetDamage
	// 3.testCastSpell

	@Test
    public void testConstructor() {

		assertEquals("DSpell1", spell1.getName());
		assertEquals("-1", spell1.getFlavorText());
		assertEquals(1, spell1.getBloodCost());
		assertTrue(spell1.isBurstSpeed());
		assertEquals(1, spell1.getDamage());

		assertEquals("DSpellN", spellN.getName());
		assertEquals("XX", spellN.getFlavorText());
		assertEquals(0, spellN.getBloodCost());
		assertFalse(spellN.isBurstSpeed());
		assertEquals(1, spellN.getDamage());
    }

    @Test
    public void testSetDamage() {
        assertEquals(1, spell1.getDamage());
        assertEquals(2, spell2.getDamage());
        assertEquals(3, spell3.getDamage());
        assertEquals(1, spellN.getDamage());
    }

    @Test
    public void testCastSpell() {

		setUp();

        spell1.castSpell(unit);
        assertEquals(9, unit.getHealth());

        spell2.castSpell(unit);
        assertEquals(7, unit.getHealth());

        spell3.castSpell(unit);
        assertEquals(4, unit.getHealth());

        spell1.castSpell(unit);
        assertEquals(3, unit.getHealth());

        spell3.castSpell(unit);
        assertEquals(0, unit.getHealth());

        spell2.castSpell(unit);
        assertEquals(0, unit.getHealth());
    }
}


