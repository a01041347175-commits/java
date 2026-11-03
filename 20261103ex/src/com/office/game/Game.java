package com.office.game;

public class Game {

	private Bear bear;
	private Robot robot;
	private Airplane airplane;
	private Dog dog;
	private ICharacter[] iCharacters;
	
	
	public Game(Bear bear, Robot robot, Airplane airplane, Dog dog) {
		
		this.bear = bear;
		this.robot = robot;
		this.airplane = airplane;
		this.dog = dog;
		
		iCharacters = new ICharacter[] {
				this.bear,
				this.robot,
				this.airplane,
				this.dog
		};
	}



	public void move(int x, int y) {
		
//		bear.work(x, y);
//		robot.run(x, y);
//		dog.run(x, y);
//		airplane.fly(x, y);
		
//		bear.run(x, y);
//		robot.run(x, y);
//		dog.run(x, y);
//		airplane.run(x, y);
		
		for (int i = 0; i < iCharacters.length; i++) {
			iCharacters[i].run(x, y);
		}
		
	}
	
}
