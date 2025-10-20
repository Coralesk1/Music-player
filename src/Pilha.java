public class Pilha {

    private String[] elements;
    private int top;

    public Pilha(int capacity) {
        elements = new String[capacity];
        top = -1;
    }

    public void push(String valor) {
        if (top == elements.length - 1) {
            System.out.println("A pilha esta cheia");
            return;
        }
        elements[++top] = valor; //empilha o valor na proxima posi��o vazia
    }

    public String pop() {
        if (top == -1) {
            System.out.println("A pilha esta vazia");
            return null;
        }
        return elements[top--]; //apenas atualiza o index do top do array tirando 1,
        // mas o valor que era para ser tirado ainda esta l�, e se for feito um push, ele vai sobrescrever o valor
    }

    public void show() {
        if (top == -1) {
            System.out.println("Pilha vazia!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }

    }
}
