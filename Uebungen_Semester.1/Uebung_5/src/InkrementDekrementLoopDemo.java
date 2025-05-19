public class InkrementDekrementLoopDemo
{
    public static void main(String[] args)
    {

        for(int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
        int i = 1;
        while(i <= 10)
        {
            System.out.println(i);
            i++;
        }

        for(int j = -3; j <= 3; j++)
        {
            System.out.println(j);
        }

        int j = -3;
        while(j <= 3)
        {
            System.out.println(j);
            j++;
        }

        for(int k = 10; k >= 0; k--)
        {
            System.out.println(k);
        }
        int k = 10;
        while(k >= 0)
        {
            System.out.println(k);
            k--;
        }

        for(int l = 0; l >= -5; l--)
        {
            System.out.println(l);
        }
        int m = 0;
        while(m >= -5)
        {
            System.out.println(m);
            m--;
        }

        /*   x++/x-- sind Ideal für einfache, standardisierte Fälle, wie z. B. die Steuerung von Schleifen, da sie kompakt und lesbar sind.
        x = x + 1/x = x - 1 sind eher Geeignet, wenn Verständlichkeit, Flexibilität oder komplexere Berechnungen zu erledigen sind.
        Die Wahl zwischen beiden Ansätzen hängt von der Situation, dem Kontext und der Zielgruppe des Codes ab.
        Z.b wenn ein Zähler als variable Übergeben wird x = x + y oder dieser fest über 1 hinaus geht */

        /*
        x++ vs. ++x:
        x++, wenn der aktuelle Wert wichtig ist und erst nach der Verwendung erhöht werden soll.
        ++x, wenn der erhöhte Wert sofort benötigt wird.
        Schleifen mit x--
        Wenn der Wert korrekt initialisiert ist und der Bereich klar definiert ist.
        x-- in Kombination mit mehrfacher Nutzung der Variablen innerhalb
        der Schleifenlogik NICHT verwenden, um Verwirrung und Fehler zu vermeiden.
        */





    }
}
