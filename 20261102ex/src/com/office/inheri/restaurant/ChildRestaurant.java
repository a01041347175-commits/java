package com.office.inheri.restaurant;

public class ChildRestaurant 
					extends ParentRestaurant 
					implements CheckList, CheckList2 {

	public final static int PARENT_MENU = 1;
	public final static int CHILD_MENU = 2;
	
	public void makeBokkeumbap() {
		System.out.println("자손 볶음밥 만듦");
	}
	
//	@Override
	public void makeJajang(int menu) {
		if (menu == PARENT_MENU) {
			super.makeJajang();
		} else {
			System.out.println("자손 MZ자장면 만듦");
		}
	}
	
	@Override
	public void makeTangsuyuk() {
		System.out.println("자손 탕수육 만듦");
	}

	@Override
	public void checkFloor() {
			
		
	}

	@Override
	public void checkToilet() {
		
			
	}

	@Override
	public void checkHwagu() {
		
		
	}
	
	
	
}
