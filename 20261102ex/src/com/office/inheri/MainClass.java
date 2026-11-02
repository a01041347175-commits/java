package com.office.inheri;

import com.office.inheri.restaurant.ChildRestaurant;

public class MainClass {

	public static void main(String[] args) {
		
//		ParentRestaurant parentRestaurant = new ParentRestaurant();
//		parentRestaurant.makeJajang();
//		parentRestaurant.makeJamppong();
		
		ChildRestaurant childRestaurant = new ChildRestaurant();
		childRestaurant.makeJajang(ChildRestaurant.CHILD_MENU);
		childRestaurant.makeJamppong();
		childRestaurant.makeBokkeumbap();
		childRestaurant.makeTangsuyuk();

	}

}
