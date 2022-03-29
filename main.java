import java.util.Scanner;
class No {

    public String nome;
    public No proximo;
    public No anterior;

    public No(String nome){
        this.nome = nome;
        proximo = null;
    }

}

class Lista {

    private No primeiro;
    private No ultimo;

    public Lista(){
        primeiro = null;
        ultimo = null;

    }

    public void add(String elemento){

        No novo = new No(elemento);

        if(primeiro == null){
            primeiro = novo;
            ultimo = novo;
            novo.proximo = null;
            novo.anterior = null;
        }
        else{
            No aux = primeiro;
            while (aux != null && novo.nome.compareTo(aux.nome) > 0){
                aux = aux.proximo;
            }
            if(aux == primeiro){
                novo.proximo = primeiro;
                novo.anterior = null;
                primeiro.anterior = novo;
                primeiro = novo;
            }
            else if(aux == null){
                ultimo.proximo = novo;
                novo.anterior = ultimo;
                ultimo = novo;
                ultimo.proximo = null;
            }
            else{
                novo.proximo = aux;
                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                aux.anterior = novo;
            }
        }
    }

    public void mostrar(){
        No aux = primeiro;
        while(aux != null){
            if(aux.anterior != null){
                if(!aux.nome.equalsIgnoreCase(aux.anterior.nome)){
                    System.out.print(aux.nome + " ");
                }
            }
            else{
                System.out.print(aux.nome + " ");
            }
            aux = aux.proximo;
        }
    }

}


class Main {
  
  public static void main(String args[]) { 

      Lista lista = new Lista();

      Scanner entrada = new Scanner(System.in);

        int qtd = Integer.parseInt(entrada.nextLine());


        for(int i = 0; i < qtd; i++){
          String cod = entrada.nextLine();
          lista.add(cod);
        }    

    lista.mostrar();
    
  } 
}
