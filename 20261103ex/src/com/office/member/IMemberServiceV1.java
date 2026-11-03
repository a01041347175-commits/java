package com.office.member;

import java.util.Scanner;

public interface IMemberServiceV1 {

	public void signUp(Scanner scanner);
	
	public void signIn(Scanner scanner);
	
	public void modify(Scanner scanner);
	
	public void delete(Scanner scanner);
	
}
