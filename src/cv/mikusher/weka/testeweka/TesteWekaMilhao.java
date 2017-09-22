/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A ideia é fazer a previsão dos resultados do EM
 * usando a biblioteca Weka e usando o algoritmo IBk
 * ainda em faze de teste.
 */





package cv.mikusher.weka.testeweka;





import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;





/**
 *
 * @author latavares
 */
public class TesteWekaMilhao {

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) throws Exception {

        final int TAMANHO_DA_CARTELA = 7; // TICKET_SIZE

        Instances data = carregamentoFicheiro(); // loadFile

        //
        IBk k3 = new IBk();
        k3.buildClassifier(data);

        // Criação da nova instancia

        // essa parte deve ser melhorada no futuro :P
        DenseInstance primeiro_numero = new DenseInstance(TAMANHO_DA_CARTELA);
        primeiro_numero.setDataset(data);

        DenseInstance segundo_numero = new DenseInstance(TAMANHO_DA_CARTELA);
        segundo_numero.setDataset(data);

        DenseInstance terceiro_numero = new DenseInstance(TAMANHO_DA_CARTELA);
        terceiro_numero.setDataset(data);

        DenseInstance quarto_numero = new DenseInstance(TAMANHO_DA_CARTELA);
        quarto_numero.setDataset(data);

        DenseInstance quinto_numero = new DenseInstance(TAMANHO_DA_CARTELA);
        quinto_numero.setDataset(data);

        DenseInstance primeira_estrela = new DenseInstance(TAMANHO_DA_CARTELA);
        primeira_estrela.setDataset(data);

        DenseInstance segunda_estrela = new DenseInstance(TAMANHO_DA_CARTELA);
        segunda_estrela.setDataset(data);

        gerarChave(primeiro_numero, segundo_numero, terceiro_numero, quarto_numero, quinto_numero, primeira_estrela, segunda_estrela);

        // classificação da nova instância
        /*
        double pred_num_1 = k3.classifyInstance(primeiro_numero);
        double pred_num_2 = k3.classifyInstance(segundo_numero);
        double pred_num_3 = k3.classifyInstance(terceiro_numero);
        double pred_num_4 = k3.classifyInstance(quarto_numero);
        double pred_num_5 = k3.classifyInstance(quinto_numero);
        // estrelas
        double pred_str_1 = k3.classifyInstance(primeira_estrela);
        double pred_str_2 = k3.classifyInstance(segunda_estrela);

        //
        // System.out.println("Predição percentual: " + pred_str_1);
        Attribute atb = data.attribute(6);
        String predClass = atb.value((int) pred_str_1);
        System.out.println("Privisão dos proximos numeros e estrela");
        System.out.println("Numeros: \n" + "Numero 1: " + Math.round(pred_num_1) + "" + "\nNumero 2: " + Math.round(pred_num_2) + "\nNumero 3: " + Math.round(pred_num_3) + "\nNumero 4: "
                           + Math.round(pred_num_4) + "\nNumero 5: " + Math.round(pred_num_5) + "\n");
        System.out.println("Estrelas: \n" + "Estrela 1: " + Math.round(pred_str_1) + "\nEstrela 2: " + Math.round(pred_str_2));
        */
    }





    /**
     * @return
     * @throws Exception
     */
    private static Instances carregamentoFicheiro() throws Exception {

        // criação do datasouce, indicando o caminho da BD "vendas"
        DataSource source = new DataSource("src/cv/mikusher/weka/testeweka/milhao.arff");

        // pega as instancias da base de dados
        Instances data = source.getDataSet();

        if (data.classIndex() == -1) {
            data.setClassIndex(data.numAttributes() - 1);
        }
        return data;
    }





    /**
     * @param primeiro_numero
     * @param segundo_numero
     * @param terceiro_numero
     * @param quarto_numero
     * @param quinto_numero
     * @param primeira_estrela
     * @param segunda_estrela
     */
    private static void gerarChave(DenseInstance primeiro_numero, DenseInstance segundo_numero, DenseInstance terceiro_numero, DenseInstance quarto_numero, DenseInstance quinto_numero,
                                   DenseInstance primeira_estrela, DenseInstance segunda_estrela) {

        // numeros a ser passado
        // numeros da cartela
        primeiro_numero.setValue(0, 15);
        segundo_numero.setValue(1, 17);
        terceiro_numero.setValue(2, 38);
        quarto_numero.setValue(3, 41);
        quinto_numero.setValue(4, 42);

        // chaves estrelas
        primeira_estrela.setValue(5, 9);
        segunda_estrela.setValue(6, 12);
    }
}