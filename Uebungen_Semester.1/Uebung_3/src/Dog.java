public class Dog {
   private int size;
   private String breed;
   private String name;

    void bark()
    {
        System.out.println(name + " barks: RAFF! RAFF!");
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
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


}
