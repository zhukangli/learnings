package com.conley.construtType.decorator;

public class Decorator implements Component{
    private Component component;
    
    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // ί�ɸ�����
        component.sampleOperation();
    }
    
}