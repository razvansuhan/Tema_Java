
public class Student implements Human<Human> {
    String nume,prenume,acronim;
    Integer varsta,an_studiu;
    @Override
    public void greeting() {

    }

    @Override
    public void doWork() {

    }

    @Override
    public int compareTo(Human o) {
        return Integer.compare(this.get_varsta(),o.get_varsta());
    }

    @Override
    public Integer get_varsta() {
        return this.varsta;
    }

    public Student(String nume, String prenume, int an_studiu, String acronim, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.an_studiu = an_studiu;
    }

    @Override
    public String toString() {
        return "[Sd. " +
                nume + ' ' +
                 prenume  + ", Anul " + an_studiu +
                ", Fac. " + acronim +
                ", Varsta " + varsta+"]";
    }
}
