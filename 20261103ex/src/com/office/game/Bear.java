package com.office.game;

public class Bear implements ICharacter {
	
	private void work(int x, int y) {
		
		System.out.printf("%d, %d로 네발로 이동\n", x, y);
		
	}

	@Override
	public void run(int x, int y) {
		work(x, y);
		
	}
	
}
