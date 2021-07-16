package br.com.mathewsalves.util;

public enum MessageEnum {
	
	ENTITY_NOT_FOUND("Não foi encontrado registro para o usuário informado."),
	INVALID_CPF("O CPF informado é inválido.");
    
    private final String value;
    
    MessageEnum(String value){
    	this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
