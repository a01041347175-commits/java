package com.office.example;

public class MainClass {

    public static void main(String[] args) {
        // 차가 있는 학생
        Student student1 = new Student("홍길동", 22, new Car("White", "123가4567"));
        student1.printInfo();

        System.out.println("----------");

        // 차가 없는 학생 → 나중에 구입
        Student student2 = new Student("이순신", 20);
        student2.printInfo();
        student2.setCar(new Car("Black", "45나6789"));
        student2.printInfo();
        
    }
}
