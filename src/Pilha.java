public class Pilha {

    private Music[]elements;
    private int top;

    public Pilha(int capacity) {
        elements = new Music[capacity];
        top = -1;
    }
    public void push(Music registerMusic) {
        if (top == elements.length - 1) {
            System.out.println("A pilha esta cheia");
            return;
        }
        elements[++top] = registerMusic; //empilha o valor na proxima posição vazia
    }

    public Music pop() {
        if (top == -1) {
            System.out.println("A pilha esta vazia");
            return null;
        }
        return elements[top--]; //apenas atualiza o index do top do array tirando 1,
        // mas o valor que era para ser tirado ainda esta lá, e se for feito um push, ele vai sobrescrever o valor
    }

    public void show() {
        if (top == -1) {
            System.out.println("Pilha vazia!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i]);
        }

    }
}
