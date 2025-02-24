import java.util.ArrayList;

import static enums.Dieta.CARNIVORO;

public class MeioAmbiente {
    private String nome;
    private double qtdAguaAmbiente;
    private ArrayList<SerVivo> seres;

    public MeioAmbiente(String nome, double qtdAgua) {
        this.nome = nome;
        this.qtdAguaAmbiente = qtdAguaAmbiente;
        this.seres = new ArrayList<>();
    }

    // A quantidade de água que a planta bebe depende da sua família:
    // árvores bebem 1L, flores bebem 0.1L e ervas bebem 0.25L

    public boolean plantaBebe (Planta plantaAtual) {

        double qtdAguaPlanta = 0;

        switch (plantaAtual.getFamilia()) {
            case ÁRVORES:
                qtdAguaPlanta = 1.0;
                break;
            case FLORES:
                qtdAguaPlanta = 0.1;
                break;
            case ERVAS:
                qtdAguaPlanta = 0.25;
                break;
            case COMEINSETOS:
                qtdAguaPlanta = 0.5;
                break;
            default:
                return false;
        }

        // Verifica se há água suficiente para a planta beber
        // Se houver, diminui a quantidade de água no ambiente e retorna true
        // Caso contrário, a planta seca e é removida do ambiente e retorna false

         if (qtdAguaPlanta > this.qtdAguaAmbiente) {
              this.seres.remove(plantaAtual);
            return false;
        } else {
            this.qtdAguaAmbiente -= qtdAguaPlanta;
            return true;
        }

    }

    // Se houver insetos no ambiente, a planta come um e retorna true
    // Caso contrário, a planta morre de fome e é removida do ambiente, retornando false

    public boolean plantaComeInsetos() {
        return true;
    }

    public void plantaAbanaComVento() {
        System.out.println("Está muito vento!");
    }

    // Imprime na tela o barulho do animal

    public void animalFazBarulho() {
        System.out.println("Barulho do animal");
    }

   // Imprime na tela "O (nome do animal) movimentou-se"
    public void animalMovimenta (Animal animal) {
        System.out.println("O "+animal.getEspecie()+" movimentou-se");
    }

    // Verifica se há água suficiente para o animal beber
    // Se houver, diminui a quantidade de água no ambiente e retorna true
    // Caso contrário, o animal morre de sede e é removido do ambiente, retornando false.
    //A quantidade de água que o animal bebe depende do seu peso: 0.025L por kg

    public boolean animalBebe(Animal animalAtual) {
        double qtdAguaAnimal = animalAtual.getPeso() * 0.025;

        if (qtdAguaAnimal > this.qtdAguaAmbiente) {
           removerSerVivo(animalAtual);
           return false;
        } else {
            this.qtdAguaAmbiente -= qtdAguaAnimal;
            return true;
        }
    }




    // Se o animal for onívoro, ele tenta comer qualquer ser vivo.
    // Ao tentar comer uma planta, a inteligência do animal influencia sua capacidade de evitar
    // os mecanismos de defesa da planta.
    // Ao tentar comer outro animal, o peso e a inteligência dos dois animais são usados para
    // determinar quem vence a luta.
    // Ao tentar comer um inseto venenoso, o animal morre

    public void animalCome(Animal animalAtual) {

        // Verifica se o animal está com fome e, se estiver, tenta comer outro ser vivo do ambiente

        if (animalAtual.isFome()) {
                    for (int i = 0; i < seres.size(); i++) {

                    SerVivo serVivoAtual = this.seres.get(i);

                    switch (animalAtual.getDieta()) {
                        // Se o animal for carnívoro, ele tenta comer outro animal ou inseto
                        case CARNIVORO:
                            if (serVivoAtual instanceof Animal || serVivoAtual instanceof Inseto)
                            {
                                removerSerVivo(serVivoAtual);
                            }
                            break;
                        // Se o animal for herbívoro, ele tenta comer uma planta
                        case HERBIVORO:
                            if (serVivoAtual instanceof Planta)
                            {
                                removerSerVivo(serVivoAtual);
                            }
                            break;
                        //Se o animal for onívoro, ele tenta comer qualquer ser vivo.
                        case ONIVORO:
                            removerSerVivo(serVivoAtual);
                            break;
                    }

                    animalAtual.setFome(false);
            }
        }

        // Se o animal for carnívoro, ele tenta comer outro animal ou inseto.
    }

    public String insetoChateia() {
        return "Barulho do inseto";
    }

    public void adicionarSerVivo(SerVivo serVivoAtual) {
        this.seres.add(serVivoAtual);
    }

    public void removerSerVivo(SerVivo serVivoAtual) {
        this.seres.remove(serVivoAtual);
    }

    public void listarSeresVivos() {}

}
