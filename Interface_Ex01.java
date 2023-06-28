public class Interface_Ex01 {

	public static void main(String[] args) {
		Archer npc_Archer_1 = new Archer("stupid sam");
		Worrior npc_Worrior_1 = new Worrior("brave Arthur");
		
		npc_Archer_1.move("cold cave");
		npc_Archer_1.playMethod();
		npc_Archer_1.attack();
		
		System.out.println("----------------------------------------------");
		
		npc_Worrior_1.move("winter castle");
		npc_Worrior_1.playMethod();
		npc_Worrior_1.attack();
	}
}


abstract class Status {
	public String name;
	public String place;
	
	//생성자
	public Status(String name) {
		this.name = name;
	}
	
	//일반 메서드
	public void move(String place) {
		System.out.println(name +" 이/가"+ place + "로 이동합니다.");
	}
	
	//추상메서드
	public abstract void playMethod();
}

interface skill {
	void attack();
}


class Worrior extends Status implements skill {
	public int str = 20;
	public int dex = 10;
	public String weapon = "칼";
	
	//생성자 따오기. super 이용
	public Worrior(String name) {
		super(name);
	}
	
	//일반메서드는 따로 적을 필요없지. 클래스에서 이미 정했으니까, 객체 생성하면 바로 그게 정해지는 것.
	
	//추상메서드
	public void playMethod() {
		System.out.println("Worrior는 아군을 지키며, 적을 무찌르는 직업입니다.");
	}
	
	//인터페이스
	public void attack() {
		System.out.println("Worrior는 "+ weapon + "을 사용하여 적을 공격합니다.");
	}
}

class Archer extends Status implements skill {
	public int str = 10;
	public int dex = 20;
	public String weapon = "석궁";
	
	//생성자 따오기. super 이용
	public Archer(String name) {
		super(name);
	}
	
	//일반메서드는 따로 적을 필요없지. 클래스에서 이미 정했으니까, 객체 생성하면 바로 그게 정해지는 것.
	
	//추상메서드
	public void playMethod() {
		System.out.println("Archer는 원거리에서 적을 견제하는 직업입니다.");
	}
	
	//인터페이스
	public void attack() {
		System.out.println("Archer는 "+ weapon + "을 사용하여 적을 공격합니다.");
	}
}

