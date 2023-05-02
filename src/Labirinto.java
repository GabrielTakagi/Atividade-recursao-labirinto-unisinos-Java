import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Labirinto {

	private char labirinto[][];
	private boolean saida;
    
    public void carregaLabirinto(String fileName) throws IOException{
		int l, c;
        BufferedReader buffRead = new BufferedReader(new FileReader(fileName));

		//Crair o arrayBidimencional
		c = Integer.parseInt(buffRead.readLine());
		l = Integer.parseInt(buffRead.readLine());
		labirinto = new char [c][l];
		
		//Recolher o Char das arquivo txt e colocar o arrayBidimencional
		for (int i = 0; i < c; i++){
			String linha = buffRead.readLine();

			if (linha != null){
				for (int z = 0; z < l; z++){
					this.labirinto[i][z] = linha.charAt(z);
				}
			}else{
				break;
			}
		}
		buffRead.close();
	}
    
	public void verificarLabirinto(){
		boolean verificar;
		int l = 0, c = 0;

		if (this.labirinto[c][l] != 'X'){
			verificar = verificarLabirintoRecursivo(c, l, this.labirinto);

		}else{
			verificar = false;
		}

		this.saida = verificar;		
	}

	private boolean verificarLabirintoRecursivo(int c, int l, char[][] labirinto){

		char labirintoVerificado[][] = labirinto;
		int posicoes[][] = {{c-1,l},{c,l-1},{c+1,l},{c,l+1}};
		boolean verificado = false;

		labirintoVerificado[c][l] = '.';

		printLabirinto();

		for(int i = 0; i < posicoes.length; i++){

			int c1 = posicoes[i][0];
			int l1 = posicoes[i][1];

			if( verificado == true){
				break;
			}

			if (c1 != -1 && l1 != -1 && c1 < labirintoVerificado.length && l1 < labirintoVerificado[i].length){
				switch(labirintoVerificado[c1][l1]){
					case 'X':
						verificado = false;
						break;
					
					case '.':
						verificado = false;
						break;
					
					case 'D':
						verificado = true;
						break;
					
					default:
						verificado = verificarLabirintoRecursivo(c1, l1, labirintoVerificado);
				}
			}
		}

		return verificado;
	}

	public void escreverTxt(){
		String text = "Resultado.txt";

		try
        {
            BufferedWriter br = new BufferedWriter(new FileWriter(text));
            
			if (saida == true){
				br.write("O labirinto tem saida");
			}else{
				br.write("O labirinto nao tem saida");
			}

			br.close();
            
        }        
        catch(IOException e){
        }
	}

	private void printLabirinto(){
		for(int i = 0; i < this.labirinto.length; i++){
			for(int x = 0; x < this.labirinto[i].length; x++){
				System.out.print(this.labirinto[i][x]);
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------");
	}
}	
