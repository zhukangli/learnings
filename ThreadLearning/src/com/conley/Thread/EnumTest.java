package com.conley.Thread;

public enum EnumTest {
	MON(1),QUE(2){
		public boolean isReset(){
			return true;
		};
	};
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	private EnumTest(int i){
		this.i=i;
	}
	public boolean isReset(){
		return false;
	}

	public static void main(String[] args) {
		boolean flag=EnumTest.QUE.isReset();
		System.out.println(flag);
		switch(EnumTest.MON.getI()){
		case 1:
			System.out.println("ÕıÈ·");
			break;
		}

	}
}
