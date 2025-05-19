public class EnhancedForLoopDemo
{
    public static void main(String[] args)
    {
        String[] namen = {"Tim", "Markus", "Leo", "Niklas"};

        for(String name: namen) //erweiterte for schleife (auch foreach schleife genannt. Zählervriable für ein Array. in der Ausgabe nimmt man die Zählervariable
        {
            System.out.println(name);
        }


        int[] zahlen = {10, 11, 20, 22, 30, 33, 40, 44, 50, 55};

        // bei einer ausgabe mit der Bedingung von nur geraden Werten, also (zahl[i} % 2 == 0)
        int index = 0;

        for (int indexer = 0; indexer < zahlen.length; indexer += 2) {
            //if (zahlen[indexer] % 2 == 0) { Brauche ich wenn nicht jede 2 Zahl gerade ist in einem Array
            System.out.println(zahlen[indexer]);
            // }
        }


        // wenn zusätzlich die indizes ausgegebn werden sollen würde ich eine for schleife nehmen da man dort direkt zugriff auf den Zähler (indexer) hat


        while(index < zahlen.length) {
            System.out.println("Index: " + index + ", Wert: " + zahlen[index]);
            index++;
        }

        // while schleifen sind besonders dann nützlich wenn nur ein bestimmter Zustand zum ende der schleife führen soll
        // auch kann man den zustand der schleife ändern wenn ein check innerhlab der schleife getätogt wird, so kann man diese auch frühzeitig beenden

        int indexNew = 0;
        boolean check = true;
        while(check && indexNew < zahlen.length)
        {
            if(zahlen[indexNew] == 40)
            {
                check = false;
                System.out.println("Hier ist 40: " + zahlen[indexNew] + " bei " + indexNew);
            }
            else System.out.println("Hier ist NICHT 40 : " + zahlen[indexNew] + " bei " + indexNew);
            indexNew++;
        }


        // bei der ausgabe von einer bestimmten eigenschaft von objekten ist die foreach-schleife praktisch, da in dieser nur
        // durch den ausgabewert iteriert wird und man diesen so schnell erkennen und überprüfen kann. So kann man die logik schnell lesen und verstehen

        Object obj = new Object();
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Object[] objArray = {obj, obj1, obj2, obj3};

        for(Object objString: objArray)
        {
            System.out.println(objString.toString());
        }

    }

}
