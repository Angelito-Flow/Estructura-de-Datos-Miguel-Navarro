package ListasLigadas;

public class Nodo <T>{

    private T value;

    private Nodo <T> next;

    public Nodo() {}

    public Nodo(T valor) {
        this.value = valor;}

    public Nodo(T dato, Nodo <T> siguiente) {
        this.value = dato;
        this.next = siguiente;}

    public Nodo <T> getNext() {
        return next;}

    public void setNext(Nodo <T> siguiente) {
        this.next = siguiente;}

    public T getDato() {
        return value;}

    public void setDato(T dato) {
        this.value = dato;}

    @Override
    public String toString() {
        return "/" + value + "";}
}