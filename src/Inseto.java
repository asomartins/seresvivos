public class Inseto extends SerVivo{
    private boolean venenoso;

    public Inseto(String especie, int idade, String nome, String pais, boolean venenoso) {
        super(especie, idade, nome, pais);
        this.venenoso = venenoso;
    }
}
