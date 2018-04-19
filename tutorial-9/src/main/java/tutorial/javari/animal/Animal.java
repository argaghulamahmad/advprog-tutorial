package tutorial.javari.animal;

import java.io.Serializable;

/**
 * This class represents common attributes and behaviours found in all animals
 * in Javari Park.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Arga Ghulam Ahmad
 *
 * Implement compareTo, toString, and equals method.
 */
public class Animal implements Comparable<Animal>, Serializable {

    private final Integer id;
    private final String type;
    private final String name;
    private final Body body;
    private final Condition condition;

    /**
     * Constructs an instance of {@code Animal}.
     *
     * @param id        unique identifier
     * @param type      type of animal, e.g. Hamster, Cat, Lion, Parrot
     * @param name      name of animal, e.g. hamtaro, simba
     * @param gender    gender of animal (male/female)
     * @param length    length of animal in centimeters
     * @param weight    weight of animal in kilograms
     * @param condition health condition of the animal
     */
    public Animal(Integer id, String type, String name, Gender gender, double length,
                  double weight, Condition condition) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.body = new Body(length, weight, gender);
        this.condition = condition;
    }

    public Animal(Integer id) {
        this.id = id;
        this.type = "";
        this.name = "";
        this.body = null;
        this.condition = null;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns {@code Gender} identification of the animal.
     *
     * @return
     */
    public Gender getGender() {
        return body.getGender();
    }

    public double getLength() {
        return body.getLength();
    }

    public double getWeight() {
        return body.getWeight();
    }

    /**
     * Returns {@code Condition} of the animal.
     *
     * @return
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Determines whether the animal can perform their attraction or not.
     *
     * @return
     */
    public boolean isShowable() {
        return condition == Condition.HEALTHY;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "id=" + id
                + ", type='" + type + '\''
                + ", name='" + name + '\''
                + ", body=" + body
                + ", condition=" + condition
                + '}';
    }

    @Override
    public int compareTo(Animal o) {
        return id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((Animal) obj).getId());
    }
}
