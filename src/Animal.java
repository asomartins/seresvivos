import enums.Dieta;

public class Animal extends SerVivo{
    private boolean fome;
    private double peso;
    private int inteligencia;
    private Dieta dieta;
    private String barulho;

    public Animal(String especie, int idade, String nome, String pais, String barulho, Dieta dieta, boolean fome, int inteligencia, double peso) {
        super(especie, idade, nome, pais);
        this.barulho = barulho;
        this.dieta = dieta;
        this.fome = fome;
        this.inteligencia = inteligencia;
        this.peso = peso;
    }

    public boolean isFome() {
        return fome;
    }

    public double getPeso() {
        return peso;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setFome(boolean fome) {
        this.fome = fome;
    }
}
