package test.student;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import card.base.UnitCard;
import card.type.LeaderUnitCard;

public class TestLeaderUnitCard {
	LeaderUnitCard leaderUnit1;
	UnitCard leaderUnit2;
	LeaderUnitCard leaderUnit3;
	LeaderUnitCard oppoUnit1;
	LeaderUnitCard nUnit1;
	LeaderUnitCard nUnit2;
	LeaderUnitCard nUnit3;
	UnitCard[] unitList;
	
	@BeforeEach
	void setUp() {
		leaderUnit1 = new LeaderUnitCard("Leader" , "He's a Leader" , 2 , 3 , 2 , 3 , 2);
		leaderUnit2 = new LeaderUnitCard("Boss" , "Worse version of Leader" , 4 , 1 , 4 , 1 , 2);
		leaderUnit3 = new LeaderUnitCard("Leader" , "He's a Leader" , -1 , -3 , -2 ,-3 , -2);
		oppoUnit1 = new LeaderUnitCard("Opponent", "I'm an opponent", 0 , 1, 5,0,0);
		nUnit1 = new LeaderUnitCard("Unit1", "1", 0 , 1, 2,0,0);
		nUnit2 = new LeaderUnitCard("Unit2", "2", 0 , 3, 1,0,0);
		nUnit3 = new LeaderUnitCard("Unit3", "3", 0 , 2, 4,0,0);
		unitList = new UnitCard[]{nUnit1,nUnit2,nUnit3};
	}
	
	@Test
	void testConstructor() {
		
		assertEquals("Leader", leaderUnit1.getName());
		assertEquals("He's a Leader", leaderUnit1.getFlavorText());
		assertEquals(2, leaderUnit1.getBloodCost());
		assertEquals(3, leaderUnit1.getPower());
		assertEquals(2, leaderUnit1.getHealth());
		assertEquals(3, leaderUnit1.getBuffPower());
		assertEquals(2, leaderUnit1.getBuffHealth());

	}
	
	@Test
	void testConstructorNegativeValue() {
		
		assertEquals("Leader", leaderUnit3.getName());
		assertEquals("He's a Leader", leaderUnit3.getFlavorText());
		assertEquals(0, leaderUnit3.getBloodCost());
		assertEquals(0, leaderUnit3.getPower());
		assertEquals(0, leaderUnit3.getHealth());
		assertEquals(0, leaderUnit3.getBuffPower());
		assertEquals(0, leaderUnit3.getBuffHealth());

	}
	
	@Test
	void testSetBuffPower(){
		leaderUnit1.setBuffPower(5);
		assertEquals(5,leaderUnit1.getBuffPower());
		leaderUnit1.setBuffPower(-1);
		assertEquals(0,leaderUnit1.getBuffPower());
		
	}
	
	//Fill Code Here!!!
	// 1.testSetBuffHealth
	// 2.testAttack (Must test a case of oppoUnit1 take damage exceed its health, not including this case will only give you half a score)
	// 3.testBuffUnit

	@Test
	void testSetBuffHealth() {
		leaderUnit1.setBuffHealth(-3);
		assertEquals(0,leaderUnit1.getBuffHealth());
		
		oppoUnit1.setBuffHealth(6);
		assertEquals(6,oppoUnit1.getBuffHealth());
		
		leaderUnit3.setBuffHealth(0);
		assertEquals(0,leaderUnit3.getBuffHealth());
	}
	
	@Test
	void testAttack() {

		int attackValue1 = 0;
		for (int i=0; i<3; i++){
			attackValue1 += leaderUnit1.attackUnit(oppoUnit1);
		}
		assertEquals(attackValue1, 5);
		oppoUnit1.setHealth(5);

		int attackValue2 = 0;
		for (int i=0; i<3; i++){
			attackValue2 += leaderUnit2.attackUnit(oppoUnit1);
		}
		assertEquals(attackValue2, 3);
	}
	
	@Test 
	void testBuffUnit() {
		leaderUnit1.buffUnit(unitList);
		assertEquals(4,nUnit1.getPower());
		assertEquals(4,nUnit1.getHealth());
		assertEquals(6,nUnit2.getPower());
		assertEquals(3,nUnit2.getHealth());
		assertEquals(5,nUnit3.getPower());
		assertEquals(6,nUnit3.getHealth());
		
		leaderUnit3.buffUnit(unitList);
		assertEquals(4,nUnit1.getPower());
		assertEquals(4,nUnit1.getHealth());
		assertEquals(6,nUnit2.getPower());
		assertEquals(3,nUnit2.getHealth());
		assertEquals(5,nUnit3.getPower());
		assertEquals(6,nUnit3.getHealth());
	}
}


