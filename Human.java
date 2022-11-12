public interface Human<T> extends  Comparable<T>{
    void greeting();
    void doWork();

    int compareTo(Human o);

    Integer get_varsta();
}
