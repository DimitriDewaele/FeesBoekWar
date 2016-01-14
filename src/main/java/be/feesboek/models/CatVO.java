package be.feesboek.models;

import java.util.Objects;

public class CatVO {
    
    private String name;
    private String color;
    private Integer age;

    /**
     * Implementation with toString, equals, hashCode
     * toString(): readable cats
     * equals()  : Cats with the same name are equal
     * hashCode(): Cats with the same name have the same hashCode
     */
    public CatVO() {
    }

    public CatVO(String name, String color, Integer age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CatVO{" + "name=" + name + ", color=" + color + ", age=" + age + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        //Cats with the same name return the same hash
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final CatVO other = (CatVO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        // If cats have the same name: they are equal
        return true;
    }
    
    
}
