package clase;
public class Utilizator {
    private String nume, parola;
    private int portofel, nrPersoane;
    private static Utilizator iniUtilizator;

    public static Utilizator Init(String nume, String parola)
    {
        if (iniUtilizator == null)
        {
            iniUtilizator = new Utilizator(nume, parola);
        }
        return iniUtilizator;
    }

    public static Utilizator Init()
    {
        if (iniUtilizator == null)
        {
            iniUtilizator = new Utilizator();
        }
        return iniUtilizator;
    }


    private Utilizator(String nume, String parola)
    {
        this.nume = nume;
        this.parola = parola;
    }

    private Utilizator()
    {

    }

    public void setPortofel(int portofel) {
        this.portofel = portofel;
    }

}
