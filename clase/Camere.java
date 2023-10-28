package clase;
public class Camere{
    private boolean standard, mediu, ridicat;
    private final int PretStandard = 100 , PretMediu = 150, PretRidicat = 300, NrMAXpersoane = 5;
    private int nrPersoane;
    
    public Camere(String s, int nrPersoane){
        this.nrPersoane = nrPersoane;
        if (s.equals("Standard"))
        {
            standard = true;
        }
        else if (s.equals("Mediu"))
        {
            mediu = true;
        }
        else 
        {
            ridicat = true;
        }
    }
    public Camere()
    {

    }
    
    public void setMediu(boolean mediu) {
        this.mediu = mediu;
    }

    public void setRidicat(boolean ridicat) {
        this.ridicat = ridicat;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public boolean getStandard()
    {
        return standard;
    }
    
    public boolean getMediu()
    {
        return mediu;
    }

    public boolean getRidicat()
    {
        return ridicat;
    }
}
