import java.util.Scanner;

public class prova01 {
  public static final int TAM = 5;
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int[] a = new int[] { 1, 2, 3, 4, 5 };
    int[] b = new int[] { 5, 6, 8, 7, 4 };
    int[] uniao = new int[2 * TAM];
    int[] vcr = new int[] { 1, 2, 2, 3, 4, 4, 5, 1, 2, 3, 4, 5 };
    int[] vsr = new int[3 * TAM];

   
    System.out.print("Conjunto A: ");
    imprimir(a, TAM);
    System.out.print("Conjunto B: ");
    imprimir(b, TAM);
    System.out.println("\n\nORDENAR\n");
    ordenar(a, TAM);
    ordenar(b, TAM);
    System.out.print("Conjunto A: ");
    imprimir(a, TAM);
    System.out.print("Conjunto B: ");
    imprimir(b, TAM);
    int tamUniao = uniao(a, TAM, b, TAM, uniao);
    System.out.print("Conjunto União: ");
    imprimir(uniao, tamUniao);
    int tamVSR = gerarVetorSemRepeticao(vcr, vcr.length, vsr);
    System.out.print("Vetor com repetição: ");
    imprimir(vcr, vcr.length);
    System.out.print("Vetor sem repetição: ");
    imprimir(vsr, tamVSR);
  }

  public static void imprimir(int[] v, int tam) {
    System.out.print("{");
    if (tam > 0) {
      System.out.print(" " + v[0]);
    }
    for (int i = 1; i < tam; i ++) {
      System.out.print(", " + v[i]);
    }
    System.out.println(" }");
  }

  public static void preencherDigitacao(int[] v) {
    for (int i = 0; i < v.length; i ++) {
      System.out.print("Digite o " + (i + 1) + "º valor: ");
      v[i] = input.nextInt();
    }
  }

public static int busca(int[] v, int tam, int valor) {
    for (int i = 0; i < tam; i++) {
        if (v[i] == valor) {
            return i;
        }
    }
    return -1;
}

  public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {

    int tamU = 0;

    for (int i = 0; i < tamA; i++) {
        if (busca(u, tamU, a[i]) == -1) {
            u[tamU] = a[i];
            tamU++;
        }
    }

    for (int i = 0; i < tamB; i++) {
        if (busca(u, tamU, b[i]) == -1) {
            u[tamU] = b[i];
            tamU++;
        }
    }

    return tamU;
}

  public static void ordenar(int[] v, int tam) {

    for (int i = 1; i < tam; i++) {

        int chave = v[i];
        int j = i - 1;

        while (j >= 0 && v[j] > chave) {
            v[j + 1] = v[j];
            j--;
        }

        v[j + 1] = chave;
    }
}

  public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {

    int tamNovo = 0;

    for (int i = 0; i < tamV; i++) {
        if (busca(vsr, tamNovo, v[i]) == -1) {
            vsr[tamNovo] = v[i];
            tamNovo++;
        }
    }

    return tamNovo;
}

  public static void rotacionar(int[] v, int tam, int k) {

    if (tam == 0) return;

    k = k % tam;

    if (k < 0) {
        k += tam;
    }

    for (int r = 0; r < k; r++) {

        int primeiro = v[0];

        for (int i = 0; i < tam - 1; i++) {
            v[i] = v[i + 1];
        }

        v[tam - 1] = primeiro;
    }
  }
}