package alston.homework1.polymorphism;

//多型
class Animal {

    public void makeSound() {
        System.out.println("animal is making a sound");
    }

}

class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("dog is barking");
    }

}

class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("cat is meowing");
    }

}