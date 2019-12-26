package HW7;

public class MainEntry {

	public static void main(String[] args) {
		Strategy1 strategy = new Strategy1();
		strategy.doAttack();
		
		strategy.setWeapon(new Knife());
		strategy.doAttack();
		
		strategy.setWeapon(new Gun());
		strategy.doAttack();
		
		strategy.setWeapon(new Cannon());
		strategy.doAttack();
	}
}
