package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    private Numeros numeros;

    @Before
    public void setUp(){
        numeros = new Numeros();
    }

    @Test
    public void testValidarSeUmNumeroEUmaUnidade(){
        // Vou utilizar o método eUmaUnidade passando o valor 9, que trata-se de uma únidade
        boolean eUnidade = numeros.eUmaUnidade(9);

        //Vou validar que a resposta é verdadeira
        Assert.assertTrue(eUnidade);
    }

    @Test
    public void testValidaSeUmNumeroNaoEUmaUnidade(){
        // Vou utilizar o método eUmaUnidade passando o valor 10, que não se trata de uma únidade
        boolean eUnidade = numeros.eUmaUnidade(10);

        //Vou validar que a resposta é falsa
        Assert.assertFalse(eUnidade);
    }

    @Test
    public void testValidarSeUmNumeroEUmaDezena(){
        // Vou utilizar o método eUmaDezena passando o valor 99, que trata-se de um dezena
        boolean eDezena = numeros.eUmaDezena(99);

        //Vou validar que a resposta é verdadeira
        Assert.assertTrue(eDezena);
    }
}
