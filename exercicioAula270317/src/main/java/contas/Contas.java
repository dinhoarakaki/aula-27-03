package contas;

public class Contas {
	private int n1;
	private int n2;
	private String op;
	
	public Contas(){
	
	}
	public Contas(int n1, int n2, String op){
		this.setN1(n1);
		this.setN2(n2);
		this.setOp(op);
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	public double resultado(){
		double total=0;
		
		if (this.getOp().equals("som")){
			total=this.getN1()+this.getN2();
		}else if (this.getOp().equals("sub")){
			total=this.getN1()-this.getN2();
		}else if (this.getOp().equals("mult")){
			total=this.getN1()*this.getN2();
		}else if (this.getOp().equals("div")){
			total=this.getN1()/this.getN2();
		}else{
			total=0;
		}
		return total;
	}
	
}
