package comnitt.boston.listtry;

/**
 * Created by HP on 11-Jun-17.
 */



public class Item {

    String Name;
    int Image;

    public Item(String animalName,int animalImage)
    {
        this.Image=animalImage;
        this.Name=animalName;
    }
    public String getName()
    {
        return Name;
    }
    public int getImage()
    {
        return Image;
    }
}