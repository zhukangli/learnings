package com.conley.construtType.composite;

public class FinanceDepartment extends Company{
	public FinanceDepartment(){  

	}  

	public FinanceDepartment(String name){  
		super(name);  
	}  

	@Override
	protected void add(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void romove(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void display(int depth) {
		StringBuilder sb = new StringBuilder("");  
		for (int i = 0; i < depth; i++) {  
			sb.append("-");  
		}  
		System.out.println(new String(sb) + this.getName() ) ;  

	}

}
