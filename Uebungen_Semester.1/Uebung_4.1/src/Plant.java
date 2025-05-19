public class Plant
{

    private double height;
    private String type;
    private int waterLevel;

    public double GetHeight()
    {
        return height;
    }
    public void SetHeight(double height)
    {
        if (height < 0)
        {
            System.out.println("Invalid height");
        }
        else this.height = height;

    }

    public String GetType()
    {
        return type;
    }
    public void SetType(String type)
    {
        this.type = type;
    }

    public int GetWaterLevel()
    {
        return waterLevel;
    }
    public void SetWaterLevel(int waterLevel)
    {
        if (waterLevel < 0 | waterLevel > 70)
        {
            System.out.println("Invalid waterLevel, either negative or to much water!");
        }
        else this.waterLevel = waterLevel;
    }

    //1. Wegen der Datenkapselung (also der begrenzten Zugriffbarkeit der Insta zvariablen,
    // so das sie nicht ausversehen geändert werden können an Orten an denen dieses nicht passieren soll

    //2. Die Rückgabe zu validieren oder das bei änderungen des Codes weniger Fehler auftreten

    //3. Setter geben ohnehin explizit den einzugebenden Datentyp an und somit sind andere ungültig, dazu
    // hilft eine erweiterte Validierung, einen bestimmten Wertebereich o.ä. zu konkretisieren. Dies kann zum Beispiel
    // bei einer Reservierung sinn machen, denn wenn z.b. ein Escape Room nur 2-5 Leute einlassen kann/darf,
    // so kann man es so schneller korrigieren ohne den Code unnötig zu erweitern.

    //4. Die Pflanze könnte schrumpfen, die Kapselung schützt vor fehlerhaften Wertzuweisungen im Negativen Bereich und
    // einem versehentlichem Zugriff






    public void grow(int sunlightHours)
    {
        height += 0.5 * sunlightHours;
    }

   /*
    public void newWater(int waterLevel)
    {
        this.waterLevel = waterLevel;
    }
    */

    public void addWater(int amount)
    {
        this.waterLevel += amount;
    }

    public boolean needWater()
    {
        return this.waterLevel < 10;
    }


}
