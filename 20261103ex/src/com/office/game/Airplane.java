package com.office.game;

public class Airplane implements ICharacter {

	public void fly(int x, int y) {
		
		System.out.printf("%d, %d로 날아서 이동\n", x, y);
		
	}

	@Override
	public void run(int x, int y) {
		fly(x, y);
		
	}
	
}
