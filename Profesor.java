public class Profesor implements Human<Human>{
    String nume,prenume,acronim,materie;
    Integer varsta;
    @Override
    public void greeting() {

    }

    @Override
    public void doWork() {

    }
    public Profesor(String nume, String prenume, String acronim, int varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.materie = materie;
        this.varsta = varsta;
    }

    @Override
    public Integer get_varsta() {
        return this.varsta;
    }

    @Override
    public int compareTo(Human o) {
        return Integer.compare(this.get_varsta(),o.get_varsta());
    }

    public String toString() {
        return "[Prof. " +
                nume + ' ' +
                prenume  +
                ", Fac. " + acronim +
                ", Varsta " + varsta +
                ",Materia predata-" + materie +
                "]";
    }
}
