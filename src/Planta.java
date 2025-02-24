import enums.Familia;
import enums.GrauDefesa;

public class Planta extends SerVivo{
    private Familia familia;
    public GrauDefesa grauDefesa;

    public Planta(String especie, int idade, String nome, String pais, Familia familia, GrauDefesa grauDefesa) {
        super(especie, idade, nome, pais);
        this.familia = familia;
        this.grauDefesa = grauDefesa;
    }

    public Familia getFamilia() {
        return familia;
    }

    public GrauDefesa getGrauDefesa() {
        return grauDefesa;
    }
}
