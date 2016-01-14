package be.feesboek.models;

public class BirdVO {
    
    String breed;
    String name;
    Integer age;
    Integer wingLength;

    /**
     * Implementation without toString, equals, hashCode
     * toString: unreadable default implemenation
     * equals  : birds are never the same, only if they reference the same object
     * hashCode: you can put them all in a HashMap
     */
    public BirdVO() {
    }

    public BirdVO(String breed, String name, Integer age, Integer wingLength) {
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.wingLength = wingLength;
    }
    
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWingLength() {
        return wingLength;
    }

    public void setWingLength(Integer wingLength) {
        this.wingLength = wingLength;
    }
}
