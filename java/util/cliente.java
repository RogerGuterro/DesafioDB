package util;

public class cliente {
	
	 	protected String nome;
	    protected String sobrenome;

	    public cliente(String nome, String sobrenome)
	    {
	        this.nome = nome;
	        this.sobrenome = sobrenome;      
	    }
	    
	    public void setNome(String nome)
	    {
	        this.nome = nome;
	    }

	    public String getNome()
	    {
	        return this.nome;
	    }
	    
	    public void setSobrenome(String sobrenome)
	    {
	        this.sobrenome = sobrenome;
	    }

	    public String getSobrenome()
	    {
	        return this.sobrenome;
	    }
	    
}