package HW7;

public class Strategy1 {
    private Weapon weapon = null;
    
    void doAttack() {
    	if(weapon == null) System.out.println("�Ǽհ���");
    	else weapon.attack();
    }

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
    
}
