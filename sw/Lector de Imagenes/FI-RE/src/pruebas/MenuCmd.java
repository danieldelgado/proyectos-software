package pruebas;
import java.io.*; 
class MenuCmd{
	void Author(){
		System.out.print("nnttThanks for trying, July 2008 - Gerardo Angeles Nava, Mexico, D.F.nn");			
	}
	void MainOptionA(){
		this.SubMenu1();
	}
	void MainOptionB(){
		System.out.print("nttselect main option Bn"); 
	}
	void MainOptionC(){
		System.out.print("nttselect main option Cn"); 
	}
	void SubMenu1(){
		System.out.print("nt.===============.================.===============.===============.n");
		System.out.print("nt| Option 1 [a]  |  Option 2 [b]  |  Option 3 [c] |    Exit  [e]  |n");
		System.out.print("nt`===============`================`===============`===============`n");
 
		while(true){		
			try {
				System.out.print("ntSub Option A1: "); 
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				String s = br.readLine();
 
				if(s == null){
					this.Author();
					System.exit(1);
				}
 
				//If BufferedReader can not convert to int, assign an invalid option like zero for example.
				try{
					int iTmp = Integer.parseInt(s);
					s = "";
				}catch(Exception e){
					;
				}
				try{
					if(s.equals("a")){
						System.out.print("nttselect submenu A1-an"); 
					}else{
						if(s.equals("b")){
							System.out.print("nttselect submenu A1-bn"); 
						}else{
							if(s.equals("c")){
								System.out.print("nttselect submenu A1-cn"); 
							}else{
								if(s.equals("e")){
									//Exit to show Main Menu options or break to not show them
									this.MenuMain();
								}else{
									System.err.println("nttPlease enter a valid option!");	
								}
							}						
						}
					}
				}catch(Exception e){
					System.exit(1); 
				}
			}catch(IOException ioe) { 
				System.out.println("IO error trying to read input"); 
				System.exit(1); 
			} 
		}
	} 
 
	void MenuMain(){
		System.out.print("nt.---------------.----------------.---------------.---------------.n");
		System.out.print("nt| Option A [1]  |  Option B [2]  |  Option C [3] |    Exit  [4]  |n");
		System.out.print("nt`---------------`----------------`---------------`---------------`n");
 
		while(true){		
			try {
				System.out.print("ntMain Option: "); 
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				String s = br.readLine();
 
				if(s == null){
					this.Author();
					System.exit(1);
				}
 
				//If BufferedReader can not convert to int, assign an invalid option like zero for example.
				try{
					int iTmp = Integer.parseInt(s);
				}catch(Exception e){
					s = "0";
				}
 
				switch(Integer.parseInt(s)) {
					case 1: 
						this.MainOptionA();
						break;				
					case 2: 
						this.MainOptionB();
						break;
					case 3: 
						this.MainOptionC();
						break;
					case 4: 
						this.Author();
						System.exit(1); 
					default: 
						System.err.println("nttPlease enter a valid option!");	
				}
			}catch(IOException ioe) { 
				System.out.println("IO error trying to read input"); 
				System.exit(1); 
			} 
		}
	} 
	public static void main(String[] args){ 
		MenuCmd Menu = new MenuCmd(); 
		Menu.MenuMain();
	}//end main   
}//end class