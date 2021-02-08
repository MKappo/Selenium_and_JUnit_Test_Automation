package numeros;

public class Numeros {

    public boolean eUmaUnidade(int meuNumero) {
        boolean eUnidade = true;

        if (meuNumero > 9){
            eUnidade = false;
        }

        return eUnidade;
    }

    public boolean eUmaDezena(int meuNumero) {
        boolean eDezena = true;

        if (meuNumero < 10 || meuNumero > 99){
            eDezena = false;
        }

        return  eDezena;
    }
}
